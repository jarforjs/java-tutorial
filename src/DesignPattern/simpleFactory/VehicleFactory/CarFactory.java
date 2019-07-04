package DesignPattern.simpleFactory.VehicleFactory;

public class CarFactory extends VehicleFactory {
  public Moveable create(){
    return new Car();
  }
}
