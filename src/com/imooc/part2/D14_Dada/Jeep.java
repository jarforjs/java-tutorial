package com.imooc.part2.D14_Dada;

public class Jeep extends RentSystem {

  public Jeep(String product, int hire, int number, int ton) {
    setProduct(product);
    this.setHire(hire);
    this.setNumber(number);
    this.setTon(ton);
  }

  @Override
  public String toString() {
    return getProduct()+"\t"+getHire()+"元/天\t"+canMannedPeople(this.getNumber())+" "+canCargoGoods(this.getTon());
  }

}
