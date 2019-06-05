package com.imooc.part2.D12_Abstract_Implements.Shape;

public class Initial {
  public static void main(String[] args) {
    Circle circle = new Circle(5);
    circle.circumference();
    circle.area();

    Rectangle rectangle = new Rectangle(5, 7);
    rectangle.circumference();
    rectangle.area();
  }
}
