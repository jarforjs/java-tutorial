package com.imooc.part1;

import java.util.Arrays;

public class Demo12_sort_length_function {

  public static void main(String[] args) {
    Demo12_sort_length_function sortLength = new Demo12_sort_length_function();
    int[] scores = {79, 52, 98, 81};
    int count = sortLength.sortLength(scores);
    System.out.println("共有" + count + "个成绩信息！");
  }

  public int sortLength(int[] scores) {
    Arrays.sort(scores);
    System.out.println(Arrays.toString(scores));
    return scores.length;
  }
}
