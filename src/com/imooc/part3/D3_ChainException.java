package com.imooc.part3;

public class D3_ChainException {
  /**
   * test1():抛出"喝大了"异常
   * test2():调用test1()，捕获"喝大了"异常，并且包装成运行时异常，继续抛出
   * main方法中，调用test2()，尝试捕获test()方法抛出的异常
   */
  public static void main(String[] args) {
    D3_ChainException ct = new D3_ChainException();
    try {
      ct.test2();
    }catch (Exception e){
      e.printStackTrace();
    }
  }

  public void test1() throws D2_DrunkException{
    // 抛出异常前，必须声明将要抛出异常 throws Exception
    throw new D2_DrunkException("开车别喝酒！");
  }

  public void test2(){
    try{
      // test1方法抛出了一个异常在test2方法中必须用try catch来包围这个异常
      test1();
    }catch (D2_DrunkException e){
      // 1.捕获"喝大了"异常，并且包装成运行时异常，继续抛出
//      RuntimeException newExc = new RuntimeException("司机一滴酒，情人两行泪");
//      newExc.initCause(e);
//      throw newExc;

      // 2.简便点的方法
      // 捕获"喝大了"异常，并且包装成运行时异常，继续抛出
//      RuntimeException newExc = new RuntimeException(e);
////    newExc.initCause(e);
//      throw newExc;

      // 3.最终：
      throw new RuntimeException(e);
    }
  }
}
