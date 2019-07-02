package DesignPattern.Bridge;

public class WarmGift extends Gift {
  public WarmGift(GiftImpl giftImpl){
    this.giftImpl = giftImpl;
  }
}
