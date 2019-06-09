package com.imooc.part2.D13_Dada;

public class Lorry extends RentSystem {

  public Lorry(String product, int hire, int ton) {
    setProduct(product);
    this.setHire(hire);
    this.setTon(ton);
  }

  @Override
  public String toString() {
    return getProduct()+"\t"+getHire()+"元/天\t"+canCargoGoods(this.getTon());
  }
}
