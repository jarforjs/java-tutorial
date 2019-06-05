package com.imooc.part2.D12_Abstract_Implements;

public class Smartphone extends Telephone implements IPlayGame {
  @Override
  public void call() {
    System.out.println("通过点击屏幕来拨号");
  }

  @Override
  public void sendMessage() {
    System.out.println("通过点击屏幕来发信息");
  }

  @Override
  public void paleGame() {
    System.out.println("具有了玩游戏的功能, smartphone");
  }
}
