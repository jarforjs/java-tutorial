package com.imooc.part1;

public class Demo11_args_function {

  public static void main(String[] args) {
    Demo11_args_function calcAvg = new Demo11_args_function();
    calcAvg.calcAvg(94, 81);
  }

  public void calcAvg(int num1, int num2) {
    double avg = (num1 + num2) / 2.0;
    System.out.println("平均分为：" + avg);
  }
}
