package com.imooc.part2.D12_Abstract_Implements.Shape;

public class Circle extends Shape {
  private double radius;

  Circle(double radius) {
    this.radius = radius;
  }

  @Override
  public void circumference() {
    System.out.println("圆的周长是：2 * Math.PI * radius = " + 2 * Math.PI * radius);
  }

  @Override
  public void area() {
    System.out.println("圆的面积是：Math.PI * Math.pow(radius, 2) = " + Math.PI * Math.pow(radius, 2));
  }

}
