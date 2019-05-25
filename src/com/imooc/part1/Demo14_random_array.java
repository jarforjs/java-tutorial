package com.imooc.part1;

import java.util.Arrays;

public class Demo14_random_array {

  public static void main(String[] args) {
    Demo14_random_array randomArray = new Demo14_random_array();
    int[] numbers = randomArray.randomArray(8);
    System.out.println(Arrays.toString(numbers));
  }

  public int[] randomArray(int length) {
    int[] numbers = new int[length];
//    int index = 0;
//    for (int num : numbers) {
//      numbers[index] = (int)(Math.random() * 100);
//      index++;
//    }
    for (int i = 0, len = numbers.length; i < len; i++) {
      numbers[i] = (int) (Math.random() * 100);
    }
    return numbers;
  }
}
