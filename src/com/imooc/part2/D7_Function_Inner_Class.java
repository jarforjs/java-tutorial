package com.imooc.part2;

public class D7_Function_Inner_Class {
  private String name = "imooc";

  // 测试方法内部类
  public static void main(String[] args) {
    D7_Function_Inner_Class Inner = new D7_Function_Inner_Class();
    Inner.show();
  }

  public int show() {
    final int A = 25;

    // 方法内部类
    class Inner {
      int a = 52;
      int c = 2;

      public void print() {
        System.out.println("访问外部私有变量name:" + name);
        D7_Function_Inner_Class outer = new D7_Function_Inner_Class();
        int result = outer.show();
        // D7_Function_Inner_Class Outter = new D7_Function_Inner_Class();
        System.out.println("访问外部类方法中的常量a:" + result);
        System.out.println("访问内部类方法中的成员变量a:" + a);
        System.out.println("访问内部类方法中的成员变量c:" + c);
      }
    }
    // 创建方法内部类的对象
    Inner in = new Inner();
    in.print();
    return A;
  }
}
