package com.imooc.part2.D14_Dada;

public class Pickup extends Automobile implements ITranPeople, ITranGoods {

  public int seatCount;
  public int goodsWeight;

  public Pickup(String name, int rent, int seatCount, int goodsWeight) {
    super(name, rent);
    this.seatCount = seatCount;
    this.goodsWeight = goodsWeight;
  }

  @Override
  public String getCapacity() {
    return "载人：" + seatCount + "人，载重：" + goodsWeight + "吨";
  }

  @Override
  public int getGoodsWeight() {
    return goodsWeight;
  }

  @Override
  public int getSeatCount() {
    return seatCount;
  }
}
