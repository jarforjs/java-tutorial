package com.imooc.part2.D14_Dada;

public abstract class Automobile {
  public String name;
  public int price;
  public int passengers;
  public int ton;

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

  public int getPassengers() {
    return passengers;
  }

  public void setPassengers(int passengers) {
    this.passengers = passengers;
  }

  public int getTon() {
    return ton;
  }

  public void setTon(int ton) {
    this.ton = ton;
  }
}








