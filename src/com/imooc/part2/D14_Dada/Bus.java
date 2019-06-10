package com.imooc.part2.D14_Dada;

public class Bus extends RentSystem {

  public Bus(String product, int hire, int number) {
    setProduct(product);
    this.setHire(hire);
    this.setNumber(number);
  }

  @Override
  public String toString() {
    return getProduct()+"\t"+getHire()+"元/天\t"+canMannedPeople(this.getNumber());
  }

}
