var spawn=require('child_process').spawn;
var fs=require('fs');
function clone(url) {
	//3执行可执行文件,返回一个子进程的实例
	var child=spawn('git',['clone',url]);
}

//把此文件下载下来保存在当前目录中,文件名保持不变
clone('https://github.com/zhufengnodejs/zhufengcrawl.git');