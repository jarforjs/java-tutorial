// 写入流
const fs = require('fs')
const data = '菜鸟教程官网地址：www.runoob.com'

const writeStream = fs.createWriteStream('output.txt')

writeStream.write(data,'UTF-8')

// 标记文件末尾
writeStream.end()

writeStream.on('finish', function (chunk) {
  console.log('写入完毕')
})

writeStream.on('error', function (err) {
  console.log(err.stack)
})

console.log('程序执行完毕')
