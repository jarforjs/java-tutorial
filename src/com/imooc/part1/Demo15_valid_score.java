package com.imooc.part1;

import java.util.Arrays;

public class Demo15_valid_score {

  public static void main(String[] args) {
    Demo15_valid_score validScore = new Demo15_valid_score();
    int[] scores = {89, -23, 64, 91, 119, 52, 73};
    validScore.validScore(scores);
  }

  public void validScore(int[] scores) {
    Arrays.sort(scores);
    int count = 1;
    System.out.println("考试成绩前三的是:");
    for (int i = scores.length - 1; i >= 0 && count < 4; i--) {
      int current = scores[i];
      if (current < 0 || current > 100) {
        continue;
      }
      count++;
      System.out.println(current);
    }
  }
}
