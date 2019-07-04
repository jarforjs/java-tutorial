/**
 * debug例子：命名空间
 */
var debug = require('debug');
var appDebug = debug('app');
var apiDebug = debug('api');


// DEBUG=app,api：表示同时打印出命名空间为app、api的调试日志。
// DEBUG=a*：支持通配符，所有命名空间为a开头的调试日志都打印出来。

// 分别运行下面几行命令看下效果
//
//     DEBUG=app node 02.js
//     DEBUG=api node 02.js
//     DEBUG=app,api node 02.js
//     DEBUG=a* node 02.js
//
appDebug('hello');
apiDebug('hello');


/**
 * debug例子：排查命名空间
 */
var listDebug = debug('app:list');
var profileDebug = debug('app:profile');
var loginDebug = debug('account:login');

// 分别运行下面几行命令看下效果
//
//     DEBUG=* node 03.js
//     DEBUG=*,-account* node 03.js
//
listDebug('hello');
profileDebug('hello');
loginDebug('hello');


// debug也支持格式化输出，如下例子所示。
debug('my name is %s', 'chyingp');

// 此外，也可以自定义格式化内容。

/**
 * debug：自定义格式化
 */
var createDebug = require('debug')

createDebug.formatters.h = function(v) {
  return v.toUpperCase();
};

var debug1 = createDebug('foo');

// 运行 DEBUG=foo node 04.js
// 输出 foo My name is CHYINGP +0ms
debug1('My name is %h', 'chying');
