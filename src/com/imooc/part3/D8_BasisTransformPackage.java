package com.imooc.part3;

public class D8_BasisTransformPackage {
  public static void main(String[] args) {
    //定义double类型变量
    double a = 91.5;

    //手动装箱
    Double a1=new Double(a);

    //自动装箱
    Double a2 =a;
    System.out.println("装箱后的结果为："+a1+"和"+a2);

    //定义一个Double包装类的对象，值为8
    Double b = new Double(87.0);

    //手动拆箱
    double b1 = b.doubleValue();

    //自动拆箱
    double b2=b;
    System.out.println("拆箱后的结果为："+b1+"和"+b2);
  }
}
