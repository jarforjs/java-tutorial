package DesignPattern.simpleFactory.VehicleFactory;

public class BroomFactory extends VehicleFactory {
  public Moveable create(){
    return new Broom();
  }
}
