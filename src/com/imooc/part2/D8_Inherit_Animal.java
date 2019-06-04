package com.imooc.part2;

import java.util.Objects;

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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null) return false;
//    if (getClass() != o.getClass()) return false;
    if (!(o instanceof D8_Inherit_Animal)) return false;
    D8_Inherit_Animal that = (D8_Inherit_Animal) o;

    return age == that.age;
  }
}
