package com.imooc.part3;

public class D9_BasisTransformString {
  public static void main(String[] args) {
    // 将基本类型转换为字符串
    int c = 10;
    // 基本类型转换为字符串有三种方法：
    String str1 = Integer.toString(c);
    String str2 = String.valueOf(c);
    String str3 = "" +c;

    System.out.println("str1:"+str1);
    System.out.println("str2:"+str2);
    System.out.println("str3:"+str3);

    // 将字符串转成基本类型有两种方法
    String str4 = "8";
    int str5 = Integer.parseInt(str4);
    int str6 = Integer.valueOf(str4);
    System.out.println("str5:"+str5);
    System.out.println("str6:"+str6);

    double m = 78.5;
    //将基本类型转换为字符串
    String str7 = Double.toString(m);
    System.out.println("m转换为String型后与整数20的求和结果为："+(str7+20));

    String str8="180.20";
    //将字符串转换为基本类型
    Double n = Double.parseDouble(str8);
    System.out.println("str8转换为double型后与整数20的求和结果为："+(n+20));
  }
}
