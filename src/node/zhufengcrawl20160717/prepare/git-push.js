var CronJob=require('cron').CronJob;
//exec最大不超过50M
var exec=require('child_process').exec;
/*
var job=new CronJob('50 27 * * * *',function () {
	exec('git add -A',function (err, stdout, stderr) {
		exec('git commit -m"commit"',function (err, stdout, stderr) {
			exec('git push origin master',function (err, stdout, stderr) {
				console.log('提交完毕');
			})
		})
	})
});
job.start();*/
exec('git add -A',function (err, stdout, stderr) {
	exec('git commit -m"commit"',function (err, stdout, stderr) {
		exec('git push origin master',function (err, stdout, stderr) {
			console.log('提交完毕');
		})
	})
})