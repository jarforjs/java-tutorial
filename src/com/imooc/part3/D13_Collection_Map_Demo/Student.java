package com.imooc.part3.D13_Collection_Map_Demo;

import java.util.HashSet;
import java.util.Set;

/**
 * 学生类
 */
public class Student {
  public String id;
  public String name;
  public Set course;

  public Student(String id,String name){
    this.id= id;
    this.name=name;

    // 我们不能直接实例化Set，Set是接口，所以我们要用HashSet（Set的实现类）
    this.course=new HashSet();
  }
}
