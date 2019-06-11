package com.imooc.part2.D14_Dada;

public class Lorry extends Automobile {

  public Lorry(String name, int price, int ton) {
    this.setName(name);
    this.setPrice(price);
    this.setTon(ton);
  }

  @Override
  public String getCapacity() {
    return "载货：" + this.getTon() + "吨";
  }
}
