package com.imooc.part2.d14;

public class HumanCar extends Car implements ITranHuman {
  private int seatCount;

  public HumanCar(String name, int price, int seatCount) {
    super(name, price);
    this.seatCount = seatCount;
  }

  @Override
  public String getCapacity() {
    return "载人：" + seatCount + "人";
  }

  @Override
  public int getSeatCount() {
    return seatCount;
  }

  @Override
  public void setSeatCount(int seatCount) {
    this.seatCount = seatCount;
  }
}
