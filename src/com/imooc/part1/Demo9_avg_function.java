package com.imooc.part1;

public class Demo9_avg_function {

  public static void main(String[] args) {
    Demo9_avg_function calcAvg = new Demo9_avg_function();
    double avg = calcAvg.calcAvg();
    System.out.println("平均成绩为" + avg);
  }

  public double calcAvg() {
    double java = 92.5;
    double php = 83.0;
    double avg = (java + php) / 2;

    return avg;
  }
}
