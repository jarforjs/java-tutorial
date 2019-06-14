package com.imooc.part3;

public class D5_StringMethod2 {
  public static void main(String[] args) {
    String s = "aljlkdsflkjsadjfklhasdkjlflkajdflwoiudsafhaasdasd";
    String str = "学习java编程";
    byte[] b = str.getBytes();
    System.out.println("转换为字节数组：");
    for(int i = 0,len=b.length;i<len;i++){
      System.out.print(b[i]+" ");
    }

    int num =0;

    for(int i =0,len = s.length();i<len;i++){
      if(s.charAt(i)=='a'){
        num++;
      }
    }

    System.out.println("字符a出现的次数："+num);
  }
}
