package com.imooc.part1;

public class Demo3_count {
  public static void main(String [] args) {
    // 变量保存的成绩
    int score = 53;

    // 变量保存的次数
    int count = 0;

    // 打印输出加分前成绩
    System.out.println("加分前的成绩："+ score);

    // 只要成绩小于60，就循环执行加分操作，并统计加分次数
    while (score<60){
      count++;
      score++;
    }

    System.out.println("加分后的成绩："+ score);
    System.out.println("共加了："+ count+"次！");
  }
}
