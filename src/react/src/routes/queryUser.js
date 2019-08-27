import { Button, message, Spin, Form, Input } from 'antd';
import React, { useReducer, useCallback, useEffect, useRef } from 'react';

// src/service/xxx.js
const queryUser = async (filter) => {
  // 这里应使用 bigfish 的 fetch，
  // 把 filter 注入到请求的参数中，因为是 mock，这里先不处理
  const res = await fetch(`https://mocks.alibaba-inc.com/mock/mkQ5fN3eq/userDelay`);
  return res.json();
}


// src/page/xxx.js
const initFilter = {
  name: '',
  time: '',
  type: '',
};

const initState = {
  filter: initFilter,
  loading: true,
  data: '',
};

// 写一个 reducer，针对开始获取，获取成功，获取失败等情况进行处理
const reducer = (state = initState, action) => {
  switch (action.type) {
    // 开始 fetch，设置 loading 状态为 true
    case 'startFetch':
      return { ...state, loading: true };
    // fetch 成功，储存 data，同时取消 loading
    case 'fetchSuccess':
      return { ...state, loading: false, data: action.payload };
    // fetch 失败，取消 loading
    case 'fetchFailed':
      return { ...state, loading: false };
    // 过滤条件发生改变
    case 'changeFilter':
      return { ...state, filter: { ...state.filter, ...action.payload } };
    default:
      throw new Error();
  }
};

const App = Form.create()((props) => {
  const [state, dispatch] = useReducer(reducer, initState);
  const { getFieldDecorator, getFieldsValue } = props.form;

  // 监听 filter 的变化，当 filter 发生改变，则根据当前 filter 重新搜索;
  useEffect(()=>{
    // 为了避免写错依赖产生 bug，React 官方建议的方法是把函数写在
    // useEffect 内部，避免了依赖的问题。
    const request = async() => {
      dispatch({type: 'startFetch'});
      const { data } = await queryUser(state.filter);
      if(data){
        dispatch({type: 'fetchSuccess', payload: data.name});
      } else {
        message.error('请求失败');
        dispatch({type: 'fetchFailed'});
      }
    }
    // 调用 request 函数。
    request();
  }, [state.filter])

  return (
    <div>
      <div style={{width: 300}}>
        {
          getFieldDecorator('name')(
            <Input placeholder='筛选条件1(name)' />
          )
        }
        {
          getFieldDecorator('time')(
            <Input placeholder='筛选条件2(time)' />
          )
        }
        {
          getFieldDecorator('type')(
            <Input placeholder='筛选条件3(type)' />
          )
        }
        <Button loading={state.loading} onClick={()=>{
          console.log(getFieldsValue());
          dispatch({type: 'changeFilter', payload:getFieldsValue() })
        }}>搜索</Button>
      </div>
      <div>
        <div>搜索条件：{JSON.stringify(state.filter)}</div>
        <div>搜索结果：{state.loading ? <Spin /> : state.data}</div>
      </div>
    </div>
  )
});

export default App
