/*
var spawn=require('child_process').spawn;
var fs=require('fs');
function download(url) {
	//1先得到文件名
	var filename=url.split('/').pop();
	//2创建一个可写流
	var ws=fs.createWriteStream('./'+filename);
	//3执行可执行文件,返回一个子进程的实例
	var child=spawn('curl',[url]);
	//4监听子进程的控制台的标准输出,得到数据写入文件流中
	child.stdout.on('data',function (data) {
		ws.write(data);
	})
	//5监听标准输出完毕
	child.stdout.on('end',function () {
		ws.end();
		console.log('文件保存完毕');
	})
	//6监控子进程的退出事件
	child.on('exit',function (code) {
		console.log(code);
	})
}

//把此文件下载下来保存在当前目录中,文件名保持不变
// download('https://assets.npmjs.com/uploads/2016/06/npm-camp-registry-package-page.png');
download('https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/bd_logo1_31bdc765.png');*/
var spawn=require('child_process').spawn;
var fs=require('fs');
function download(url){
	var filename=url.split('/').pop();//文件名
	var ws=fs.createWriteStream('./'+filename);
	var child= spawn('curl',[url]);
	child.stdout.on('data', function (data) {//监控子进程想控制台的标注输入
		ws.write(data);
	});
	child.stdout.on('end', function () {
		ws.end();
		console.log('文件保存完毕');
	});
	child.on('exit', function (code) {
		console.log(code);
	})

}
download('https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/bd_logo1_31bdc765.png')