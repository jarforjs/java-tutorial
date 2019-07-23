/**
 * 负责读取远程服务器里的数据
 **/
var cheerio = require('cheerio');
var request = require('request');
var iconvLite = require('iconv-lite');
var debug = require('debug')('crawl:read');
module.exports = function(url,callback){
    debug('读取电影列表开始');
    request({url:url,encoding:null},function(err,response,body){
        //把GBK的二进制buffer转成utf8字符串
        body = iconvLite.decode(body,'gbk');
        //转变成jquery对象
        var $ = cheerio.load(body);
        var items = [];
        //搜索所有的a标签
        $('.keyword .list-title').each(function(){
            var $me = $(this);
            //创建每个电影对应的item对象
            var item = {
                name:$me.text(),//电影的名称
                url:$me.attr('href')//电影对应的链接
            }
            debug('保存电影:'+item.name);
            items.push(item);//把此电影加到数组里去
        });
        debug('读取电影列表结束');
        callback(err,items);
    })
}
/*

module.exports('http://top.baidu.com/buzz?b=26&c=1&fr=topcategory_c1',function(err,items){
    console.log(items);
})*/
