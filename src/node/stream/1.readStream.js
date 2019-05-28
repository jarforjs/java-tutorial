/*
Node.js，Stream 有四种流类型：

Readable - 可读操作。

Writable - 可写操作。

Duplex - 可读可写操作.

Transform - 操作被写入数据，然后读出结果。
*/

// 从流中读取数据
const fs = require('fs')
let data = ''

const readerStream = fs.createReadStream('input.txt')
readerStream.setEncoding('UTF-8')

readerStream.on('data', function (chunk) {
  data+=chunk
})

readerStream.on('end',function () {
  console.log(data)
})

readerStream.on('error', function (err) {
  console.log(err.stack)
})

console.log('程序执行完毕')
