package com.imooc.part2.D10_Object_Polymorphism;

public class Steamer extends Transportation {
  @Override
  public void method() {
    System.out.println("轮船航行在" + this.getWay() + "里可以载" + getNumber() + "人");
  }
}
