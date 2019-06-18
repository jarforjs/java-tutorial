package com.imooc.part3;

public class D12_Math {
  public static void main(String[] args) {
    double num = 12.81;
    int b = (int) num;
    System.out.println("强制类型转换为int类型，并去掉小数点：" + b);

    long c = Math.round(num);
    System.out.println("四舍五入：" + c);

    double d = Math.floor(num);
    System.out.println("floor:" + d);

    double e = Math.ceil(num);
    System.out.println("ceil：" + e);

    // 调用random方法，产生[0, 1)之间的随机浮点数
    double x = Math.random();
    System.out.println("随机数：" + x);

    // 产生[0, 99)之间的随机整数
    int y = (int) (Math.random() * 99);
    System.out.println("产生[0, 99)之间的随机整数：" + y);

    // 产生[5, 10)之间的随机整数
//    for (int i=0,len=1000;i<len;i++){
    int z = (int) (Math.random() * (10 - 5) + 5);
    System.out.println("产生[5, 10)之间的随机整数：" + z);
//    }

    System.out.println();
    int[] nums = new int[10];
    for (int i = 0, len = nums.length; i < len; i++) {
      nums[i] = (int) (Math.random() * 10);
      System.out.println("nums[" + i + "]: " + nums[i]);
    }

    int[] newNums = new int[]{1, 2, 3, 4};
    for (int num1 : newNums) {
      System.out.print(num1 + ' ');
    }

    System.out.println();
    int[] newNums1 = new int[]{1, 2, 3, 4};
    for (int num1 : newNums1) {
      System.out.print(num1 + " ");
    }
  }
}
