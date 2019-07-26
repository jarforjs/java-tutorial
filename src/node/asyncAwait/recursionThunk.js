var fs = require('fs');
var thunkify = require('thunkify');
var readFile = thunkify(fs.readFile);

var gen = function* () {
  var r1 = yield readFile('./a.txt')
  console.log(r1.toString());
  var r2 = yield readFile('./b.txt')
  console.log(r2.toString())
}

// 上面代码中，yield 命令用于将程序的执行权移出 Generator 函数，那么就需要一种方法，将执行权再交还给 Generator 函数。

// 这种方法就是 Thunk 函数，因为它可以在回调函数里，将执行权交还给 Generator 函数。
// 为了便于理解，我们先看如何手动执行上面这个 Generator 函数。

// var g = gen();
//
// var r1 = g.next();
// r1.value(function (err, data) {
//   if(err) throw err;
//   var r2 = g.next(data);
//   r2.value(function (err, data) {
//     if (err) throw err;
//     g.next(data)
//   })
// })

// 仔细查看上面的代码，可以发现 Generator 函数的执行过程，其实是将同一个回调函数，反复传入 next 方法的 value 属性。这使得我们可以用递归来自动完成这个过程。
function run(fn) {
  var gen = fn();

  function next(err, data) {
    var result = gen.next(data);
    if(result.done) return;
    result.value(next);
  }

  next()
}

run(gen)
/*
上面代码的 run 函数，就是一个 Generator 函数的自动执行器。
内部的 next 函数就是 Thunk 的回调函数。
next 函数先将指针移到 Generator 函数的下一步（gen.next 方法），然后判断 Generator 函数是否结束（result.done 属性），如果没结束，就将 next 函数再传入 Thunk 函数（result.value 属性），否则就直接退出。

有了这个执行器，执行 Generator 函数方便多了。
不管有多少个异步操作，直接传入 run 函数即可。
当然，前提是每一个异步操作，都要是 Thunk 函数，也就是说，跟在 yield 命令后面的必须是 Thunk 函数。
 */

/*
Thunk 函数并不是 Generator 函数自动执行的唯一方案。
因为自动执行的关键是，必须有一种机制，自动控制 Generator 函数的流程，接收和交还程序的执行权。
回调函数可以做到这一点，Promise 对象也可以做到这一点。
 */
