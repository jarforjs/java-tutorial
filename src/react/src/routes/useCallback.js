import { Button as Btn, message } from 'antd';
import React, { useState, useCallback } from 'react';

const Button = (props) => {
  message.error('Button get re-rendered')
  return (<Btn onClick={props.onAdd}>add</Btn>)
};

const App = () => {
  const [ count, setCount ] = useState(1);

  const add = useCallback(() => setCount(c => c + 1), []);
  return (
    <div>
      <div>{count}</div>
      <Button onAdd={add} />
    </div>
  )
};

export default App
