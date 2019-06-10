package com.imooc.part2.D13_Dada;

public class RentSystem {
  public String product;
  public int hire;
  public int number;
  public int ton;

  public int getNumber() {
    return number;
  }

  public void setNumber(int number) {
    this.number = number;
  }

  public int getTon() {
    return ton;
  }

  public void setTon(int ton) {
    this.ton = ton;
  }

  public String getProduct() {
    return product;
  }

  public void setProduct(String product) {
    this.product = product;
  }

  public int getHire() {
    return hire;
  }

  public void setHire(int hire) {
    this.hire = hire;
  }

  public String canMannedPeople(int number){
    return "载人:"+number+"人";
  }

  public String canCargoGoods(int ton){
    return "载货:"+ton+"吨";
  }
}








