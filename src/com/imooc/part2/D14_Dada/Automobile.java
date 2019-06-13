package com.imooc.part2.D14_Dada;

public abstract class Automobile {
  public String name;
  public int rent;

  public abstract String getCapacity();

  public Automobile(String name, int rent) {
    this.name = name;
    this.rent = rent;
  }
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getRent() {
    return rent;
  }

  public void setRent(int rent) {
    this.rent = rent;
  }
}








