function factorial(num) {
  if (num <= 1) {
    return 1
  }else {
    return num*factorial(num-1)
  }
}
console.log(factorial(5))

// another函数内部找不到factorial函数了
// var another = factorial;
// factorial=null
// another(5)

function factorial1(num) {
  if (num <= 1) {
    return 1
  } else {
    return num*arguments.callee(num-1)
  }
}
var another = factorial1;
factorial1=null
console.log(another(6))

