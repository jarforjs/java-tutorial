package com.imooc.part2.D14_Dada;

public class Car extends Automobile {

  public Car(String name, int price, int passengers) {
    this.setName(name);
    this.setPrice(price);
    this.setPassengers(passengers);
  }

  @Override
  public String getCapacity() {
    return "载人：" + this.getPassengers() + "人";
  }
}
