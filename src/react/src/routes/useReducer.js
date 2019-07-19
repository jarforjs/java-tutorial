import React, {useReducer} from 'react';
import {Button, message} from 'antd';

const COLORS = ['red', 'orange', 'blue'];
const initState = {count: 0, color: 'red'};

const reducer = (state, action) => {
  switch (action.type) {
    case 'add':
      const count = state.count+1;
      const color = COLORS[count%3];
      return {...state, count, color};
    default:
      throw new Error();
  }
};

const App = () => {
  const [state, dispatch] = useReducer(reducer, initState);

  message.info('render');
  return (
    <div>
      <p>除了合并属性进state，我们还可以使用reducer，使用 reducer 可以帮助我们针对复杂 state 结构的局部进行修改。</p>
      <div style={{color: state.color}}>{state.count}</div>
      <Button
        onClick={() => {
          console.log(dispatch, 'dispatch');
          dispatch({type: 'add'})
        }}
      >
        add
      </Button>
    </div>
  )
};

export default App
