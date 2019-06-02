package com.imooc.part2;

public class D8_Inherit_Animal {
  public int age = 10;
  public int phoneNumber;
  public String name;

  public D8_Inherit_Animal(int phoneNumber) {
    System.out.println("Animal类构造方法执行了");
    age = 50;
    this.phoneNumber = phoneNumber;
  }

  public void eat() {
    System.out.println("动物有吃饭的能力.");
  }

//  public D8_Inherit_Animal(){
//    System.out.println("Animal类构造方法执行了");
//    age=50;
//  }
}
