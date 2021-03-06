package com.imooc.part2;

public class D1_Telephone_Construct_Static_Variable {
  // 属性（成员变量）有什么
  float screen;
  float cpu;
  float memory;

  // 静态变量
  static String hobby = "imooc";

  // 方法
  void call() {
    System.out.println("telephone有打电话的功能");
  }

  void sendMessage() {
    System.out.println(hobby);
    System.out.println("screen：" + screen + "，cpu：" + cpu + "，memory：" + memory + "。telphone有发信息的功能");
  }

  public D1_Telephone_Construct_Static_Variable() {
    System.out.println("无参的构造方法执行了");
  }

  public D1_Telephone_Construct_Static_Variable(float newScreen, float newCpu, float newMemory) {
    if (newScreen < 3.5f) {
      System.out.println("您输入的参数有问题，自动赋值3.5f");
      screen = 3.5f;
    } else {
      screen = newScreen;
    }
    cpu = newCpu;
    memory = newMemory;
    System.out.println("有参的构造方法执行了");
    sendMessage();
  }
}
