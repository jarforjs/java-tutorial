package DesignPattern.simpleFactory.VehicleFactory;

public class init {
  public static void main(String[] args) {
    // Car的构造函数私有化了，所以不能new了
//    Car car = new Car();
    // 只能使用getInstance方法了
//    Car car = Car.getInstance();
//    car.run();

    VehicleFactory factory = new CarFactory();
    Moveable m = factory.create();
    m.run();

    VehicleFactory factory1 = new PlaneFactory();
    Moveable m1 = factory1.create();
    m1.run();

    VehicleFactory factory2 = new BroomFactory();
    Moveable m2 = factory2.create();
    m2.run();
  }
}
