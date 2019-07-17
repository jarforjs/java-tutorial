//一、第一层收口
$.get(url,param,function () {

});

/*
1 公共参数，设备号，手机
2 统计需求，ajax接口响应速度
3 统一回调处理，Server错误码code处理
。。。
 */

//url=>domain.com?flag=顾洪波

// 业务架构层做约定
//1 所有在url后面的flag参数都要放到commonData的flag里
//2 所有ajax都要带上commonData
//请求参数
var commonData = {
  flag: '顾洪波',
}

//3 若以后有创建订单的操作，我们就把flag：顾洪波就存在数据库里面了
//这样有两个好处：
//1）如果我们现在用这个连接url=>domain.com?flag=顾洪波去线下二维码推广
// 如果注册了的话这个url里面就有flag这个参数
// 那我们就可以知道顾洪波这个用户今天引导了多少用户注册我们的帐号
//2）现在很多创业团队其实拿到的还是风投，我们做一个系统有很多数据（订单），投资人可能会质疑我们数据的真实性，所以我们在创建订单的时候尽可能的多带一些通用标识，来丰富我们的数据
var commonData1 = {
  us: '',
  flag: '顾洪波',
  id: '设备号',
  ip: '201.123.212.23',
  geo: '地理信息'
}

//以上是请求参数做的处理

//ajax无法拿到的是数据=>data=>定位信息（这些信息当中有一些可能不太会改变的比如省市可以存到localstorage）=>localstorage
//1）存localstorage的这种行为根本不应该由开发同学去写，我们只需要一个方法做一些收口，只需要一些简单的配置就能存到localstorage里面去
//2）localstorage也应该封装一下，我应该不是直接操作localstorage，而我可能应该操作一个store的东西，数据映射到store就行了，store这里会关注localstorage什么时候会过期什么时候该存
//整个逻辑应该是很通畅的，如果我们收口的好的话，重复的代码就会少很多


//二、location收口
// 一般都是location.href = 'url';一个项目里有很多这样的代码，有一天如果要在跳转前做一些什么的时候？埋点，那岂不有多少处就要改多少遍吗
var Location = function (url) {
  // ...
  location.href = url;
  // ...当然这里的代码是没有意义的
}
