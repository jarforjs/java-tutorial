package com.imooc.part2.D12_Abstract_Implements;

public class Cellphone extends Telephone {
  @Override
  public void call() {
    System.out.println("通过键盘来拨号的");
  }

  @Override
  public void sendMessage() {
    System.out.println("通过键盘来发短信的");
  }
}
