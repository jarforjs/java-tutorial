//建一个服务器,展示电影的分类和电影的列表


var express=require('express');
var app=express();

app.set('view engine','jade');
app.set('views','views');
var db=require('./db');

var async=require('async');
app.get('/:cid',function (req, res) {
	var cid=req.params.cid;
	async.parallel([
		async.series([
			function (cb) {//读取所有的的分类列表
				db.Category.find({},cb)
			},
			function (cb) {//读取所有的的电影列表
				db.Movie.find({cid:cid},cb);
			}
		],function (err, result) {
			//result是一个数组,分别对应上面任务函数每个输出的结果
			//res.render('index',{categories:result[0],movies:result[1]});
			res.render('index',{categories:categories,movies:result[1]});
			//渲染模板,
		})

	])
})
app.get('/',function (req, res) {
	var categories=[];//分类的数组
	async.series([
		function (cb) {//读取所有的的分类列表
			db.Category.find({},function (err, docs) {
				categories=docs;
				cb(err,docs)
			})
		},
		function (cb) {//读取所有的的电影列表
			db.Movie.find({cid:categories[0]._id},cb);
		}
	],function (err, result) {
		//result是一个数组,分别对应上面任务函数每个输出的结果
		//res.render('index',{categories:result[0],movies:result[1]});
		res.render('index',{categories:categories,movies:result[1]});
		//渲染模板,
	})
})

app.listen(80,function () {
	console.log('ok');
})

var CronJob=new require('cron').CronJob();
var job=new CronJob('0 */5 * * * *',function () {
	var spawn=require('child_process').spawn;
	//node.exe的绝对路径node tasks2/main.js
	var child=spawn(process.execPath,['tasks2/main.js']);
});

job.start();