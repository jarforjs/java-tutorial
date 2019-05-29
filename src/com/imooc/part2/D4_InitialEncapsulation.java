package com.imooc.part2;

public class D4_InitialEncapsulation {

  public static void main(String[] args) {
    D4_Encapsulation phone = new D4_Encapsulation();
    D4_Encapsulation phone2 = new D4_Encapsulation(5.0f,2.4f,3.0f);
    phone2.setScreen(6.0f);
    System.out.println(phone2.getScreen());
  }
}
