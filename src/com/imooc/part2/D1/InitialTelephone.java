package com.imooc.part2.D1;

public class InitialTelephone {

  public static void main(String[] args) {
    Telephone phone = new Telephone();
    phone.sendMessage();
    phone.screen = 5.0f;
    phone.cpu = 2;
    phone.memory = 2.9f;
    phone.sendMessage();
  }
}
