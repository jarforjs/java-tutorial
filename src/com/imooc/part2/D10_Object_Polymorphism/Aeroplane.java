package com.imooc.part2.D10_Object_Polymorphism;

public class Aeroplane extends Transportation {
  @Override
  public void method() {
    System.out.println("飞机飞行在" + this.getWay() + "中可以载" + getNumber() + "人");
  }
}
