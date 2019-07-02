// Strategy [ˈstrætədʒi]
/*
a、calculateBonus 函数比较庞大，包含了很多if-else 语句，这些语句需要覆盖所有的逻辑分支。
b、calculateBonus 函数缺乏弹性，如果增加了一种新的绩效等级C，或者想把绩效S 的奖金系数改为5，那我们必须深入calculateBonus 函数的内部实现，这是违反开放封闭原则的。
c、算法的复用性差，如果在程序的其他地方需要重用这些计算奖金的算法呢？我们的选择只有复制和粘贴。
 */
var calculateBonus = function(performanceLevel, salary) {
  if (performanceLevel === 'S') {
    return salary * 4;
  }
  if (performanceLevel === 'A') {
    return salary * 3;
  }
  if (performanceLevel === 'B') {
    return salary * 2;
  }
};
calculateBonus('B', 20000); // 输出：40000
calculateBonus('S', 6000); // 输出：24000

const strategy = {
  /**
   * @return {number}
   */
  'S': function (salary) {
    return salary * 4;
  },
  /**
   * @return {number}
   */
  'A': function (salary) {
    return salary * 3;
  },
  /**
   * @return {number}
   */
  'B': function (salary) {
    return salary * 2;
  }
};

const calculateBonus1 = function (level, salary) {
  return strategy[level](salary);
};
calculateBonus1('A', 1000)

/**
 * @return {number}
 */
const S = function (salary) {
  return salary * 4;
};

/**
 * @return {number}
 */
const A = function (salary) {
  return salary * 3;
};

/**
 * @return {number}
 */
const B = function (salary) {
  return salary * 2;
};

const calculateBonus2 = function (func, salary) {
  return func(salary);
};

calculateBonus2(A, 10000);


// identity: seller, purchase
// assets: asset, invoice, guide, info, design, bill

// seller: asset, invoice, guide, info
// purchase: design, bill, guide, info

const Seller = function (asset) {
  ['asset', 'invoice', 'guide', 'info'].includes(asset)
    ?
    console.log('Seller home')
    :
    console.log('Purchase Guide home')
};

const Purchase = function (asset) {
  ['design', 'bill', 'guide', 'info'].includes(asset)
    ?
    console.log('Purchase home')
    :
    console.log('Seller Guide home')
};

const goto = function (func, asset) {
  return func(asset)
};

goto(Purchase, 'asset');//seller guide home
goto(Seller, 'design');//purchase guide home
goto(Seller, 'invoice');//seller guide home
