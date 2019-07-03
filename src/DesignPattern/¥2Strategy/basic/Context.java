package DesignPattern.¥2Strategy.basic;

public class Context {
  Strategy strategy;

  //初始化时，传入具体的策略对象
  public Context(Strategy strategy) {
    this.strategy = strategy;
  }

  //上下文接口
  public void ContextInterface(){
    //根据具体的策略对象，调用其算法的方法
    strategy.AlgorithmInterface();
  }
}
