package DesignPattern.Bridge;

public class WildGift extends Gift {
  public WildGift(GiftImpl giftImpl){
    this.giftImpl = giftImpl;
  }
}