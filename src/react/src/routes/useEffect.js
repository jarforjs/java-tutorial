import React, {useState, useEffect} from 'react';
import {Button} from 'antd';
const App = () => {
  const [count, setCount] = useState(1);
  const [name, setName] = useState('');

  useEffect(() => {
    fetch(`https://mocks.alibaba-inc.com/mock/mkQ5fN3eq/user?id=${count}`)
      .then(res=>res.json())
      .then(({name})=>setName(name))
  }, [count]);

  return (
    <div>
      <div>用户ID：{count}</div>
      <div>姓名：{name}</div>
      <Button onClick={() => setCount(c => c + 1)}>下一个</Button>
    </div>
  )
};

export default App;
