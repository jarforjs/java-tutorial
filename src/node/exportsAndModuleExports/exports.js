var counter  = 0;
exports.temp = function(){
  counter += 10;
  this.printNextCount = function()
  {
    console.log(counter);
  }
}
var isEq = (exports === module.exports);
console.log(exports);
console.log(module.exports);
console.log(isEq);
