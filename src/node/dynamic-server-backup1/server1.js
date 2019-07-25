var http = require('http');
var url = require('url');
var fs = require('fs');
var path = require('path');
var mime = require('mime');
var querystring = require('querystring');
var DB_NAME = './users.json';
http.createServer(function (request, response) {
  var urlObj = url.parse(request.url, true);//得到url对象
  var pathname = urlObj.pathname;//得到路径名
  var query = urlObj.query;//得到查询字符串对象
  var method = request.method;//取得请求的方法
  pathname = pathname + (pathname.endsWith('/') ? 'index.html' : '');
  request.setEncoding('utf8');//设置编码类型

  //var fileName='.'+pathname;
  if (pathname === '/users') {
    switch (method) {
      case 'GET':
        var id = query.id;
        if (id) {
          fs.readFile(DB_NAME, 'utf8', function (err, data) {
            if (err) {
              response.statusCode = 500;
              response.end(JSON.stringify({code: 'error', data: err}));
            } else {
              response.writeHead(200, {
                'Content-Type': 'application/json;charset=utf-8'
              });
              var users = JSON.parse(data);
              var user = users.filter(function (user) {
                return user.id === id;
              })[0] || {};
              response.end(JSON.stringify({code: 'success', data: user/*JSON.parse(data)*/}));
            }
          });
        } else {
          fs.readFile(DB_NAME, 'utf8', function (err, data) {
            if (err) {
              response.statusCode = 500;
              response.end(JSON.stringify({code: 'error', data: err}));
            } else {
              response.writeHead(200, {
                'Content-Type': 'application/json;charset=utf-8'
              });
              try {
                var users = JSON.parse(data);
              } catch (e) {
                var users = [];
              }
              var reg = new RegExp(query.keyword);
              var orderBy = query.orderBy || 'id';
              var order = query.order || 'asc';
              order = order === 'desc' ? -1 : 1;
              //过滤,排序(查询),分页
              var pageNum = query.pageNum ? Number(query.pageNum) : 1;
              var pageSize = query.pageSize ? Number(query.pageSize) : 2;
              var filterUsers = users.filter(function (user) {
                if (query.keyword) {
                  return reg.test(user.name)
                } else {
                  return true;
                }
              }).sort(function (a, b) {
                if (typeof a[orderBy] == 'string') {
                  return (a[orderBy].localeCompare(b[orderBy])) * order;
                } else {
                  return (a[orderBy] - b[orderBy]) * order;
                }
              }).slice((pageNum - 1) * pageSize, pageNum * pageSize);
              //response.end(JSON.stringify({code: 'success', data: JSON.parse(data)}));
              response.end(JSON.stringify({
                code: 'success',
                data: {users: filterUsers, totalPage: Math.ceil(users.length / pageSize), pageNum: pageNum}
              }));
            }
          });
        }

        break;
      case 'POST':
        //request是一个可读流,可以通过监听data和end事件获取其中的数据
        var result = '';
        request.on('data', function (data) {//设置编码类型之后data会从buffer转成字符串
          result += data;
        });
        request.on('end', function () {
          //console.log(result);//是一个序列化的表单格式:key1=value1&key2=value2
          var user = querystring.parse(result);//把字符串转换成对象
          //读取文件的内容
          fs.readFile(DB_NAME, 'utf8', function (err, data) {
            try {
              var users = JSON.parse(data);//转成JSON对象
              //user.id=user.length+1;
              //user.id = users[users.length - 1].id + 1;
              if (users.length > 0) {
                user.id = Number(users[users.length - 1].id) + 1;
              } else {
                user.id = 1;
              }
            } catch (e) {
              users = [];
              user.id = 1;
            }
            users.push(user);
            fs.writeFile(DB_NAME, JSON.stringify(users), function (err, result) {
              response.writeHead(200, {
                'Content-Type': 'application/json;charset=utf-8'
              });
              response.end(JSON.stringify({
                code: 'success',
                data: user
              }));
            })
          })
        });
        break;
      case 'DELETE':
        var id = query.id;
        fs.readFile(DB_NAME, 'utf8', function (err, data) {
          var users = JSON.parse(data);
          users = users.filter(function (user) {
            return user.id !== id;
          });
          fs.writeFile(DB_NAME, JSON.stringify(users), function (err) {
            if (err) {
              response.statusCode = 500;
              response.end(JSON.stringify({
                code: 'error',
                data: err
              }));
            } else {
              response.end(JSON.stringify({
                code: 'success',
                data: {}
              }));
            }
          })
        });
        break;
      case 'PUT':
        var user = '';
        request.on('data', function (data) {
          user += data;
        });
        request.on('end', function () {
          user = querystring.parse(user);
          fs.readFile(DB_NAME, 'utf8', function (err, data) {
            var users = JSON.parse(data);
            users = users.map(function (item) {
              if (item.id === user.id) {//给此item要用新传过来的user替换掉
                return user;
              } else {
                return item;
              }
            });
            fs.writeFile(DB_NAME, JSON.stringify(users), function (err) {
              if (err) {
                response.statusCode = 500;
                response.end(JSON.stringify({
                  code: 'error',
                  data: err
                }));
              } else {
                response.writeHead(200, {
                  'Content-Type': 'application/json;charset=utf-8'
                });
                response.end(JSON.stringify({
                  code: 'success',
                  data: user
                }));
              }
            })
          })
        });
        break;
    }
  } else {
    var fileName = '.' + pathname;
    fs.exists(fileName, function (exists) {
      if (exists) {
        response.setHeader('Content-Type', mime.lookup(fileName));
        fs.createReadStream(fileName).pipe(response);
      } else {
        response.statusCode = 404;
        response.end('not found');
      }
    })

  }
}).listen(80, function () {
  console.log(80);
});
