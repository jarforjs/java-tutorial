import React, {useState} from 'react';
import {Button} from 'antd';
const App = () => {
  const [count, setCount] = useState(0);
  return (
    <div>
      <div>{count}</div>
      <Button onClick={() => setCount(c => c + 1)}>add</Button>
    </div>
  )
};

export default App;
