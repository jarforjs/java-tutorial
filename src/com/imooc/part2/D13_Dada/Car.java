package com.imooc.part2.D13_Dada;

public class Car extends RentSystem {

  public Car(String product, int hire, int number) {
    setProduct(product);
    this.setHire(hire);
    this.setNumber(number);
  }

  @Override
  public String toString() {
    return getProduct()+"\t"+getHire()+"元/天\t"+canMannedPeople(this.getNumber());
  }
}
