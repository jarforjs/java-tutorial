package com.imooc.part2;

public class D4_Encapsulation {
  // 属性（成员变量）有什么
  private float screen;
  private float cpu;
  private float memory;

  public float getScreen() {
    return screen;
  }

  public void setScreen(float screen) {
    this.screen = screen;
  }

  public D4_Encapsulation() {
    System.out.println("无参的构造方法执行了");
  }

  public D4_Encapsulation(float newScreen, float newCpu, float newMemory) {
    screen = newScreen;
    cpu = newCpu;
    memory = newMemory;
    System.out.println("有参的构造方法执行了");
  }
}
