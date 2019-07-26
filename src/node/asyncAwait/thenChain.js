/**
 * 多步骤完成示例
 * @param n 表示这个函数执行的事件（毫秒）
 * @returns {Promise<number>} 这个值将用于下一步骤
 */
function takeLongTime(n) {
  return new Promise(resolve => {
    setTimeout(() => resolve(n + 200), n)
  })
}

function step1(n) {
  console.log(`step1 with ${n}`)
  return takeLongTime(n)
}

function step2(n) {
  console.log(`step2 with ${n}`)
  return takeLongTime(n)
}

function step3(n) {
  console.log(`step3 with ${n}`)
  return takeLongTime(n)
}

function doIt() {
  console.time('doIt')
  const time1 = 300;
  step1(time1)
    .then(time2 => step2(time2))
    .then(time3 => step3(time3))
    .then(result => {
      console.log(`result is ${result}`)
      console.timeEnd('doIt')
    })
}

doIt()

// 用async/await实现
async function doIt1(){
  console.time('doIt1')
  const time1 = 300;
  const time2 = await step1(time1);
  const time3 = await step1(time2);
  const result = await step1(time3);
  console.log(`result is ${result}`)
  console.timeEnd('doIt1')
}

doIt1();
