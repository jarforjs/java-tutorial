function BookStrategy() {
  this.calcPrice = function (price) {
    console.log("未打折 = " + price)
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
    console.log("原价是： " + price + "；打9折后：" + price * 0.7)
  }
}

function PriceCalc(_strategy) {
  this.strategy = _strategy;
  this.getPrice = function (price) {
    return this.strategy.calcPrice(price);
  }
}

function Client(price) {
  var priceCalc = null;
  if (199 <= price && price < 399) {
    priceCalc = new PriceCalc(new BookCalc9Strategy());
  } else if (399 <= price && price < 599) {
    priceCalc = new PriceCalc(new BookCalc8Strategy());
  } else if (599 <= price) {
    priceCalc = new PriceCalc(new BookCalc7Strategy());
  } else {
    priceCalc = new PriceCalc(new BookCalc9Strategy());
  }
  priceCalc.getPrice(price)
}

Client(201);
