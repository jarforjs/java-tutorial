package com.imooc.part2.D12_Abstract_Implements.Shape;

public class Rectangle extends Shape {
  private double width;
  private double height;

  Rectangle(double width, double height) {
    this.width = width;
    this.height = height;
  }

  @Override
  public void circumference() {
    System.out.println("矩形的周长是：2 * (width + height) = " + 2 * (width + height));

  }

  @Override
  public void area() {
    System.out.println("矩形的面积是：width * height = " + width * height);
  }
}
