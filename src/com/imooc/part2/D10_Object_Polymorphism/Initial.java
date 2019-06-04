package com.imooc.part2.D10_Object_Polymorphism;

public class Initial {
  public static void main(String[] args) {
    Transportation transport = new Transportation();
    transport.method();

    Transportation steamer = new Steamer();
    steamer.setWay("海洋");
    steamer.setNumber(40);
    steamer.method();

    Transportation bus = new Bus();
    bus.setWay("陆地");
    bus.setNumber(40);
    bus.method();
    Bus no_eightThree = new Bus();
    no_eightThree.payment();

    Transportation aeroplane = new Aeroplane();
    aeroplane.setWay("天空");
    aeroplane.setNumber(1000);
    aeroplane.method();

    Transportation bicycle = new Bicycle();
    bicycle.method();
  }
}
