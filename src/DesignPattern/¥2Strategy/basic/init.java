package DesignPattern.¥2Strategy.basic;

public class init {
  public static void main(String[] args) {
    Context context;
    context = new Context(new ConcreteStrategyA());
    context.ContextInterface();

    context = new Context(new ConcreteStrategyB());
    context.ContextInterface();

    context = new Context(new ConcreteStrategyC());
    context.ContextInterface();

    //由于实例化不同的策略，所以最终在调用context.ContextInterface()时，所获取的结果就不尽相同
    System.out.println("由于实例化不同的策略，所以最终在调用context.ContextInterface()时，所获取的结果就不尽相同");
  }
}
