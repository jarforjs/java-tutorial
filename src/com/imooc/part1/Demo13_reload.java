package com.imooc.part1;

public class Demo13_reload {

  public static void main(String[] args) {
    Demo13_reload reload = new Demo13_reload();
    reload.print();
    reload.print("哈哈哈");
    reload.print(20);
  }

  public void print() {
    System.out.println("没参数的print方法");
  }

  public void print(String age) {
    System.out.println("带有字符串参数的print方法，参数值为："+age);
  }

  public void print(int age) {
    System.out.println("带有整型参数的print方法，数值为："+age);
  }
}
