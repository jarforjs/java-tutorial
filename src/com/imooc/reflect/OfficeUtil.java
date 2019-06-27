package com.imooc.reflect;

public class OfficeUtil {
  /**
   * 打印类信息，包括类的成员变量、成员函数
   * @param obj 该对象所属类的信息
   */
  public static void printClassMessage(Object obj){
    //要获取类的信息，首先要获得类的类类型
    //传递的是哪个子类的对象，c就是哪个子类的类类型
    Class c = obj.getClass();

  }
}
