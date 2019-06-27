package com.imooc.reflect;

public class ClassDemo4 {
  //获取成员变量信息
  public static void main(String[] args) {
    ClassUtil.printClassFieldInfo("hello");
    System.out.println("=======================");
    ClassUtil.printClassFieldInfo(1);
  }
}
