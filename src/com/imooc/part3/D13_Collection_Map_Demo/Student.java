package com.imooc.part3.D13_Collection_Map_Demo;

import java.util.HashSet;
import java.util.Set;

/**
 * 学生类
 */
public class Student implements Comparable<Student> {
  public String id;
  public String name;
  public Set<Course> course;

  public Student(String id,String name){
    this.id= id;
    this.name=name;

    // 我们不能直接实例化Set，Set是接口，所以我们要用HashSet（Set的实现类）
    this.course = new HashSet<Course>();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Student)) return false;

    Student student = (Student) o;

    return name.equals(student.name);

  }

  @Override
  public int hashCode() {
    return name.hashCode();
  }

  @Override
  public int compareTo(Student o) {
    return this.id.compareTo(o.id);
  }
}
