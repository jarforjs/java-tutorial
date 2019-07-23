import { Button, message, Divider } from 'antd';
import React, { useState } from 'react';

const COLORS = ['red', 'orange', 'blue'];


const App = () => {
  const [count, setCount] = useState(0);
  const [count2, setCount2] = useState(0);

  message.success('render');
  const color = message.info('color calculate') && COLORS[count % 3];

  return (
    <div>
      <p>我们知道在 count 更新之后，就已经触发了重渲染，如果能在本次渲染中直接更改颜色，不去触发新的渲染，也可以实现我们要的效果。在下面一个例子中，我们在一个组件中实现了两个 counter，其中一个支持随着数值增加去切换颜色，另一个是普通的 counter.</p>
      <p>可以看到每次点击增加，整个组件只会渲染一次，但是同样，因为 color 的计算跟 message.success 是在同一个层级，每次渲染也都会重新计算。这同样也是一笔开销，比如在我们点击下方的计数器时，并不需要对颜色进行修改，但是颜色也被重新计算了。</p>
      <div>
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

export default App;
