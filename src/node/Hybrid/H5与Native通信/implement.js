window.Hybrid = window.Hybrid || {};

var _getHybridUrl = function (params) {
  var k, paramStr = '', url = 'hybrid://', flag = '?';
  url += params.tagname;//时间戳，防止url不起效

  if (params.callback) {
    flag = '&';
    url += '?callback=' + params.callback;
    //delete params.callback;
  }

  if (params.param) {
    paramStr = typeof params.param == 'object' ? JSON.stringify(params.param) : params.param;
    url = url + flag + 'param=' + encodeURIComponent(paramStr);
  }

  return url;
};

var bridgePostMsg = function (params) {
  var url = _getHybridUrl(params);

  //兼容ios6
  var ifr = $('<iframe style="display:none;" src="' + url + '"/>');
  console.log(params.tagname + '-hybrid请求发出-' + new Date().getTime() + 'url: ' + url);

  if ($.os.android) {
    //Android情况协议发的太快会有问题
    setTimeout(function () {
      $('body').append(ifr);
    })
  } else {
    $('body').append(ifr);
  }

  //如果用window这种方法会阻断第二次请求
  //window.location = url;
  setTimeout(function () {
    ifr.remove();
    ifr = null;
  }, 1000);
};

// H5与Native的基本交互
var requestHybrid = function (params) {
  if (!params.tagname) {
    alert('必须包含tagname');
  }
  //生成唯一执行函数，执行后销毁
  var tt = (new Date().getTime()) + '_' + _.uniqueId() + '_';
  var t = 'hybrid_' + params.tagname + '_' + tt;
  var tmpFn;

  //处理有回调的情况
  if (params.callback) {
    tmpFn = params.callback;
    params.callback = t;//唯一的字符串

    window.Hybrid[t] = function (data) {
      tmpFn(data);
      //delete window.Hybrid[t]
    }
  }

  //解析callback，生成唯一的callbackid，将一个函数和一个字符串映射起来
  //callbackid：function(){}
  //传的是一个callbackid和一个function的映射
  //callback如果是一个函数的话，消息体根本传不过去，因为函数体太长；或者传过去的是一些类似于变量这些东西，那执行环境就没有了
  bridgePostMsg(params)
};

requestHybrid({
  tagname: 'getAddressList',
  param: {},
  callback: function (data) {
    // ...
  }
});
