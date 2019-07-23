var async=require('async');
console.time('cost');
//串行执行
async.series([
	function (callback) {
		setTimeout(function () {
			callback(null,'watch tv');
		},1000)
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
})