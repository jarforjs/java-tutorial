var a = ['1', '2', '3'].map(parseInt);// what & why ?
console.log(a);

var b = ['1', '2', '3'].map((n, i)=> parseInt(n, i));
console.log(b);

parseInt('1',0);
parseInt('2',1); //如果该第二个参数小于 2 或者大于 36，则 parseInt() 将返回 NaN。
parseInt('3',2); //一位数，不能大于等于基数，不然就返回NaN，2进制里没有3
// parseInt(string, radix) string为字符串，radix为介于2-36之间的数。
// 使用者告诉这个函数string（比如11）是radix（比如2）进制的，函数将固定返回string以十进制时显示的数（3）。
