// async function testAsync() {
//   return 'hello async'
// }
//
// const result = testAsync();
// console.log(result)

function takeLongTime() {
  return new Promise(resolve => {
    setTimeout(() => resolve('long_time_value'))
  })
}

// takeLongTime().then(value => {
//   console.log('got', value)
// })

async function test() {
  const v = await takeLongTime()
  console.log(v)
}

test()
