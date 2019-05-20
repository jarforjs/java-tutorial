package com.imooc.part1;

import java.util.Arrays;

public class Demo6_sort_toString {
  public static void main(String[] args) {
    String[] hobbies = { "sports", "game", "movie"};
    Arrays.sort(hobbies);
    System.out.println(Arrays.toString(hobbies));
  }
}
