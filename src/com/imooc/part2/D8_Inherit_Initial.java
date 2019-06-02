package com.imooc.part2;

public class D8_Inherit_Initial {
  public static void main(String[] args) {
    D8_Inherit_Dog dog = new D8_Inherit_Dog(133333);
    dog.age = 31;
    dog.name = "jack";
    dog.eat();
    System.out.println(dog.phoneNumber + "pn");
    D8_Inherit_Animal animal = new D8_Inherit_Animal(14444);
    System.out.println("父类animal中的属性age是:" + animal.age + ".手机号码是:" + animal.phoneNumber);
  }
}
