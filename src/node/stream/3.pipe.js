const fs= require('fs')

const readStream = fs.createReadStream('input.txt')

const writeStream = fs.createWriteStream('output.txt')

readStream.pipe(writeStream)

console.log('程序执行完毕')
