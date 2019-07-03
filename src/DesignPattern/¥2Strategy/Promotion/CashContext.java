package DesignPattern.¥2Strategy.Promotion;

//改造后
public class CashContext {
  //声明一个CashSuper的对象
  CashSuper cashSuper = null;

  //参数不再是具体的收费策略对象，而是一个字符串，表示收费类型
  public CashContext(String type) {
    switch (type) {
      case "正常收费":
        cashSuper = new CashNormal();
        break;
      case "满300返100":
        cashSuper = new CashReturn(300, 100);
        break;
      case "打8折":
//        cashContext = new CashRebate(0.8);
//        break;
        CashRebate cashRebate = new CashRebate(0.8);
        cashSuper = cashRebate;
        break;
    }
  }

  public double GetResult(double money) {
    return cashSuper.acceptCash(money);
  }
}

//转移判断，策略与工厂相结合
//public class CashContext {
//  private CashSuper cs;
//
//  public CashContext(CashSuper cs) {
//    this.cs = cs;
//  }
//
//  public double GetResult(double money){
//    return cs.acceptCash(money);
//  }
//}
