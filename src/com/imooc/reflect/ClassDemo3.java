package com.imooc.reflect;

public class ClassDemo3 {
  //获取成员函数信息
  public static void main(String[] args) {
    String s="hello";
    ClassUtil.printClassMethodInfo(s);


    Integer i1=1;
    ClassUtil.printClassMethodInfo(i1);
  }
}
