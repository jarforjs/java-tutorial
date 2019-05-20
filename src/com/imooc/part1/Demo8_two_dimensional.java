package com.imooc.part1;

import java.util.Arrays;

public class Demo8_two_dimensional {
  public static void main(String[] args){
    // 定义一个两行三列的二维数组并赋值
    String [][] arrays = new String[2][3];
    String [][] names = {{"tom","jack","mike"},{"zhangsan","lisi","wangwu"}};
//    for (int i= 0;i<names.length;i++) {
//      for( int j = 0;j<names[i].length;j++){
//        System.out.println(names[i][j]);
//      }
//      System.out.println();
//    }
    for (String[] name : names) {
      for (String n : name) {
        System.out.println(n);
      }
      System.out.println();
    }

    // 在定义二维数组时也可以只指定行的个数，然后再为每一行分别指定列的个数。如果每行的列数不同，则创建的是不规则的二维数组
    // 定义一个三行对的二维数组
    int[][] num = new int[3][];

    //第一行分配两列
    num[0]=new int[2];
    //第二行分配两列
    num[1]=new int[3];
    //第三行分配两列
    num[2]=new int[4];

    //第一行第一列赋值为1
    num[0][0]=1;
    //第二行第二列赋值为2
    num[1][1]=2;
    //第三行第四列赋值为1
    num[2][3]=3;

    System.out.println(Arrays.toString(num[0]));
    System.out.println(Arrays.toString(num[1]));
    System.out.println(Arrays.toString(num[2]));
    System.out.println(num[0][0]);
    System.out.println(num[1][1]);
    System.out.println(num[2][3]);
  }
}
