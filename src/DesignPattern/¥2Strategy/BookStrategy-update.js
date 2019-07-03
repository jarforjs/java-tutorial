function BookStrategy() {
  this.calcPrice = function (price) {
    console.log("未打折： " + price)
  }
}

function BookCalc9Strategy() {
  this.calcPrice = function (price) {
    console.log("原价是： " + price + "；打9折后：" + price * 0.9)
  }
}

function BookCalc8Strategy() {
  this.calcPrice = function (price) {
    console.log("原价是： " + price + "；打8折后：" + price * 0.8)
  }
}

function BookCalc7Strategy() {
  this.calcPrice = function (price) {
    console.log("原价是： " + price + "；打7折后：" + price * 0.7)
  }
}

function PriceCalc(price) {
  this.price = price;
  var strategy;
  if (199 <= price && price < 399) {
    strategy = new BookCalc9Strategy();
  } else if (399 <= price && price < 599) {
    strategy = new BookCalc8Strategy();
  } else if (599 <= price) {
    strategy = new BookCalc7Strategy();
  } else {
    strategy = new BookStrategy();
  }

  this.getPrice = function () {
    return strategy.calcPrice(this.price);
  }
}

function Client(price) {
  return new PriceCalc(price).getPrice()
}

Client(897987);
