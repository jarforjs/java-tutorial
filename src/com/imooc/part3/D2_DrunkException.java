package com.imooc.part3;

public class D2_DrunkException extends Exception {

  //无参的构造器
  public D2_DrunkException(){

  }

  // 有参的构造器
  public D2_DrunkException(String message){
    super(message);
  }
}
