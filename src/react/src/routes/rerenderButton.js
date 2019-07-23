import { Button as Btn, message } from 'antd';
import React, { useState } from 'react';

const Button = (props) => {
  message.error('Button get re-rendered');
  return (<Btn onClick={props.onAdd}>add</Btn>)
};

const App = () => {
  const [ count, setCount ] = useState(1);

  const add = () => setCount(c => c + 1);
  return (
    <div>
      <p>首先可以看到的问题是，传递给 Button 的 props 在每次渲染时都是变化的，props 变化自然会触发组件的重新渲染。我们知道在 class component 里，声明的方法都是拥有静态引用的(this.someFunc()), 但是在 function component 里，每次重新渲染都会对变量进行垃圾回收和变量的新建。在上面的例子中，add 这个方法的引用就会发生改变，React 就会认为 add 发生了变化，于是重新渲染了 Button 组件。</p>
      <div>{count}</div>
      <Button onAdd={add} />
    </div>
  )
};

export default App
