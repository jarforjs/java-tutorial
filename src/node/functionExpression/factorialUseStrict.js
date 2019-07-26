"use strict"
// 严格模式下不能通过脚本访问，这时就可以使用函数表达式来解决这个问题
// function factorial1(num) {
//   if (num <= 1) {
//     return 1
//   } else {
//     return num*arguments.callee(num-1)
//   }
// }
// var another = factorial1;
// factorial1=null
// console.log(another(6))

var factorial = function f(num) {
  if(num<=1){
    return 1
  }else {
    return num*f(num-1)
  }
}
console.log(factorial(5))

var another = factorial;
factorial=null
console.log(another(6))
