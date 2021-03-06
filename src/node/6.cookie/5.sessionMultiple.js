var express=require('express');
var fs=require('fs');
var cookieParser=require('cookie-parser');
var app=express();
app.use(cookieParser());
/*
* 1.当顾客第一次访问理发店的时候,发一张会员卡,余额100.顾客把会员卡带回家
* 2.当顾客再次来店里的时候,要把会员卡带上
* 3.理发店通过卡号查询出此卡号的对应的余额,每消费一次减少10元
* */
var SESSION_KEY='session.key';
//var sessions={};
app.get('/hair',function (req, res) {
    var cookies=req.cookies;
    var sessionId=cookies[SESSION_KEY];
    var sessionObj=JSON.parse(fs.readFileSync('./session.json','utf8'));
    var balance=sessionObj[sessionId];

    if(sessionId && balance){
        sessionObj[sessionId]-=10;
        fs.writeFileSync('./session.json',JSON.stringify(sessionObj));
        res.send('欢迎再次光临,您还'+sessionObj[sessionId]+'剩元');
    }else{
        generate();
    }

    function generate() {
        var sessionObj=JSON.parse(fs.readFileSync('./session.json','utf8'));
        var sessionId=Date.now()+'';//先生成一个卡号
        sessionObj[sessionId]=100;//在服务器端记录此卡号对应的余额
        fs.writeFileSync('./session.json',JSON.stringify(sessionObj));
        //把此cookie发送给客户端
        res.cookie(SESSION_KEY,sessionId);

        res.send(`欢迎初次光临,送你一张价值100元的理发卡`)
    }

})


app.listen(8001,function () {
    console.log('ok');
})
