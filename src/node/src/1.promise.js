// function foo(ms) {
//   return new Promise(((resolve, reject) => {
//     setTimeout(() => resolve('resolve'), ms)
//   }))
// }
//
// foo(1000).then((value) => console.log(value))

// const p1 = new Promise(((resolve, reject) => {
//   setTimeout(() => reject(new Error('fail')),3000)
// }))
//
// const p2 = new Promise(((resolve, reject) => {
//   setTimeout(() => resolve(p1),1000)
// }))
//
// p2.then(result => console.log(result, 'p1 success'),result => console.log(result, 'p1 fail'))
//   .then(result => console.log(result, 'p2 success'),result => console.log(result, 'p2 fail'))
//   .catch(error=>console.log(error,'catch'))

const someAsyncThing = function () {
  return new Promise(function (resolve, reject) {
    resolve(x+2)
  })
}

someAsyncThing().then(function () {
  console.log('haha')
}).catch(error=>console.log(error,'error'))

setTimeout(()=>console.log(123),2000)

process.on('unhandledRejection', function (err, p) {
  throw err;
})
