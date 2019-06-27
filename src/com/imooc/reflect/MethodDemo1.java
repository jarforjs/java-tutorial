package com.imooc.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodDemo1 {
  public static void main(String[] args) {
    //1.要获取一个方法，就是获取类的信息，获取类的信息首先就是要获取类的类类型
    A a1=new A();
    Class c=a1.getClass();
    /**
     * 2.获取方法名称和参数列表
     * getMethod获取的是public的方法
     * getDeclaredMethod自己声明的方法
     */
    try {
      Method m = c.getMethod("print", int.class, int.class);
//      Method m = c.getMethod("print", new Class[]{int.class, int.class});
      //方法的放射操作
      /*
       * 以前我们调用方法：可能就是a1.print(10,20)
       * 方法的反射操作是用m对像来进行方法调用和a1.print调用效果完全相同
       * 我们用print代表的m这个方法对象来操作a1
       */
//      Object o = m.invoke(a1,new Object[]{10,20});
      // 方法如果没有返回值返回null，有返回值返回具体的返回值
      // 但是他认为是Object，所以我们要做强制类型转换
      Object o = m.invoke(a1,10,20);
      System.out.println("=======================");

      //获取方法print(String,String)
      Method m1=c.getMethod("print", String.class,String.class);
      //用方法进行反射操作
      Object o1 = m1.invoke(a1,"hello","WORLD");
      System.out.println("=======================");

      //对于没有参数的方法
//      Method m2=c.getMethod("print",new Class[]{});
      Method m2=c.getMethod("print");
//      m2.invoke(a1,new Class[]{});
      m2.invoke(a1);
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    }
  }
}

