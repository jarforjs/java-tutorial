package com.imooc.part2;

public class D6_Static_Inner_Class {
  static int score = 81;
  float weight = 150.7f;

  public static void main(String[] args) {
    //  创建静态内部类的对象时,不需要外部类的对象,可以直接创建
    // 内部类 对象名 = new 内部类();
    // D6_Static_Inner_Class SInner = new D6_Static_Inner_Class();
    SInner si = new SInner();
    si.show();
  }

  public static class SInner {
    int score = 88;

    public void show() {
      System.out.println("外部类的静态变量score:" + D6_Static_Inner_Class.score);
      System.out.println("内部类成员变量score:" + score);
      D6_Static_Inner_Class Inner = new D6_Static_Inner_Class();
      System.out.println("外部非静态成员变量weight:" + Inner.weight);
    }
  }
}
