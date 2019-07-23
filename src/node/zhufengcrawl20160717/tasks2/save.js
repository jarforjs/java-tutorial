/*
* 负责把电影列表保存到数据库中 mongodb*/

var db=require('../db');
var async=require('async');
var debug=require('debug')('crawl:save');


exports.category=function (items,callback) {
	debug('开始保存电影分类');
	async.series([
		//删除整个集合
		function (callback) {
			db.Category.remove({},callback);
			debug('清空电影分类');
		},
		//所有的电影保存到数据库中
		function (callback) {
			//迭代items放到数据库中
			async.forEach(items,function (item, cb) {
				db.Category.create(item,cb);
				debug('保存分类:'+item.name);
			},callback)
		}
	],function (err,result) {
		console.log(result);
		debug('保存分类完毕');
		callback();
	})
};




exports.movie=function (items,callback) {
	debug('开始保存电影列表');
	async.series([
		//删除整个集合
		function (callback) {
			db.Movie.remove({},callback);
			debug('清空电影列表');
		},
		//所有的电影保存到数据库中
		function (callback) {
			//迭代items放到数据库中
			async.forEach(items,function (item, cb) {
				db.Movie.create(item,cb);
				debug('保存电影:'+item.name);
			},callback)
		}
	],function (err,result) {
		console.log(result);
		debug('保存电影完毕');
	})
};

// module.exports([{name:'java',url:'js'}]);