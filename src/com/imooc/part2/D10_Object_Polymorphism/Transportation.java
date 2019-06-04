package com.imooc.part2.D10_Object_Polymorphism;

public class Transportation {
  private String way;
  private int number;

  public void method() {
    System.out.println("交通工具具有运输旅客的能力");
  }

  String getWay() {
    return way;
  }

  void setWay(String way) {
    this.way = way;
  }

  int getNumber() {
    return number;
  }

  void setNumber(int number) {
    this.number = number;
  }
}
