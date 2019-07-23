var fs=require('fs');
var querystring=require('querystring');
module.exports=function (query,request,response) {
    //request是一个可读流,可以通过监听data和end事件获取其中的数据
    var result = '';
    request.on('data', function (data) {//设置编码类型之后data会从buffer转成字符串
        result += data;
    });
    request.on('end', function () {
        //console.log(result);//是一个序列化的表单格式:key1=value1&key2=value2
        var user = querystring.parse(result);//把字符串转成对象          //读取文件的内容
        //读取文件的内容
        fs.readFile(Db_NAME, 'utf8', function (err, data) {
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
            fs.writeFile(Db_NAME, JSON.stringify(users), function (err, result) {
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
};