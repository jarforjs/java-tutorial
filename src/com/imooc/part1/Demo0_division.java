package com.imooc.part1;

/**
 * java除法的结果是取整还是正常值与被除数有关。
 */
public class Demo0_division {
  public static void main(String[] args) {
    System.out.println("(11+3*8)/4%3=" + (11 + 3 * 8) / 4 % 3);
    // java除法的结果是取整还是正常值与被除数有关。
    System.out.println("(11+3*8)/4.0%3=" + (11 + 3 * 8) / 4.0 % 3);
  }
}
