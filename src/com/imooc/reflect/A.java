package com.imooc.reflect;

public class A {
  public void print(int a, int b){
    System.out.println(a+b);
  }

  public void print(String a, String b){
    System.out.println(a.toUpperCase()+" "+b.toLowerCase());
  }

  public void print(){
    System.out.println("hello world!");
  }
}
