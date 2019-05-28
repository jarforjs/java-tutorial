package com.imooc.part2.D1;

public class Telephone {
  // 属性（成员变量）有什么
  float screen;
  float cpu;
  float memory;

  // 方法
  void call() {
    System.out.println("telphone有打电话的功能");
  }

  void sendMessage() {
    System.out.println("screen：" + screen + "，cpu：" + cpu + "，memory：" + memory + "。telphone有发信息的功能");
  }
}
