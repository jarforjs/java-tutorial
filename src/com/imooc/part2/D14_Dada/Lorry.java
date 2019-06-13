package com.imooc.part2.D14_Dada;

public class Lorry extends Automobile implements ITranGoods {
  public int goodsWeight;

  public Lorry(String name, int rent, int goodsWeight) {
    super(name, rent);
    this.goodsWeight = goodsWeight;
  }

  @Override
  public String getCapacity() {
    return "载重：" + goodsWeight + "吨";
  }

  @Override
  public int getGoodsWeight() {
    return goodsWeight;
  }
}
