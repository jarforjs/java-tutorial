var async=require('async');
var persons={name:'zfpx',age:8};
console.time('cost');
async.eachOfSeries(persons,function (value,key,callback) {
	setTimeout(function () {
		console.log(key+'='+value);
		callback();
	},1000)
},function () {
	console.timeEnd('cost');
});
