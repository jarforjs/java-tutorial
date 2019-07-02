package DesignPattern.Bridge;

public class GG {
  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void pursue(MM mm){
    Gift gift = new WarmGift(new Flower());
    Gift gift1 = new WildGift(new Ring());
    give(gift, mm);
  }

  public void give(Gift gift, MM mm){

  }
}
