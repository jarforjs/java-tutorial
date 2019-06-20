package com.imooc.part3.D13_Collection_Map_Demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class MapTest {

  /**
   * 用来承装学生类的对象
   */
  public Map<String, Student> students;

  /**
   * 在构造器中初始化students属性
   */
  public MapTest() {
    this.students = new HashMap<String, Student>();
  }

  public static void main(String[] args) {
    MapTest mt = new MapTest();
    mt.testPut();
    mt.testKeySet();
//    mt.testRemove();
//    mt.testEntrySet();

//    mt.testModify();
//    mt.testEntrySet();

    mt.testContainsKeyOrValue();

  }

  /**
   * 测试添加：输入学生ID，判断是否被占用
   * 若未被占用，则输入姓名，创建新学生对象，并且添加到students中
   */
  public void testPut() {
    // 创建一个Scanner对象，用来获取输入的学生ID和姓名
    Scanner console = new Scanner(System.in);
    int i = 0;
    while (i < 3) {
      System.out.println("请输入学生ID:");
      String ID = console.next();
      //判断该ID是否被占用
      Student st = students.get(ID);
      if (st == null) {
        //提示输入学生姓名
        System.out.println("请输入学生姓名");
        String name = console.next();
        // 创建学生对象
        Student newStudent = new Student(ID, name);
        // 通过调用students的put方法，添加一个学生ID和学生的映射关系
        students.put(ID, newStudent);
        System.out.println("成功添加学生：" + students.get(ID).name);
        i++;
      } else {
        System.out.println("该学生ID已经被占用！");
      }
    }
  }

  /**
   * 测试Map的keySet方法
   */
  public void testKeySet() {
    // 通过keySet方法，返回Map中所有"键"的"Set"集合
    Set<String> keySet = students.keySet();
    // 取得students的容量
    System.out.println("总共有：" + keySet.size() + "个学生。");

    // 遍历keySet，取得每一个键，再调用get方法取得每个键对应的value
    for (String stuId : keySet) {
      Student st = students.get(stuId);
      if (st != null) {
        System.out.println("学生：" + st.name);
      }
    }
  }

  /**
   * 通过entrySet方法来遍历Map
   */
  public void testEntrySet() {
    //通过entrySet方法，返回Map中的所有键值对
    Set<Map.Entry<String, Student>> entrySet = students.entrySet();
    // 取得students的容量
    System.out.println("总共有：" + entrySet.size() + "个学生。");
    for (Map.Entry<String, Student> es : entrySet) {
      System.out.println("取得的键：" + es.getKey() + ",对应的值为：" + es.getValue().name);
    }
  }

  /**
   * 测试删除Map中的映射
   */
  public void testRemove() {
    Scanner console = new Scanner(System.in);
    while (true) {
      // 提示输入待删除学生的ID
      System.out.println("请输入要删除的学生ID：");
      String ID = console.next();
      // 判断该ID是否又对应的学生对象
      Student student = students.get(ID);

      if (student == null) {
        // 提示输入的ID并不存在
        System.out.println("该ID不存在");
        continue;
      }

      students.remove(ID);
      System.out.println("成功删除学生：" + student.name);
      break;
    }
  }

  /**
   * 利用put方法修改Map中已有映射
   */
  public void testModify() {
    Scanner console = new Scanner(System.in);
    while (true) {
      // 提示输入要修改学生的ID
      System.out.println("请输入要修改的学生ID：");
      String ID = console.next();
      // 判断该ID是否又对应的学生对象
      Student student = students.get(ID);

      if (student == null) {
        // 提示输入的ID并不存在
        System.out.println("该ID不存在，请重新输入");
        continue;
      }

      // 提示当前对应的学生对象的姓名
      System.out.println("当前学生ID:" + ID + ",所对应的学生为：" + student.name);
      System.out.println("请输入新的学生姓名：");
      String name = console.next();
      Student newStudent = new Student(ID, name);
      students.put(ID, newStudent);
      System.out.println("修改成功");
      break;
    }

  }

  /**
   * 测试Map中，是否包含某个key值或者某个value值
   */
  public void testContainsKeyOrValue() {
    // 提示输入学生ID
    System.out.println("请输入要查询的学生ID：");
    Scanner console = new Scanner(System.in);
    String ID = console.next();
    // 在Map中，用containsKey方法，来判断是否包含某个key值
    System.out.println("您输入的学生ID为：" + ID + "，在学生映射表中是否存在:" + students.containsKey(ID));
    if (students.containsKey(ID)) {
      System.out.println("对应的学生为：" + students.get(ID).name);
    }

    // 提示输入学生姓名
    System.out.println("请输入要查询的学生姓名：");
    String name = console.next();
    // 用containsValue方法，来判断是否包含某个value值
    System.out.println("您输入的学生姓名为：" + name);
    if (students.containsValue(new Student(null, name))) {
      System.out.println("在学生映射表中,确实包含学生：" + name);
    } else {
      System.out.println("在学生映射表中不存在该学生");

    }

  }
}
