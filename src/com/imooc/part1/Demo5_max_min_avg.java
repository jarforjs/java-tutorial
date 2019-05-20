package com.imooc.part1;

public class Demo5_max_min_avg {
  public static void main(String[] args) {
    // 定义一个整型数组，并赋初值
    int[] nums = new int[]{61, 23, 4, 74, 13, 148, 20};
    // 假定最大值为数组中的第一个元素
    int max = nums[0];
    // 假定最小值为数组中的第一个元素
    int min = nums[0];
    // 累计值
    double sum = 0;
    // 平均值
    double avg = 0;
//    for (int i = 0; i < nums.length; i++) {
//      int current = nums[i];
//      if (current > max) {
//        max = current;
//      }
//      if (current < min) {
//        min = current;
//      }
//      sum += current;
//    }
    for (int current : nums) {
      max = current > max ? current : max;
      min = current < min ? current : min;
      sum += current;
    }
    avg = sum / nums.length;
    System.out.println("数组中的最大值：" + max);
    System.out.println("数组中的最小值：" + min);
    System.out.println("数组中的平均值：" + avg);
  }
}
