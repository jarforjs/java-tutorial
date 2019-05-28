const express = require('express')
const app = express()
const fs = require('fs')
const url = require('url')
const util = require('util')
const querystring = require('querystring')

const postHTML =
  '<html><head><meta charset="utf-8"><title>菜鸟教程 Node.js 实例</title></head>' +
  '<body>' +
  '<form method="post">' +
  '网站名： <input name="name"><br>' +
  '网站 URL： <input name="url"><br>' +
  '<input type="submit">' +
  '</form>' +
  '</body></html>'

const user = {
  user4: {
    name: 'mohit',
    password: 'password4',
    profession: 'teacher',
    id: 4
  }
}

app.get('/', function (req, res) {
  let body = ''

  req.on('data', function (chunk) {
    body += chunk
  })

  req.on('end', function () {
    // 解析参数
    body = querystring.parse(body)
    // res.end(util.inspect(body))

    // 设置响应头信息及编码
    res.writeHead(200, {'Content-Type': 'text/html; charset=utf8'})

    if (body.name && body.url) {
      res.write('网站名：' + body.name)
      res.write('<br>')
      res.write('网站 URL：' + body.url)
    } else {
      res.write(postHTML)
    }
    res.end()
  })
})

const id = 2

app.get('/deleteUser', function (req, res) {
  res.write(util.inspect(url.parse(req.url, true)))
  res.write('\n')
  console.log(req.url, 'url')
  const pathname = url.parse(req.url).pathname
  console.log(pathname, 'pathname')
  fs.readFile(__dirname + '/' + 'users.json', 'utf8', function (err, data) {
    data = JSON.parse(data)
    delete data['user' + id]
    res.end(JSON.stringify(data, null, 2))
  })
})

app.get('/addUser', function (req, res) {
  // 首先读取已存在的数据
  fs.readFile(__dirname + '/' + 'users.json', 'utf8', function (err, data) {
    data = JSON.parse(data);
    data['user4'] = user['user4']
    console.log(data)
    res.end(JSON.stringify(data, null, 2))
  })
})

app.get('/listUsers', function (req, res) {
  fs.readFile(__dirname + '/' + 'users.json', 'utf8', function (err, data) {
    console.log(data);
    res.end(data)
  })
})

app.get('/:id', function (req, res) {
  // 首先读取已存在的数据
  fs.readFile(__dirname + '/' + 'users.json', 'utf8', function (err, data) {
    data = JSON.parse(data)
    const user = data['user' + req.params.id]
    console.log(user)
    res.end(JSON.stringify(user, null, 2))
  })
})

const server = app.listen(8081, function () {
  const host = server.address().address
  const port = server.address().port

  console.log('应用实例，访问地址为 http://%s:%s', host, port)
})
