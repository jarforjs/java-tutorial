var express=require('express');
var app=express();
var cookieParser=require('cookie-parser');
/*
* npm install cookie-parser --save
* 加了之后放在package.json里面了
 * */

app.use(cookieParser());

app.get('/write',function (req, res) {
    //1.基本使用
    //res.cookie('name','zfpx');

    //那么多options为了安全,节省带宽
    //2.设置域名
    /*res.cookie('name','zfpx',{
        domain:'a.zfpx.cn'
    })*/

    //3.指定此cookie所属的路径:/是所有路径
    /*res.cookie('name1','zfpx1',{
        domain:'a.zfpx.cn',
        path:'/visit'
    })*/

    //4.指定过期时间,maxAge比expires优先级高
    /*res.cookie('name2','zfpx2',{
        maxAge:20*1000
    })*/
    /*res.cookie('name3','zfpx3',{
        expires:new Date(Date.now()+30*1000)/!*.toGMTString()*!///不需要转换
    })*/

    res.cookie('name4','zfpx4',{
        //httpOnly:true//设置成true后不不能通过js读取cookie了
    })
    res.end();
})

//req.headers.cookie获取的是请求头中的cookie字符串
app.get('/read',function (req, res) {
    //res.send(req.headers.cookie);
    //当使用了cookieParser之后,会在请求头对象上多一个cookie的对象属性
    res.send(req.cookies);
})
app.get('/visit',function (req, res) {
    //res.send(req.headers.cookie);
    res.send(req.cookies);
})

app.get('/clear',function (req, res) {
    res.clearCookie('name4');//清除客户端的cookie
    res.send(req.cookies);
})
app.listen(80,function () {
    console.log('ok');
});

//sessionStorage.age=6
//localStorage.name='zfpx';