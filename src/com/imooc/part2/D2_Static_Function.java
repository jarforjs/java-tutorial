package com.imooc.part2;

public class D2_Static_Function {
  static int score1 =86;
  static int score2 = 92;
  // 定义静态方法sum，计算成绩总分，并返回总分
  public static int sum() {
    return score1+score2;
  }
  public static void main(String[] args) {
    int sum = sum();
    System.out.println("总分："+ sum);
  }
}
