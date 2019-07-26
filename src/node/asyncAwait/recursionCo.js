// co 函数库其实就是将两种自动执行器（Thunk 函数和 Promise 对象），包装成一个库。
// 使用 co 的前提条件是，Generator 函数的 yield 命令后面，只能是 Thunk 函数或 Promise 对象。

// 基于 Promise 对象的自动执行
var fs = require('fs');

// 首先，把 fs 模块的 readFile 方法包装成一个 Promise 对象。
var readFile = function (fileName) {
  return new Promise(function (resolve, reject) {
    fs.readFile(fileName, function (error, data) {
      if (error) reject(error)
      resolve(data)
    })
  })
}

var gen = function *() {
  var f1 = yield readFile('./a.txt');
  var f2 = yield readFile('./b.txt');

  console.log(f1.toString());
  console.log(f2.toString());
}

// 然后，手动执行上面的 Generator 函数。
// var g = gen();
// g.next().value.then(function (data) {
//   g.next(data).value.then(function (data) {
//     g.next(data)
//   })
// })

function run(fn) {
  var gen = fn();

  function next(data) {
    var result = gen.next(data);
    if(result.done) return result.value;
    result.value.then(function (data) {
      next(data)
    })
  }
  next();
}

run(gen)
