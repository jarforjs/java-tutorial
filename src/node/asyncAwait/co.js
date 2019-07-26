// 首先，co 函数接受 Generator 函数作为参数，返回一个 Promise 对象。
function co(gen) {
  var ctx = this;

  return new Promise(function(resolve, reject) {
  });
}

// 在返回的 Promise 对象里面，co 先检查参数 gen 是否为 Generator 函数。
// 如果是，就执行该函数，得到一个内部指针对象；
// 如果不是就返回，并将 Promise 对象的状态改为 resolved 。
function co(gen) {
  var ctx = this;

  return new Promise(function(resolve, reject) {
    if (typeof gen === 'function') gen = gen.call(ctx);
    if (!gen || typeof gen.next !== 'function') return resolve(gen);
  });
}

// 接着，co 将 Generator 函数的内部指针对象的 next 方法，包装成 onFulefilled 函数。
// 这主要是为了能够捕捉抛出的错误。
function co(gen) {
  var ctx = this;

  return new Promise(function(resolve, reject) {
    if (typeof gen === 'function') gen = gen.call(ctx);
    if (!gen || typeof gen.next !== 'function') return resolve(gen);

    onFulfilled();
    function onFulfilled(res) {
      var ret;
      try {
        ret = gen.next(res);
      } catch (e) {
        return reject(e);
      }
      next(ret);
    }
  });
}

// 最后，就是关键的 next 函数，它会反复调用自身。
function next(ret) {
  if (ret.done) return resolve(ret.value);
  var value = toPromise.call(ctx, ret.value);
  if (value && isPromise(value)) return value.then(onFulfilled, onRejected);
  return onRejected(new TypeError('You may only yield a function, promise, generator, array, or object, but the following object was passed: "' + String(ret.value) + '"'));
}


// 上面代码中，next 函数的内部代码，一共只有四行命令。

/*
第一行，检查当前是否为 Generator 函数的最后一步，如果是就返回。

第二行，确保每一步的返回值，是 Promise 对象。

第三行，使用 then 方法，为返回值加上回调函数，然后通过 onFulfilled 函数再次调用 next 函数。

第四行，在参数不符合要求的情况下（参数非 Thunk 函数和 Promise 对象），将 Promise 对象的状态改为 rejected，从而终止执行。
 */

// 并发的异步操作
// co 支持并发的异步操作，即允许某些操作同时进行，等到它们全部完成，才进行下一步。

// 这时，要把并发的操作都放在数组或对象里面。

// 数组的写法
co(function* () {
  var res = yield [
    Promise.resolve(1),
    Promise.resolve(2)
  ];
  console.log(res);
}).catch(onerror);

// 对象的写法
co(function* () {
  var res = yield {
    1: Promise.resolve(1),
    2: Promise.resolve(2),
  };
  console.log(res);
}).catch(onerror);
