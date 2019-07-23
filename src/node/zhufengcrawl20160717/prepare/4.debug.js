// var debug=require('./debug');
var debug=require('debug');

//设置环境变量才会触发:set DEBUG=crawl:read
//windows set DEBUG=crawler:*
//linux export DEBUG=crawler:*
var logger=debug('crawl:read');
logger('hello');