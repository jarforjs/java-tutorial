var express=require('express');
var cookieParser=require('cookie-parser');
var app=express();
app.use(cookieParser());
/*
* 1.当顾客第一次访问理发店的时候,发一张会员卡,余额100.顾客把会员卡带回家
* 2.当顾客再次来店里的时候,要把会员卡带上
* 3.理发店通过卡号查询出此卡号的对应的余额,每消费一次减少10元
* */
var SESSION_KEY='session.key';
var sessions={};
app.get('/hair',function (req, res) {
    var cookies=req.cookies;
    var sessionId=cookies[SESSION_KEY];
    if(sessionId){
        // var balance=sessions[sessionId];
        // balance-=10;
        // sessions[sessionId]=balance;

        //...待补充
        var balance=sessions[sessionId];
        if(balance){
            sessions[sessionId]-=10;
            res.send('欢迎再次光临,您还'+sessions[sessionId]+'剩元');
        }else{
            generate();
        }
    }else{
        generate();
    }


    function generate() {
        var sessionId=Date.now()+'';//先生成一个卡号
        sessions[sessionId]=100;//在服务器端记录此卡号对应的余额
        res.cookie(SESSION_KEY,sessionId);
        res.send(`欢迎初次光临,送你一张价值100元的理发卡`)
    }

})


app.listen(80,function () {
    console.log('ok');
})