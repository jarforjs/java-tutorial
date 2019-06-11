package com.imooc.part2.D14_Dada;

public class Jeep extends Automobile {

  public Jeep(String name, int price, int passengers, int ton) {
    this.setName(name);
    this.setPrice(price);
    this.setPassengers(passengers);
    this.setTon(ton);
  }

  @Override
  public String getCapacity() {
    return "载人：" + this.getPassengers() + "人, 载货：" + this.getTon() + "吨";
  }

}
