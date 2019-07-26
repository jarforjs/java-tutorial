var counter = require('./1_modules_custom_counter');

console.log('第一次调用[1_modules_custom_counter]')

counter.seOutputVal(10);
counter.setIncrement(10);
counter.printNextCount()
counter.printNextCount()
counter.printNextCount()
counter.printNextCount()

var counter = require('./1_modules_custom_counter');
console.log('第二次调用[1_modules_custom_counter]')
counter.printNextCount()
