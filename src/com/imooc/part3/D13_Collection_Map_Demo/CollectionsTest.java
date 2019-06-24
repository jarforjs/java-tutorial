package com.imooc.part3.D13_Collection_Map_Demo;

import java.util.*;

/**
 * 1、通过Collections.sort方法，对Integer泛型的List进行排序
 * 2、对String泛型的List进行排序
 * 3、对其他类型泛型的List进行排序，以Student为例
 */
public class CollectionsTest {
  /**
   * 对Integer泛型的List进行排序
   * 创建一个Integer泛型的List，插入10个100以内的不重复的整数，再调用sort方法进行排序
   */
  public void testSort1(){
    List<Integer> integerList = new ArrayList<Integer>();
    Random random = new Random();
    Integer k;
    for(int i=0,len=10;i<len;i++){
      do {
        k=random.nextInt(100);
      }while (integerList.contains(k));
      integerList.add(k);
      System.out.println("成功添加整数："+k);
    }
    System.out.println("————————————排序前————————————");
    for (Integer integer:integerList){
      System.out.print(integer+" ");
    }
    Collections.sort(integerList);
    System.out.println();
    System.out.println("————————————排序后————————————");
    for (Integer integer:integerList){
      System.out.print(integer+" ");
    }
  }

  /**
   * 对String泛型的List进行排序
   */
  public void testSort2(){
    List<String> stringList = new ArrayList<String>();
    stringList.add("microsoft");
    stringList.add("google");
    stringList.add("lenovo");
    System.out.println("————————————排序前————————————");
    for (String string:stringList){
      System.out.print(string+" ");
    }
    Collections.sort(stringList);
    System.out.println();
    System.out.println("————————————排序后————————————");
    for (String string:stringList){
      System.out.print(string+" ");
    }
  }

  /**
   * 创建完List<String>之后，往其中添加10条随机字符串
   * 每条字符串长度为10以为的随机整数
   * 每条字符串的每个字符为随机生成的字符，字符可以重复，但每条字符串不可重复
   */
  public void testRandomString() {
    List<StringBuilder> stringList = new ArrayList<>();
    final String AllChar = "0123456789";
    Random random = new Random();
    String string;
    for (int i = 0, len = 50; i < len; i++) {
      StringBuilder stringBuilder = new StringBuilder();
      int length = random.nextInt(10) + 1;
      do {
        for (int j = 0; j < length; j++) {
          int index = random.nextInt(AllChar.length());
          stringBuilder.append(AllChar.charAt(index));
        }
      } while (stringList.contains(stringBuilder));
      stringList.add(stringBuilder);
      System.out.println("成功添加字符串：" + stringBuilder);
    }
    System.out.println(stringList.size() + "条长度10以内不重复的字符串");
    for (StringBuilder sl : stringList) {
      System.out.println(sl + " ");
    }
  }

  public static void main(String[] args) {
    CollectionsTest ct = new CollectionsTest();
//    ct.testSort1();
//    System.out.println();
//    ct.testSort2();
//    System.out.println();
    ct.testRandomString();
  }
}
