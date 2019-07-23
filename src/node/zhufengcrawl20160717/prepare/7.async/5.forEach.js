var async=require('async');
var persons=[{name:'zfpx'},{name:'zfpx2'}];
console.time('cost');
async.forEach(persons,function (item, callback) {
	setTimeout(function () {
		console.log(item);
		callback();
	},3000)
},function () {
	console.timeEnd('cost');
});