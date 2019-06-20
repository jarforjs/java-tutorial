package com.imooc.part3.D13_Collection_Map_Demo;

/**
 * 课程类
 */
public class Course {
  public String id;
  public String name;

  public Course(String id,String name){
    this.id=id;
    this.name=name;
  }

  public Course(){

  }

//  @Override
//  public boolean equals(Object o) {
//    if(this ==o) return true;
//    if(o==null) return false;
//    if(!(o instanceof Course)) return false;
//    Course course = (Course) o;
//    if(this.name==null){
//      if(course.name==null){
//        return true;
//      }else{
//        return false;
//      }
//    }else {
//      if(this.name.equals(course.name)){
//        return true;
//      }else {
//        return false;
//      }
//    }
//  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Course)) return false;

    Course course = (Course) o;

    return name.equals(course.name);

  }

  @Override
  public int hashCode() {
    return name.hashCode();
  }
}
