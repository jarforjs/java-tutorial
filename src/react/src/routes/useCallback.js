import { Button as Btn, message } from 'antd';
import React, { useState, useCallback } from 'react';

// const Button = (props) => {
//   message.error('Button get re-rendered')
//   return (<Btn onClick={props.onAdd}>add</Btn>)
// };
//
// const App = () => {
//   const [ count, setCount ] = useState(1);
//
//   const add = useCallback(() => setCount(c => c + 1), []);
//   return (
//     <div>
//       <div>{count}</div>
//       <Button onAdd={add} />
//     </div>
//   )
// };


function TestUseCallback({ num, name, count }) {
  const memoizedCallback = React.useCallback(
    () => {
      // 一些计算
      console.log('abc')
      return num;
    },
    [num],
  );
  console.log('记忆 num > ', memoizedCallback(), name, count)
  console.log('原始 num > ', num, name, count);
  return (
    <div>
      <p>TestUseCallback</p>
    </div>
  )
}

const num1 = [1, 2, 3];
const num2 = [4, 5, 6];
class App extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      num: num1,
      count: 0,
      name: '123'
    };
  }
  componentDidMount() {
    setInterval(() => {
      this.setState((state) => {
        return {
          count: state.count + 1
        }
      })
    }, 3000);
  }
  handleChangeNum = () => {
    this.setState({
      name: 'def',
      num: num2,
    });
  }
  render() {
    const { num, name, count } = this.state;

    return (
      <div className="App">
        <h1>Hello</h1>
        <h2>Start editing to see some magic happen!</h2>
        <button onClick={this.handleChangeNum}>修改传入的Num值</button>
        <TestUseCallback num={num} name={name} count={count}/>
      </div>
    );
  }
}


export default App
