import React, {useEffect, useState} from 'react';
import {Button, message} from 'antd';

const COLORS = ['red', 'orange', 'blue'];

function Rerender() {
  const [count, setCount] = useState(1);
  const [color, setColor] = useState(() => COLORS[count % 3]);


  useEffect(() => setColor(COLORS[count % 3]),[count]);

  message.info('render')

  return (
    <div>
      <p>这里我们用到了 setState 的 function 模式，根据 count 的余数决定颜色的初始值，又用了 useEffect 去监听 count 的变化，每次 count 变化我们会重新计算新的字体颜色，看起来一切都很合理，但是当我们增加计数器时，可以看到组件其实是被重新渲染了两次的。</p>
      <div style={{color: color}}>{count}</div>
      <Button onClick={() => setCount(c => c + 1)}>add1</Button>
    </div>
  )
}

const OnceRender = () => {
  const [state, setState] = useState({count: 0, color: 'red'});

  message.info('render');
  return (
    <div>
      <p>那么能否把两次更新合成一个，把 color 和 count 合进了一个 state 中，这样对一个 object 的修改就只会触发一次重渲染了。但是可以看到，onClick 函数的可读性显著下降了，这还只是一个简单的例子，在真实业务场景中，我们可能会有很多不同状态，例如 data, loading, modalVisible, hasError, isEditing... 等等，</p>
      <div style={{color: state.color}}>{state.count}</div>
      <Button
        onClick={() => setState(s => ({...s, count: s.count + 1, color: COLORS[(s.count + 1) % 3]}))}
      >
        add2
      </Button>
    </div>
  )
};

export default OnceRender
