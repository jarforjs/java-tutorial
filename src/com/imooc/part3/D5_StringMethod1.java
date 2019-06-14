package com.imooc.part3;

public class D5_StringMethod1 {
  public static void main(String[] args) {
    String fileName = "HelloWorld.java";
    String email = "rushu_xiaobo@163.com";

    // 判断.java文件名是否正确：合法的文件名应该以.java结尾
    int index = fileName.lastIndexOf('.');
    String prefix = fileName.substring(index + 1);
    // 必须包含'.'号，且不能出现在首位，同时后缀名为"java"
    if (index != -1 && index != 0 && prefix.equals("java")) {
      System.out.println("java文件名正确");
    } else {
      System.out.println("java文件名无效");
    }

    //判断邮箱格式是否正确：合法的邮箱名中至少要包含'@'，且'@'要在'.'之前
    int index2 = email.indexOf('@');
    int index3 = email.indexOf('.');
    if (index2 != -1 && index3 > index2) {
      System.out.println("邮箱格式正确");
    } else {
      System.out.println("邮箱格式无效");
    }
  }
}
