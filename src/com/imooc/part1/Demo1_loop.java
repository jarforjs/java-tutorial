package com.imooc.part1;

import java.util.Scanner;

/**
 * 输入任意数返回其位数
 */
public class Demo1_loop {

  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);
    System.out.println("请输入任意一个数，让我来告诉你它是几位数～😄");
    int num = (int)input.nextDouble();
    int count = 0;

    do {
      count++;
      num = num / 10;
    } while (num > 0);
    System.out.println("它是个" + count + "位的数！");
  }
}
