package com.imooc.reflect;

public class ClassDemo5 {
  //获取构造函数信息
  public static void main(String[] args) {
    ClassUtil.printConstructorInfo("hello");
    ClassUtil.printConstructorInfo(1);
  }
}
