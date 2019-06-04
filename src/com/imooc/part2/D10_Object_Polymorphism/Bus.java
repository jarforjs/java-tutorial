package com.imooc.part2.D10_Object_Polymorphism;

public class Bus extends Transportation {
  @Override
  public void method() {
    System.out.println("公交行驶在" + this.getWay() + "上可以载" + getNumber() + "人");
  }

  void payment() {
    System.out.println("乘公交车可以刷支付宝");
  }
}
