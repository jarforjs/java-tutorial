package com.imooc.part2.d14;

public class GoodCar extends Car implements ITranGood {
  private int goodWeight;

  public GoodCar(String name, int price, int goodWeight) {
    super(name, price);
    this.goodWeight = goodWeight;
  }

  @Override
  public String getCapacity() {
    return "载重：" + goodWeight + "吨";
  }

  @Override
  public int getGoodWeight() {
    return goodWeight;
  }

  @Override
  public void setGoodWeight(int goodWeight) {
    this.goodWeight = goodWeight;
  }
}
