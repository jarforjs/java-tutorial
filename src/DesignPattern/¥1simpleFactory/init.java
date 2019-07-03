package DesignPattern.¥1simpleFactory;

public class init {
  public static double total = 0.0d;

  public static void main(String[] args) {
    CashSuper cashSuper = CashFactory.createCashAccept("正常收费");
    double totalPrices = 0d;
//    totalPrices = cashSuper.acceptCash("金额"*"数量");
    totalPrices = cashSuper.acceptCash(300*3);
    total += totalPrices;
    System.out.println("单价："+300+"数量："+3+"合计："+totalPrices);
    System.out.println("总计："+total);
  }
}
