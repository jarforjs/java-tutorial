# hooks入门
### useState
useState 可以理解为一个普通 JavaScrip的函数，他的入参有两种类型：
1. initialValue, 直接传入一个变量，将作为该 state 的初始值。
2. () => initialValue, 传入一个函数，函数的返回值将作为 state 的初始值，
> 在上面的例子中， const [count, setCount] = useState(0); 代表 count 的初始值是 0.

useState 的返回值是一个数组，格式为 [state, setState], 数组中的第一个元素是 state 的当前值，第二个元素是一个函数，用于设置 state 的值，setState 同样接受两种类型的参数：
1. stateValue，直接传入变量作为 state 的当前值。
2. (prevState) => newState, 传入一个函数，函数的返回值将作为 state 的值，这个函数可以通过闭包拿到上一个 state 的值，这个值往往非常有用。
> 上面的例子中， onClick={()=>setCount(c=>c+1)} 代表，设置 count 的值，为 count 之前值 + 1.

### useEffect
useEffect, 顾名思义，就是“使用副作用”，通常用到 Effect 的情况包括：设置定时器，发送网络请求等。先来看一下 useEffect 的构成：
```
useEffect(callback, deps?)
```
useEffect 接收两个参数，第一个是必传的 callback，第二个是选传的 dependencies, 类型为列表。例如 [a, b]。
可以理解为，每当 dependencies 中的一个或多个元素发生改变时，都会去执行一遍 callback. 
两个特殊情况是：
1. deps 为空列表 [], 则 callback 只会在组件 mount 时被执行。
2. 不传入 deps 参数，则每当 state 或者 props 发生变化（组件重新渲染）时，callback 都会被执行。

这是一个很重要的概念，了解了 deps 的机制就了解了 hooks 的一半。后面会用到的其他 hooks 比如 **useLayoutEffect, useMemo, useCallback**，都会共享 deps 这一概念。

另外针对 useEffect 的 callback，如果 callback 返回了一个函数，则这个函数会在 deps 改变后，下一次 callback 执行之前。如果比较晦涩，可以看下面的例子：
```
useEffect(()=>{
  const timer = window.setInterval(()=>{console.log(a)}, 1000);
  return () => window.clearInterval(timer);
}, [a])
```
当 a 发生改变时，旧的 timer 会被 clear 掉，新的 timer 会重新生成。所以 useEffect callback 的 return 函数是清理副作用的最佳时机。
```
useEffect(()=>{
  const timer = window.setInterval(()=>{console.log(a)}, 1000);
  return () => window.clearInterval(timer);
}, [])
```
当 deps 为空列表时，useEffect 相当于 class 组件中的 componentDidMount 生命周期，return 函数的执行时机则相当于 componentWillUnmount.

在了解了 useState 和 useEffect 两个最基本的 hooks 后，如果不考虑性能的问题，已经可以满足业务中的绝大部分需求了，但是如何把这两个 hooks 和其他的 hooks 结合，并且优雅的实现业务的需求呢？请查看下一篇 Hooks 进阶。

### useRouter
可以帮助我们针对复杂 state 结构的局部进行修改

### useMemo
和 useEffect 类似，useMemo 同样接受一个 callback 和一个 deps 列表。只有当 deps 发生变化时，memo 才会重新执行，并把 callback 的返回值传递给变量。如果 useMemo 的 deps 传入了一个空列表[], 那么这一函数只会在组件初始化的时候被执行。

### 抽出Button作为子组件，同时将增加计数的方法传递给这个组件
- 可以看到，我们每次点击 add，子组件都会被重新渲染一遍。对于复杂的子组件，这个开销显然是太大了，我们先来分析一下出现这个问题的原因：
- 首先可以看到的问题是，传递给 Button 的 props 在每次渲染时都是变化的，props 变化自然会触发组件的重新渲染。我们知道在 class component 里，声明的方法都是拥有静态引用的(this.someFunc()), 但是在 function component 里，每次重新渲染都会对变量进行垃圾回收和变量的新建。在上面的例子中，add 这个方法的引用就会发生改变，React 就会认为 add 发生了变化，于是重新渲染了 Button 组件。
> 从下面代码中可以看出这之间的区别
```
const a = () => alert(1);
const b = a;
b === a;//=>true
(() => alert(1)) === (() => alert(1));//=>false
```
前面介绍的 useMemo 是为了解决**变量**被回收和重建的问题，对于**方法**，对应的 hook 则是 useCallback.

### useCallback
useCallback 可以确保在每次重新渲染后，函数的引用地址保持不变。

但是问题并没有解决，每次点击 Button，Button 都会被重新渲染，但是现在我们已经确定了 Button 的 props 是没有变化的。在 class component 里，我们知道只有 pureComponent 才会根据 props 的状态 bail out render, 在 function 中也是类似的，只有结合 memo 才能实现 pureComponent 的效果。

### React.memo => pureComponent
结合了 memo 的 function component 就和 pureComponent 无异了，通过下面的例子我们可以看出来，button 确实已经不会重新渲染了。

- 需要注意区分的是，memo 和 useMemo 的区别。memo 并不算是一个 hook，是 React 16.6 版本加入的功能，可以说是为了推广 hooks 前期做的准备。在使用时，我们可以理解为，useMemo 是针对组件的局部进行缓存优化，而 memo 是针对整个组件的，将组件变成了 pureComponent.
- 在很多情况下，useReducer 和 useCallback 可以形成完美的配合，因为 useReducer 返回的 dispatch 是一个很特殊的函数，React 可以保证在每次重新渲染后，dispatch 的引用地址不发生变化，因此在 useCallback 的 deps 里省略 dispatch 是安全的。很多 bug 的产生都是因为传给了 useCallback 错误的 deps 。而使用 useReducer，可以巧妙的规避这一问题。

### useRef
这是本章介绍的最后一个官方 hook，了解 React 的同学一定了解 ref 的作用，在 class component 中，通常 ref 是为了拿到某个 DOM 节点，但是在 function component 中，ref 的作用不止于此。通过前面的了解，我们知道 function component 中声明的变量，在 rerender 的过程中都会被回收再重建，在很多情况下，我需要持久化保存一些变量，比如 window.setInterval 的返回值，或者 G2，G6 这类图形库新建出来的实例，你需要在 unmount 的过程中调用 destroy 的方法。针对这种情况，你需要使用到的是 useRef。

