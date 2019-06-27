package com.imooc.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassUtil {
  /**
   * 打印类信息，包括类的成员函数
   * @param o 该对象所属类的信息
   */
  public static void printClassMethodInfo(Object o){
    //要获取类的信息，首先要获得类的类类型
    //传递的是哪个子类的对象，c就是哪个子类的类类型
    Class c = o.getClass();
    System.out.println("类的名称是："+c.getName());

    /*
     * Method类，方法对象
     * 一个成员方法就是一个Method对象
     * getMethods方法获取的是所有public的方法包括父类继承而来的
     * getDeclaredMethods方法获取的是所有自己声明的方法，不问访问权限
     */
    Method[] ms =c.getMethods();
//    Method[] ms1 =c.getDeclaredMethods();
    for (Method m : ms) {
      //得到方法的返回值类型的类类型
      Class returnType = m.getReturnType();
      System.out.print(returnType.getSimpleName()+" ");
      //得到方法的名称
      System.out.print(m.getName()+"(");
      //获取参数类型,得到方法的参数列表的类型的类类型
      Class[] paramTypes=m.getParameterTypes();
      for (Class paramType: paramTypes) {
        System.out.print(paramType.getName()+",");
      }
      System.out.println(")");
    }
  }

  /**
   * 获取成员变量的信息，自己声明的
   * @param o 该对象所属类的信息
   */
  public static void printClassFieldInfo(Object o) {
    Class c=o.getClass();
    /*
     * 成员变量也是对象
     * java.lang.reflect.Field
     * Field类封装了关于成员变量的操作
     * getFields方法获取的是所有public的成员变量的信息
     */
//      Field[] fs=c.getFields();
    Field[] fs1=c.getDeclaredFields();
    for(Field field:fs1){
      //获取的成员变量的类型的类类型
      Class fieldType = field.getType();
      String typeName=fieldType.getName();
      String fieldName =field.getName();
      System.out.println(typeName+" "+fieldName);
    }
  }

  /**
   * 获取对象的构造函数的信息
   * @param o 该对象所属类的信息
   */
  public static void printConstructorInfo(Object o){
    Class c=o.getClass();
    /*
     * 构造函数也是对象
     * java.lang.Constructor中封装了构造函数的信息
     * getConstructors获得所有public的构造方法
     * getDeclaredConstructors获取所有（自己声明）的构造函数（构造函数都是自己声明的）
     */
//    Constructor[] cs = c.getConstructors();
    Constructor[] cs = c.getDeclaredConstructors();
    for(Constructor constructor:cs){
      System.out.print(constructor.getName()+"(");
      Class[] parameterTypes = constructor.getParameterTypes();
      for(Class parameterType:parameterTypes){
        System.out.print(parameterType.getName()+",");
      }
      System.out.println(")");
    }
  }
}
