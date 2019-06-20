package com.imooc.part3.D13_Collection_Map_Demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SetTest {

  public List<Course> coursesToSelect;
  public Scanner console;
  public Student student;

  public SetTest() {
    coursesToSelect = new ArrayList<Course>();
    console = new Scanner(System.in);
  }

  public static void main(String[] args) {
    SetTest st = new SetTest();
    st.testAdd();
    st.testForEach();
    st.testListContains();
    st.testForEach();
//    st.createStudentAndSelectCourse();
//    st.testSetContains();

//
//    // 创建一个学生对象
//    Student student = new Student("1", "小明");
//    System.out.println("欢迎学生：" + student.name + "选课！");
//
//    // 创建一个Scanner对象，用来接收从键盘输入的课程ID
//    Scanner console = new Scanner(System.in);
//
//    for (int i = 0; i < 3; i++) {
//      System.out.println("请输入课程ID");
//      String courseId = console.next();
//      for (Course cr : st.coursesToSelect) {
//        // cr.id是一个字符串对象，所以我们要使用equals去比较与输入的是否相等
//        if (cr.id.equals(courseId)) {
//          student.course.add(cr);
//          // Set中，添加某个对象，无论添加多少次，最终只会保留一个该对象（引用），并且保留的是第一个添加的那一个
//          student.course.add(cr);
//        }
//      }
//    }
//    st.testForEachForSet(student);
  }

  public void testForEachForSet(Student student) {
    // 打印输出，学生所选的课程！
    for (Course cr : student.course) {
      System.out.println("选择了课程：" + cr.id + ":" + cr.name);
    }
  }

  /**
   * 用于往coursesToSelect中添加备选课程
   */
  public void testAdd() {
    // 创建一个课程对象，并通过调用add方法，添加到备选课程List中
    Course cr1 = new Course("1", "数据结构");
    coursesToSelect.add(cr1);
    // 注意：对象存入集合都编程Object类型，取出时需要类型转换
    Course temp = (Course) coursesToSelect.get(0);
    // System.out.println("添加了课程："+temp.id+":"+temp.name);

    Course cr2 = new Course("2", "C语言");
    coursesToSelect.add(0, cr2);
    Course temp2 = (Course) coursesToSelect.get(0);
    // System.out.println("添加了课程："+temp2.id+":"+temp2.name);


    // 重复添加课程
//    coursesToSelect.add(cr1);
//    Course temp0 = (Course) coursesToSelect.get(2);
//    System.out.println("添加了重复课程："+temp0.id+":"+temp0.name);

    //如果coursesToSelect备选课程size为2，你往index4（index>size),就会抛数组下标越界异常
//    Course cr3 = new Course("3","test");
//    coursesToSelect.add(4,cr3);

    Course[] courses = {new Course("3", "离散数学"), new Course("4", "汇编语言")};
    coursesToSelect.addAll(Arrays.asList(courses));
    Course temp3 = (Course) coursesToSelect.get(2);
    Course temp4 = (Course) coursesToSelect.get(3);
    // System.out.println("添加了2门课程："+temp3.id+":"+temp3.name+"；"+temp4.id+":"+temp4.name);

    Course[] courses2 = {new Course("5", "高等数学"), new Course("6", "大学英语")};
    coursesToSelect.addAll(2, Arrays.asList(courses2));
    Course temp5 = (Course) coursesToSelect.get(2);
    Course temp6 = (Course) coursesToSelect.get(3);
    // System.out.println("添加了2门课程："+temp5.id+":"+temp5.name+"；"+temp6.id+":"+temp6.name);

  }

  /**
   * 通过for each访问集合元素
   */
  public void testForEach() {
    System.out.println("有如下课程待选(通过for each访问)：");
    for (Object o : coursesToSelect) {
      Course cr = (Course) o;
      System.out.println("课程：" + cr.id + ":" + cr.name);
    }
  }

  /**
   * 测试List的contains方法
   */
  public void testListContains() {
    //取得备选课程序列的第0个元素
    Course course = coursesToSelect.get(0);
    //打印输出coursesToSelect是否包含course对象
    System.out.println("取得课程ID：" + course.id + "，" + "课程名称：" + course.name);
    System.out.println("备选课程中是否包含课程：" + course.name + "," + coursesToSelect.contains(course));

//    Course course2 = new Course(course.id,course.name);
//    System.out.println("新创建课程ID："+course2.id+"，"+"课程名称："+course2.name);
//    System.out.println("备选课程中是否包含课程："+course2.name+","+coursesToSelect.contains(course2));

    System.out.println("请输入课程名称：");
    String name = console.next();
    //创建一个新的课程对象，ID和名称与course对象完全一样
    Course course2 = new Course();
    course2.name = name;
    System.out.println("新创建课程名称：" + course2.name);
    System.out.println("备选课程中是否包含课程：" + course2.name + "," + coursesToSelect.contains(course2));

    if (coursesToSelect.contains(course2)) {
      System.out.println("课程：" + course2.name + "的索引位置为：" + coursesToSelect.indexOf(course2));
    }
  }

  /**
   * 创建学生对象并选课
   */
  public void createStudentAndSelectCourse() {
    // 创建一个学生对象
    student = new Student("1", "小明");
    System.out.println("欢迎学生：" + student.name + "选课！");

    // 创建一个Scanner对象，用来接收从键盘输入的课程ID
    Scanner console = new Scanner(System.in);

    for (int i = 0; i < 3; i++) {
      System.out.println("请输入课程ID");
      String courseId = console.next();
      for (Course cr : coursesToSelect) {
        // cr.id是一个字符串对象，所以我们要使用equals去比较与输入的是否相等
        if (cr.id.equals(courseId)) {
          // student.course.add(cr);
          // Set中，添加某个对象，无论添加多少次，最终只会保留一个该对象（引用），并且保留的是第一个添加的那一个
          student.course.add(cr);
        }
      }
    }
  }

  /**
   * 测试Set的contains方法
   */
  public void testSetContains() {
    System.out.println("请输入课程名称：");
    String name = console.next();
    //创建一个新的课程对象，ID和名称与course对象完全一样
    Course course2 = new Course();
    course2.name = name;
    System.out.println("新创建课程名称：" + course2.name);
    System.out.println("备选课程中是否包含课程：" + course2.name + "," + student.course.contains(course2));
  }
}
