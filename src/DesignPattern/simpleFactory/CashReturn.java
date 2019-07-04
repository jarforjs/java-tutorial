package DesignPattern.simpleFactory;

/**
 * 返利收费子类
 */
public class CashReturn extends CashSuper {

  private double moneyReturn = 0.0d;
  private double moneyCondition = 0.0d;

  public CashReturn(double moneyReturn, double moneyCondition) {
    this.moneyReturn = moneyReturn;
    this.moneyCondition = moneyCondition;
  }

  @Override
  public double acceptCash(double money) {
    double result = money;
    if(money>moneyCondition){
      result=money-Math.floor(money/moneyCondition)*moneyReturn;
    }
    return result;
  }
}
