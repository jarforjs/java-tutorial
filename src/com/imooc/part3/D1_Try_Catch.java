package com.imooc.part3;

public class D1_Try_Catch {
  public static void main(String[] args) {
    D1_Try_Catch tct = new D1_Try_Catch();
    int result = tct.test1();
    System.out.println("test()方法执行完毕！返回值为："+result);
    int result2 = tct.test2();
    System.out.println("test2()方法执行完毕！返回值为："+result2);
    int result3 = tct.test3();
    System.out.println("test3()方法执行完毕！返回值为："+result3);
  }

  /**
   * divider(除数)
   * result(结果)
   * try-catch捕获while循环异常
   * 每次循环，divider减一，result= result+100/divider
   * 如果：捕获异常，打印输出"循环抛出异常了！！！"
   * 否则：返回result
   * @return result
   */
  public int test1() {
    int divider = 10;
    int result = 100;
    try {
      while (divider>-1){
        divider--;
        result+=100/divider;
      }
      return result;
    }catch (Exception e){
      e.printStackTrace();
      System.out.println("循环抛出异常了！！！"+result);
      return -1;
    }
  }

  /**
   * divider(除数)
   * result(结果)
   * try-catch捕获while循环异常
   * 每次循环，divider减一，result= result+100/divider
   * 如果：捕获异常，打印输出"循环抛出异常了！！！",返回result=999
   * 否则：返回result
   * finally：打印输出"这是finally！！！哈哈！！"，同时打印输出result的值
   * @return result
   */
  public int test2(){
    int divider = 10;
    int result = 100;
    try {
      while (divider>-1){
        divider--;
        result+=100/divider;
      }
      return result;
    }catch (Exception e){
      e.printStackTrace();
      System.out.println("循环抛出异常了！！！"+result);
      return result = 999;
    }finally {
      System.out.println("这是finally！！！哈哈！！"+result);
    }
  }

  /**
   * divider(除数)
   * result(结果)
   * try-catch捕获while循环异常
   * 每次循环，divider减一，result= result+100/divider
   * 如果：捕获异常，打印输出"循环抛出异常了！！！",
   * finally：打印输出"这是finally！！！哈哈！！"，同时打印输出result的值
   * 最后，返回1111作为结果
   * @return result
   */
  public int test3(){
    int divider = 10;
    int result = 100;
    try {
      while (divider>-1){
        divider--;
        result+=100/divider;
      }
      return result;
    }catch (Exception e){
      e.printStackTrace();
      System.out.println("循环抛出异常了！！！");
    }finally {
      System.out.println("这是finally！！！哈哈！！"+result);
    }
    System.out.println("我是test3，我运行完了");
    return 1111;
  }
}
