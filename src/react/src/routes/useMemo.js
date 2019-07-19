import { Button, message, Divider } from 'antd';
import React, { useState, useMemo } from 'react';

const COLORS = ['red', 'orange', 'blue'];


const App = () => {
  const [count, setCount] = useState(0);
  const [count2, setCount2] = useState(0);

  message.success('render');
  const color = useMemo(()=>{
    message.info('color calculate');
    return COLORS[count % 3]
  }, [count]);

  return (
    <div>
      <div>
        <p>只有点击上面带颜色 counter 才会去更新颜色，点击下面的简单 counter 不会触发颜色的重新计算。因为我们的 memo 只监听了 count 的变化，没有监听 count2。</p>
        <p>类似的，如果 useMemo 的 deps 传入了一个空列表[], 那么这一函数只会在组件初始化的时候被执行。</p>
        <div style={{color: color}}>{count}</div>
        <Button
          onClick={()=>{setCount(c=>c+1)}}
        >
          add
        </Button>
      </div>

      <Divider />

      <div>
        <div>{count2}</div>
        <Button
          onClick={()=>{setCount2(c=>c+1)}}
        >
          add
        </Button>
      </div>
    </div>
  )
}

export default App
