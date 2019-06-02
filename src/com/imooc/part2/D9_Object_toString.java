package com.imooc.part2;

public class D9_Object_toString extends D8_Inherit_Animal {
  int age1 = 1000;
  public D9_Object_toString(int number) {
    super(number);
  }
  public static void main(String[] args){
    D9_Object_toString toString = new D9_Object_toString(1000);
    System.out.println(toString);
  }

  @Override
  public String toString() {
    return "D9_Object_toString{" + "phoneNumber=" + phoneNumber + '}';
  }
}
