var CronJob=require('cron').CronJob;
//秒 分钟 小时 日期 月份 星期
//var task=new CronJob('* * * * * *',function () {
/**
 * 1,5,6:第1,5,9秒执行
 */
/*var task=new CronJob('1,5,9 * * * * *',function () {
	console.log('执行日志',new Date().toLocaleString());
}*/
/**
 * 第1秒到第10秒每秒执行一次
 */
/*var task=new CronJob('1-10 * * * * *',function () {
	console.log('执行日志',new Date().toLocaleString());
})*/

/**
 * /每多少秒执行一次
 * 每10秒执行一次
 */
var task=new CronJob('*/10 * * * * *',function () {
	console.log('执行日志时间:',new Date().toLocaleString());
})
task.start();