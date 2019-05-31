const actions = new Map([
  [{identity: 'guest', status: 1}, () => {/*do sth*/}],
  [{identity: 'guest', status: 2}, () => {/*do sth*/}],
  //...
]);

const onButtonClick = (identity, status) => {
  let action = [...actions].filter(([key, value]) => (key.identity === identity && key.status === status));
  action.forEach(([key, value]) => value.call(this))
};

// 这里也看出来Map与Object的区别，Map可以用任何类型的数据作为key。
// 我们现在再将难度升级一点点，假如guest情况下，status1-4的处理逻辑都一样怎么办，最差的情况是这样：
const actions1 = new Map([
  [{identity:'guest',status:1},()=>{/* functionA */}],
  [{identity:'guest',status:2},()=>{/* functionA */}],
  [{identity:'guest',status:3},()=>{/* functionA */}],
  [{identity:'guest',status:4},()=>{/* functionA */}],
  [{identity:'guest',status:5},()=>{/* functionB */}],
  //...
])

// 好一点的写法是将处理逻辑函数进行缓存：
const actions2 = ()=>{
  const functionA = ()=>{/*do sth*/}
  const functionB = ()=>{/*do sth*/}
  return new Map([
    [{identity:'guest',status:1},functionA],
    [{identity:'guest',status:2},functionA],
    [{identity:'guest',status:3},functionA],
    [{identity:'guest',status:4},functionA],
    [{identity:'guest',status:5},functionB],
    //...
  ])
}

const onButtonClick2 = (identity,status)=>{
  let action = [...actions()].filter(([key,value])=>(key.identity === identity && key.status === status))
  action.forEach(([key,value])=>value.call(this))
}

// 这样写已经能满足日常需求了，但认真一点讲，上面重写了4次functionA还是有点不爽，假如判断条件变得特别复杂，比如identity有3种状态，status有10种状态，那你需要定义30条处理逻辑，而往往这些逻辑里面很多都是相同的，这似乎也是笔者不想接受的，那可以这样实现:

const actions3 = ()=>{
  const functionA = ()=>{/*do sth*/}
  const functionB = ()=>{/*do sth*/}
  return new Map([
    [/^guest_[1-4]$/,functionA],
    [/^guest_5$/,functionB],
    //...
  ])
}

const onButtonClick3 = (identity,status)=>{
  let action = [...actions()].filter(([key,value])=>(key.test(`${identity}_${status}`)))
  action.forEach(([key,value])=>value.call(this))
}

// 这里Map的优势更加凸显，可以用正则类型作为key了，这样就有了无限可能，假如需求变成，凡是guest情况都要发送一个日志埋点，不同status情况也需要单独的逻辑处理，那我们可以这样写:
const actions4 = ()=>{
  const functionA = ()=>{/*do sth*/}
  const functionB = ()=>{/*do sth*/}
  const functionC = ()=>{/*send log*/}
  return new Map([
    [/^guest_[1-4]$/,functionA],
    [/^guest_5$/,functionB],
    [/^guest_.*$/,functionC],
    //...
  ])
}

const onButtonClick4 = (identity,status)=>{
  let action = [...actions()].filter(([key,value])=>(key.test(`${identity}_${status}`)))
  action.forEach(([key,value])=>value.call(this))
}

// 也就是说利用数组循环的特性，符合正则条件的逻辑都会被执行，那就可以同时执行公共逻辑和单独逻辑，因为正则的存在，你可以打开想象力解锁更多的玩法，本文就不赘述了。


/* 本文已经教你了8种逻辑判断写法，包括：
if/else
switch
一元判断时：存到Object里
一元判断时：存到Map里
多元判断时：将condition拼接成字符串存到Object里
多元判断时：将condition拼接成字符串存到Map里
多元判断时：将condition存为Object存到Map里
多元判断时：将condition写作正则存到Map里
*/

