var http = require('http');
var url = require('url');
var fs = require('fs');
var path = require('path');
var mime = require('mime');
var querystring = require('querystring');
//var DB_NAME = './users.json';
global.DB_NAME = './users.json';

/**
 * 1.高内聚低耦合
 * 1)可以提高代码质量
 * 2)可复用,可组合
 * 3)提高健壮性
 *
 * 2.对扩张开放,对修改关闭
 * 1)允许添加新的功能
 * 2)对修改关闭
 */
http.createServer(function (request, response) {
  var urlObj = url.parse(request.url, true);//得到url对象
  var pathname = urlObj.pathname;//得到路径名
  var query = urlObj.query;//得到查询字符串对象
  var method = request.method;//取得请求的方法
  pathname = pathname + (pathname.endsWith('/') ? 'index.html' : '');
  request.setEncoding('utf8');//设置编码类型

  try {
    require('./routes' + pathname + '/' + method.toLowerCase())(query, request, response);
  } catch (e) {
    require('./routes/static')(pathname, response);
  }

  // if (pathname === '/users') {
  //     switch (method) {
  //         case 'GET':
  //             require('./routes/users/get')(query,request,response);
  //             break;
  //         case 'POST':
  //             require('./routes/users/post')(query,request,response);
  //             break;
  //         case 'DELETE':
  //             require('./routes/users/delete')(query,request,response);
  //             break;
  //         case 'PUT':
  //             require('./routes/users/put')(query,request,response);
  //             break;
  //     }
  // } else {
  //     require('./routes/static')(pathname,response);
  // }
}).listen(8001, function () {
  console.log(8001);
});
