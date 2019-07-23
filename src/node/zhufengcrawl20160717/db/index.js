var mongoose=require('mongoose');
//连接数据库
mongoose.connect('mongodb://localhost/zhufengcrawl');
//定义模型骨架Schema
exports.Movie=mongoose.model('Movie',new mongoose.Schema({
	//让电影的分类id引用分类集合的主键
	cid:{type:mongoose.Schema.Types.ObjectId,ref:'Category'},
	name:String,//电影名称
	url:String//电影的url地址
}));

//定义分类的model
exports.Category=mongoose.model('Category',new mongoose.Schema({
	id:String,//分类id
	name:String,//电影名称
	url:String//电影的url地址
}));