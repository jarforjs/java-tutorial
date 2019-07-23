var async=require('async');
console.time('cost');
//并行表示多个任务,同时开始
//要等所有的任务都执行完毕后才回调函数
//总时间等于最长的任务需要的时间
async.parallel([
	function (callback) {
		setTimeout(function () {
			callback(null,'watch tv');
		},3000)
	},
	function (callback) {
		setTimeout(function () {
			callback(null,'homework');
		},1000)
	}
],function (err, result) {
	console.log(err);
	console.log(result);
	console.timeEnd('cost');
});