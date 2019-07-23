var http=require('http');
http.createServer(function (request, response) {
    var urlObj=require('url').parse(request.url,true);
    var pathname=urlObj.pathname;
    if(pathname==='/write'){
        //response.setHeader('Set-Cookie','age=6');
        //一定要有空格
        response.setHeader('Set-Cookie',['age=6','Domain=localhost']);
        response.end('ok');
    }else if(pathname==='/read'){
        response.end(request.headers['cookie']);
    }
}).listen(8002,function () {
    console.log(8002);
})
