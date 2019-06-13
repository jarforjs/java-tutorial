package com.imooc.part2.D14_Dada;

public class PassageCar extends Automobile implements ITranPeople {

  public int seatCount;

  public PassageCar(String name, int rent, int seatCount) {
    super(name, rent);
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
}
