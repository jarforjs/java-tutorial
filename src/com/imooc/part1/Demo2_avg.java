package com.imooc.part1;

import java.util.Scanner;

/**
 * 接收三个班级四名学生成绩信息，计算每班平均分
 */
public class Demo2_avg {
  private static double sum;
  public static void main(String[] args) {
    int classNum = 3;
    int stuNum = 4;
//    double sum;
    System.out.println("sum"+sum);

    double avg;
    Scanner input = new Scanner(System.in);
    for (int i = 1; i <= classNum; i++) {
      sum = 0;
      System.out.println("***请输入第" + i + "个班级的成绩***");
      for (int j = 1; j <= stuNum; j++) {
        System.out.println("请输入第" + j + "个学生成绩");
        double score = input.nextDouble();
        sum += score;
      }
      avg = sum / stuNum;
      System.out.println("第" + i + "个班级平均成绩为：" + avg);
    }
  }
}
