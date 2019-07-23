var async = require('async');
var read = require('./read');
var save = require('./save');
var debug = require('debug')('crawl:main');
var db = require('../db');
var movies = [];

//分类列表的URL
var url = 'http://top.baidu.com/category?c=1&fr=topindex';

var categories = [];
debug('开始执行任务');
/*
 * 1.读取电影的分类列表
 * 2.保存分类列表
 *
 * 3.根据分类列表读取电影列表
 * 4.保存电影列表
 * */
async.series([
	//读取电影分类
	function (callback) {
		debug('读取电影分类列表开始');
		read.category(url, function (err, items) {
			categories = items;//categories没有id,只有百度提取出来的id
			debug('读取电影分类列表结束');
			callback();
		})
	},
	//保存电影的分类
	function (callback) {
		debug('保存电影分类列表');
		save.category(categories, function () {
			db.Category.find({}, function (err, docs) {
				categories = docs;
				callback();
			})
		});
	},


	function (callback) {
		debug('读取电影列表');
		//读取电影列表并把电影信息赋给movies
		async.forEach(categories, function (category, cb) {
			//url是此分类下面的电影列表网址
			read.movie(category.url, category._id, function (err, items) {
				movies = movies.concat(items);
				cb();
			})
		}, callback)
	},
	function (callback) {
		debug('保存电影列表');
		save.movie(movies, callback)
	}
], function (err, result) {
	console.log(result);
	debug('结束执行任务');
});
