package com.imooc.part2.d14;

public class HumanGoodCar extends Car implements ITranHuman, ITranGood {
  private int seatCount;
  private int goodWeight;

  public HumanGoodCar(String name, int price, int seatCount, int goodWeight) {
    super(name, price);
    this.seatCount = seatCount;
    this.goodWeight = goodWeight;
  }

  @Override
  public String getCapacity() {
    return "载人：" + seatCount + "人，载重：" + goodWeight + "吨";
  }

  @Override
  public int getSeatCount() {
    return seatCount;
  }

  @Override
  public void setSeatCount(int seatCount) {
    this.seatCount = seatCount;
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
