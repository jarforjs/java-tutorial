package com.imooc.part3;

public class D6_StringBuilder_Thousand {
  public static void main(String[] args) {
    StringBuilder str=new StringBuilder("hello");
    str.append(" imooc");
    str.append(520);
    System.out.println("字符串长度："+str.length());
    System.out.println("插入前："+str);

    str.insert(11,"!");
    String str2 = str.toString();
    System.out.println("没toString，插入后的str："+str);
    System.out.println("toString，插入后的str2："+str2);

    StringBuilder str3 = new StringBuilder();

    str3.append("jaewkjldfxmopzdm");
    System.out.println(str3.length()+" length");
    for(int i=str3.length()-3;i>=0;i-=3){
      System.out.println("i的值为："+i);
      str3.insert(i,',');
    }
    System.out.println("str3:"+str3);
  }
}
