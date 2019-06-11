package com.imooc.part2.d14;

public abstract class Car {
  private String name;
  private int price;

  public Car(String name, int price) {
    this.name = name;
    this.price = price;
  }

  public abstract String getCapacity();

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }
}
