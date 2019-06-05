package com.imooc.part2.D12_Abstract_Implements;

public class Initial {
  public static void main(String[] args){
    Telephone tel1 = new Cellphone();
    tel1.call();
    tel1.sendMessage();

    Telephone tel2 = new Smartphone();
    tel2.call();
    tel2.sendMessage();

    // 接口
    IPlayGame ip1 = new Smartphone();
    IPlayGame ip2 = new Psp();
    ip1.paleGame();
    ip2.paleGame();

    //匿名内部类
    IPlayGame ip3 = new IPlayGame() {
      @Override
      public void paleGame() {
        System.out.println("使用匿名内部类的方式实现接口");
      }
    };
    ip3.paleGame();

    //直接使用接口
    new IPlayGame(){

      @Override
      public void paleGame() {
        System.out.println("安卓开发更多的会使用这种直接使用匿名内部类的方式实现接口");
      }
    }.paleGame();
  }
}
