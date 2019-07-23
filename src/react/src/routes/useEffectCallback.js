import React, {useState, useEffect} from 'react';
import {Button} from 'antd';
import Code from '../components/Code';

const App = () => {
  const [value, setValue] = useState(0);

  useEffect(()=>{
    const timer = window.setInterval(()=>{console.log(value)}, 1000);
    return () => window.clearInterval(timer);
  }, [value])

  return (
    <div>
      <div>当前ID：{value}</div>
      <Button onClick={() => setValue(c => c + 1)}>下一个</Button>
      <p>另外针对 useEffect 的 callback，如果 callback 返回了一个函数，则这个函数会在 deps 改变后，下一次 callback 执行之前。如果比较晦涩，可以看下面的例子：</p>
      <Code>
{`useEffect(()=>{
  const timer = window.setInterval(()=>{console.log(value)}, 1000);
  return () => window.clearInterval(timer);
}, [value])`}
      </Code>
      <p>当 a 发生改变时，旧的 timer 会被 clear 掉，新的 timer 会重新生成。所以 useEffect callback 的 return 函数是清理副作用的最佳时机。</p>
      <Code>
{`useEffect(()=>{
  const timer = window.setInterval(()=>{console.log(value)}, 1000);
  return () => window.clearInterval(timer);
}, [])`}
      </Code>
      当 deps 为空列表时，useEffect 相当于 class 组件中的 componentDidMount 生命周期，return 函数的执行时机则相当于 componentWillUnmount.
    </div>
  )
};

export default App;
