package com.imooc.part3.D13_Collection_Map_Demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * 备选课程类
 */
public class ListTest {

  /**
   * 用于存放备选课程的list
   */
  public List coursesToSelect;

  public ListTest(){
    this.coursesToSelect=new ArrayList();
  }

  /**
   * 用于往coursesToSelect中添加备选课程
   */
  public void testAdd(){
    // 创建一个课程对象，并通过调用add方法，添加到备选课程List中
    Course cr1 = new Course("1","数据结构");
    coursesToSelect.add(cr1);
    // 注意：对象存入集合都编程Object类型，取出时需要类型转换
    Course temp = (Course) coursesToSelect.get(0);
    System.out.println("添加了课程："+temp.id+":"+temp.name);

    Course cr2 = new Course("2","C语言");
    coursesToSelect.add(0,cr2);
    Course temp2 = (Course) coursesToSelect.get(0);
    System.out.println("添加了课程："+temp2.id+":"+temp2.name);


    // 重复添加课程
    coursesToSelect.add(cr1);
    Course temp0 = (Course) coursesToSelect.get(2);
    System.out.println("添加了重复课程："+temp0.id+":"+temp0.name);

    //如果coursesToSelect备选课程size为2，你往index4（index>size),就会抛数组下标越界异常
//    Course cr3 = new Course("3","test");
//    coursesToSelect.add(4,cr3);

    Course[] courses = {new Course("3","离散数学"), new Course("4","汇编语言")};
    coursesToSelect.addAll(Arrays.asList(courses));
    Course temp3=(Course) coursesToSelect.get(3);
    Course temp4=(Course) coursesToSelect.get(4);
    System.out.println("添加了2门课程："+temp3.id+":"+temp3.name+"；"+temp4.id+":"+temp4.name);

    Course[] courses2 = {new Course("5","高等数学"), new Course("6","大学英语")};
    coursesToSelect.addAll(2,Arrays.asList(courses2));
    Course temp5=(Course) coursesToSelect.get(2);
    Course temp6=(Course) coursesToSelect.get(3);
    System.out.println("添加了2门课程："+temp5.id+":"+temp5.name+"；"+temp6.id+":"+temp6.name);

  }

  /**
   * 取得List中的元素
   */
  public void testGet(){
    int size = coursesToSelect.size();
    System.out.println("有如下课程待选：");
    for(int i=0;i<size;i++){
      Course cr = (Course) coursesToSelect.get(i);
      System.out.println("课程："+cr.id+":"+cr.name);
    }
  }

  /**
   * 通过迭代器来遍历List
   * 迭代器只是用来遍历集合中元素，本身不具备任何存储元素的功能。
   * 也可以说迭代器是依赖某个集合存在的，本身不能独立的存在
   */
  public void testIterator(){
    Iterator it=coursesToSelect.iterator();
    System.out.println("有如下课程待选(通过迭代器访问)：");
    while (it.hasNext()){
      Course cr= (Course) it.next();
      System.out.println("课程："+cr.id+":"+cr.name);

    }
  }

  /**
   * 通过for each访问集合元素
   */
  public void testForEach(){
    System.out.println("有如下课程待选(通过for each访问)：");
    for (Object o:coursesToSelect){
      Course cr=(Course)o;
      System.out.println("课程："+cr.id+":"+cr.name);
    }
  }

  /**
   * 修改List中的元素
   */
  public void testModify(){
    coursesToSelect.set(4,new Course("7","毛概"));
  }

  /**
   * 删除List中的元素
   */
  public void testRemove(){
    Course cr =(Course)coursesToSelect.get(4);
//    System.out.println("我是课程："+cr.id+":"+cr.name+",我即将被删除");
//    coursesToSelect.remove(cr);
    // 也可以通过索引来删除课程
//    coursesToSelect.remove(4);

    // removeAll
    System.out.println("即将被删除4位置和5位置上的书籍");
    Course[] courses={cr,(Course)coursesToSelect.get(5)};
    // 通过Arrays工具类将courses数组转化成courses集合当参数传进去
    coursesToSelect.removeAll(Arrays.asList(courses));
    System.out.println("成功删除课程!");
    testForEach();
  }

  /**
   * 往List中添加一些奇怪的东西
   */
  public void testType(){
    System.out.println("能否往List中添加一些奇怪的东西呢？");
    coursesToSelect.add("我不是课程，我只是一个无辜的字符串！！");
  }
  public static void main(String[] args) {
    ListTest lt = new ListTest();
    lt.testAdd();
    lt.testType();
    lt.testForEach();
//    lt.testGet();
//    lt.testIterator();
//    lt.testForEach();
//    lt.testModify();
//    lt.testForEach();
//    lt.testRemove();
  }


}
