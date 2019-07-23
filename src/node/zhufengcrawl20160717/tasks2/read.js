/*
* 负责远程服务器里的数据
* */
var cheerio=require('cheerio');
var request=require('request');
var iconvLite=require('iconv-lite');
var debug=require('debug')('crawl:read');

//读取电影的分类
exports.category=function (url,callback) {
	debug('开始读取电影分类');
	request({url:url,encoding:null},function (err, response, body) {
		//把gbk二进制的buffer转成utf8字符串
		body=iconvLite.decode(body,'gbk');
		//console.log(body);
		//转变成jquery对象
		var $=cheerio.load(body);
		var items=[];
		//搜索所有的a标签
		$('.hd .title a').each(function () {
			var $me=$(this);
			//创建每个电影对应的item对象
			var item={
				name:$me.text(),//电影的名称
				url:$me.attr('href'),//电影的超链接
				//http://top.baidu.com/buzz?b=437&c=1&fr=topcategory_c1

			};
			var result=item.url.match(/b=(\d+)/);
			item.id=result[1];//把id作为数据库里的文档id
			//此url用来进行下一步请求电影列表
			item.url='http://top.baidu.com'+item.url.slice(1)+'&fr=topcategory_c1';
			console.log(result);
			debug('保存分类:'+item.name);
			items.push(item);//把此电影加到数组里面去
		});
		debug('读取电影分类结束');
		callback(err,items);
	})
};


//读取电影列表,cid是分类的id
exports.movie=function (url,cid,callback) {
	debug('开始读取电影列表');
	request({url:url,encoding:null},function (err, response, body) {
		//把gbk二进制的buffer转成utf8字符串
		body=iconvLite.decode(body,'gbk');
		//console.log(body);
		//转变成jquery对象
		var $=cheerio.load(body);
		var items=[];
		//搜索所有的a标签
		$('.keyword .list-title').each(function () {
			var $me=$(this);
			//创建每个电影对应的item对象
			var item={
				cid:cid,//此电影的分类id
				name:$me.text(),//电影的名称
				url:$me.attr('href')//电影的超链接
			};
			debug('保存电影:'+item.name);
			items.push(item);//把此电影加到数组里面去
		});
		debug('读取电影列表结束');
		callback(err,items);
	})
};

exports.movie('http://top.baidu.com/buzz?b=26&c=1&fr=topcategory_c1',function (err, items) {
	console.log(items);
});

exports.category('http://top.baidu.com/buzz?b=437&c=1&fr=topcategory_c1',function (err, items) {
	console.log(items);
})


