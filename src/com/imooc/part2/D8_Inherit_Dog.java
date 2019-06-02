package com.imooc.part2;

public class D8_Inherit_Dog extends D8_Inherit_Animal {
  public D8_Inherit_Dog(int number) {
    super(number);
    System.out.println(super.phoneNumber + "phoneNumber");
    System.out.println("Dog类构造方法执行了");
  }

  public void eat() {
    System.out.println("年龄:" + age + ",狗喜欢吃骨头!");
  }
}
