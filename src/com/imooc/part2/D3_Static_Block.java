package com.imooc.part2;

public class D3_Static_Block {
  // 声明变量num1
  int num1;
  // 声明变量num2
  int num2;
  // 声明静态变量num2
  static int num3;

  // 构造方法
  public D3_Static_Block() {
    num1 = 94;
    System.out.println("通过构造方法为num1赋值" + num1);
  }

  // 初始化块
  {
    num2 = 83;
    System.out.println("通过初始化代码块为变量num2赋值" + num2);
  }

  // 静态初始化块
  static {
    num3 = 89;
    System.out.println("通过静态初始化代码块为静态变量num3赋值" + num3);
  }

  public static void main(String[] args) {
    D3_Static_Block staticBlock = new D3_Static_Block();
    System.out.println("num1:" + staticBlock.num1);
    System.out.println("num2:" + staticBlock.num2);
    System.out.println("num3:" + num3);
    D3_Static_Block staticBlock1 = new D3_Static_Block();
  }
}
