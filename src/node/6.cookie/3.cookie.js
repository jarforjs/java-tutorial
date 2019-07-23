var express=require('express');
var app=express();
var cookieParser=require('cookie-parser');
//制定加密的秘钥:'girls'
app.use(cookieParser('girls'));

app.get('/write',function (req, res) {
    res.cookie('name','zfpx',{signed:true});//表示此cookie要进行签名认证
    res.end();
});
app.get('/read',function (req, res) {
    // res.send(req.headers.cookie)
    // 制定加密了之后就要用signedCookies
    // res.send(req.cookies)
    console.log(req.signedCookies, 'signed');
    //name=s%3Azfpx.%2Ffl56ix3wcE%2BNLeDcWO%2BHcRW2Ucclhe4CnQvZKr%2BayY;
    res.send(req.signedCookies);//设置了签名认证之后获取的时候也要用签名认证的方法读取
});

app.listen(801,function () {
    console.log('ok');
});
