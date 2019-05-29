package com.imooc.part2;

public class D3_Static_Block1_Consolidate {
  String name;
  char sex;
  static int age;

  // 构造方法
  public D3_Static_Block1_Consolidate() {
    name = "顾洪波";
    System.out.println("通过构造方法为name赋值：" + name);
  }

  // 初始化块
  {
    sex = '男';
    System.out.println("通过初始化代码块为变量sex赋值：" + sex);
  }

  // 静态初始化块
  static {
    age = 30;
    System.out.println("通过静态初始化代码块为静态变量age赋值：" + age);
  }

  public void show() {
    System.out.println("姓名：" + name + "，性别：" + sex + "，年龄：" + age);
  }

  public static void main(String[] args) {
    D3_Static_Block1_Consolidate staticBlock1 = new D3_Static_Block1_Consolidate();
    staticBlock1.show();
  }
}
