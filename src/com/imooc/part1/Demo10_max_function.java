package com.imooc.part1;

public class Demo10_max_function {

  public static void main(String[] args) {
    Demo10_max_function maxAge = new Demo10_max_function();
    int max = maxAge.maxAge();
    System.out.println("最大值为" + max);
  }

  public int maxAge() {
    int[] ageArr = {18, 23, 21, 19, 25, 29, 17};
    int max = ageArr[0];
    for (int i = 1; i < ageArr.length; i++) {
      int current = ageArr[i];
      max = max < current ? current : max;
    }
    return max;
  }
}
