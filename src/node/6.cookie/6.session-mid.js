var express=require('express');
var app=express();

//注意先后顺序
var cookieParse=require('cookie-parser');
var session=require('express-session');
app.use(cookieParse());

//使用session中间件之后会在req上加一个session属性:req.session,就是属于此客户端的数据
app.use(session({
    name:'sessionKey',//connect.sid
    resave:true,//不管session是否修改过,都需要重新保存
    saveUninitialized:true,//是否保存只创建但未使用过的session
    secret:'zfpx'//秘钥:用来加密cookie,1024位
}));

app.get('/visit',function (req, res) {
    console.log(req.session, 'session')
    var count=req.session.count;
    if(count){
        req.session.count+=1;
    }else{
        req.session.count=1;
    }

    res.send(`这是你的第${req.session.count}此访问`);
})


app.listen(8001,function () {
    console.log('ok');
})
