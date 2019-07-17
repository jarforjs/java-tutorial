// 1 JavascriptCore == JS Bridge
// 2 URL Schema

// JavascriptCore是Native定义的，而下面的NativeBridge是前端定义的
var NativeBridge = {};

NativeBridge.getAddressList = function (callback) {
  //bridge在这个函数体里面要有H5与Native通信的方式，抹平差异
  //里面实现还是用的H5和Native的那套交互，发出一个URL之后被Native拦截，之后会解析发现有callback，就会在window上找与之相对应的id方法把callback传进去，完了把data在给匿名的callback来回调
  requestHybrid({
    tagname: 'getAddressList',
    callback: function (data) {
      callback(data);
    }
  })

  //这个方法会创建类似下面这样一个URL，(唯一的id)
  //hybrid://getAddressList/callback=id
};


// 调用的时候
NativeBridge.getAddressList(function (data) {

});
