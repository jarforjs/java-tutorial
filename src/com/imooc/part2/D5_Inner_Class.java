package com.imooc.part2;

public class D5_Inner_Class {
  // 外部类的成员属性
  int age = 20;
  // 外部类的私有属性name
  private String name = "imooc";

  // 测试成员内部类
  public static void main(String[] args) {
    // 创建外部类的对象
    D5_Inner_Class o = new D5_Inner_Class();
    // 创建内部类的对象
    Inner inner = o.new Inner();
    inner.show();
  }

  // 成员内部类
  public class Inner {
    String name = "爱慕课";

    // 内部类中的方法
    public void show() {
      System.out.println("外部类中的name:" + D5_Inner_Class.this.name);
      System.out.println("内部类中的name:" + name);
      System.out.println("外部类中的age:" + age);
    }
  }
}
