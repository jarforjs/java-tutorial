package DesignPattern.Strategy.Promotion;

public class init {
  public static double total = 0.0d;

  public static void main(String[] args) {
    //将算法的字符串传入CashContext的对象中
    CashContext cashContext = new CashContext("打8折");

    double totalPrices = 0d;
//    totalPrices = cashSuper.acceptCash("金额"*"数量");
    //通过调用Context的GetResult方法的调用，可以得到收取费用的结果，让具体算法与客户进行了隔离
    totalPrices = cashContext.GetResult(300 * 3);
    total += totalPrices;
    System.out.println("单价：" + 300 + "数量：" + 3 + "合计：" + totalPrices);
    System.out.println("总计：" + total);
  }
}
// 简单工厂模式
// CashSuper cashSuper = CashFactory.createCashAccept("正常收费");

// 策略模式与简单工厂结合的用法
// CashContext cashContext = new CashContext("打8折");

// 简单工厂模式需要让客户端认识两个类，CashSuper和CashFactory；而策略与简单工厂组合的用法，客户端只需要认识一个类CashContext就可以了。耦合更加降低。

// 我们在客户端实例化的是CashContext的对象，调用的是CashContext的方法GetResult，这使得具体的收费算法彻底地与客户端分离。连算法的父类CashSuper都不让客户端认识了。

//public class init {
//  public static double total = 0.0d;
//
//  public static void main(String[] args) {
//    CashContext cashContext =null;
//    switch ("满300返100"){
//      case "正常收费":
//        cashContext=new CashContext(new CashNormal());
//        break;
//      case "满300返100":
//        cashContext=new CashContext(new CashReturn(300,100));
//        break;
//      case "打8折":
//        cashContext = new CashContext(new CashRebate(0.8));
//        break;
//    }
//
//    double totalPrices = 0d;
////    totalPrices = cashSuper.acceptCash("金额"*"数量");
//    //通过调用Context的GetResult方法的调用，可以得到收取费用的结果，让具体算法与客户进行了隔离
//    totalPrices = cashContext.GetResult(300*3);
//    total += totalPrices;
//    System.out.println("单价："+300+"数量："+3+"合计："+totalPrices);
//    System.out.println("总计："+total);
//  }
//}
