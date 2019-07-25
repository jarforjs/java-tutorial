import { Button } from 'antd';
import React, { useState, useCallback, useEffect, useRef } from 'react';
import Code from '../components/Code';

const App = () => {
  const [count, setCount] = useState(0);
  const timer = useRef(null);

  const clearEffect = useCallback(() => {
    window.clearInterval(timer.current);
  }, []);

  useEffect(()=>{
    timer.current = window.setInterval(()=>{
      setCount(c=>c+1);
    }, 1000)

    return clearEffect;
  }, [])

  return (
    <div>
      <p>这个例子是一个计时器，每秒钟（并不精确）会增加 count，你可以通过一个按钮停止它的自增。这里我们就用到了 useRef 生成了一个持久化的变量。 </p>
      <p>const ref = useRef(initialValue) 会把 initialValue 储存在 ref.current 中，在之后的代码里，可以随时读写 ref.current 的值。ref 的改变不会触发组件重新渲染。因此很适合做一些与 UI 无关的数据储存，而不仅仅局限于 DOM节点。例如上面例子中的 timer，甚至是一个可执行的函数等等。</p>
      <div>{count}</div>
      <Button onClick={clearEffect}>停止</Button>
      <Code language='jsx'>
        {`  const [count, setCount] = useState(0);
  const timer = useRef(null);

  const clearEffect = useCallback(() => {
    window.clearInterval(timer.current);
  }, []);

  useEffect(()=>{
    timer.current = window.setInterval(()=>{
      setCount(c=>c+1);
    }, 1000)

    return clearEffect;
  }, [])

  return (<div>
    <div>{count}</div>
    <Button onClick={clearEffect}>停止</Button>
  </div>)`}
      </Code>
    </div>
  )
};

export default App
