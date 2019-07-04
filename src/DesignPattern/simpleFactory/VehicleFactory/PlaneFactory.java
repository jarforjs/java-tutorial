package DesignPattern.simpleFactory.VehicleFactory;

public class PlaneFactory extends VehicleFactory {
  public Moveable create(){
    return new Plane();
  }
}
