package DesignPattern.simpleFactory.VehicleFactory;

import java.util.ArrayList;
import java.util.List;

public class Car implements Moveable {
  // 单例
  private static Car car = new Car();
  // 多例
  private static List<Car> carList = new ArrayList<Car>();

//  private Car(){}

  //静态工厂方法
  public static Car getInstance(){
    return car;
  }

  public void run(){
    System.out.println("开咯car。。。");
  }
}
