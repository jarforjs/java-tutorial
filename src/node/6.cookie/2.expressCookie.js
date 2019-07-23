var express=require('express');
var cookieParser=require('cookie-parser');
var app=express();
/*
* npm install cookie-parser --save
* 加了之后放在package.json里面了
 * */

/**
 *  res.cookie 写cookie
 *  req.cookies 读取请求头中的cookie
 */
function myCookieParser(){
    return function(req,res,next){
        var cookies = req.headers.cookie;// name=zfpx; age=6
        //把请求中的cookie转成对象赋给req.cookies
        req.cookies = require('querystring').parse(cookies,'; ');
        res.cookie = function(key,value,options){
            var pairs = [];
            pairs.push(`${key}=${value}`);
            if(options.maxAge){
                pairs.push(`Max-Age=${Math.floor(options.maxAge/1000)}`);
            }
            if(options.domain){
                pairs.push(`Domain=${options.domain}`);
            }
            // .......
            var result =  pairs.join('; ');
            //必须要这一句话,写到客户端中
            res.setHeader('Set-Cookie',result);
        }
        //用了中间件记得加next()!
        next();
    }
}

app.use(cookieParser());

app.get('/write',function (req, res) {
    //1.基本使用
    //res.cookie('name','zfpx');

    //那么多options为了安全,节省带宽
    //2.设置域名
    // res.cookie('name','zfpx')

    //3.指定此cookie所属的路径:/是所有路径
    // res.cookie('name1','zfpx1',{
    //     domain:'localhost',
    //     path:'/visit'
    // })

    //4.指定过期时间,maxAge比expires优先级高
    res.cookie('name2','zfpx2',{
        maxAge:20*1000
    })

    res.cookie('name3','zfpx3',{
        expires:new Date(Date.now()+30*1000)/*.toGMTString()*///不需要转换
    })

    res.cookie('name4','zfpx4',{
        // httpOnly:true//设置成true后不不能通过js读取cookie了
    })
    res.end();
})

//req.headers.cookie获取的是请求头中的cookie字符串
app.get('/read',function (req, res) {
    // res.send(req.headers.cookie);
    //当使用了cookieParser之后,会在请求头对象上多一个cookies的对象属性
    res.send(req.cookies);
})

//统计一下此客户端访问服务器的次数
app.get('/visit',function (req, res) {
    //res.send(req.headers.cookie);
    var count = req.cookies.count;
    // var name4 = req.cookies.name4;
    if(count){
        count = Number(count)+1;
    }else {
        count =1;
    }
    res.cookie('count',''+count,{maxAge:30*1000});
    res.send(`这是你第${count}次访问服务器`)
})

app.get('/clear',function (req, res) {
    res.clearCookie('name3');//清除客户端的cookie
    res.send(req.cookies);
})
app.listen(8002,function () {
    console.log('ok');
});

//sessionStorage.age=6
//localStorage.name='zfpx';
