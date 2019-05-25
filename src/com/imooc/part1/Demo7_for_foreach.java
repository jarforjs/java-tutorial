package com.imooc.part1;

import java.util.Arrays;

public class Demo7_for_foreach {
  public static void main(String[] args) {
    int[] scores = {89, 72, 64, 58, 93};
    Arrays.sort(scores);
    int index = 0;
    for (int score : scores) {
      System.out.println("score[" + index + "]=" + score);
      index++;
    }
  }
}
