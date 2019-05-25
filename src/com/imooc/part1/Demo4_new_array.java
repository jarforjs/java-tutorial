package com.imooc.part1;

/**
 * java中如何使用数组
 */
public class Demo4_new_array {
  public static void main(String[] args) {
    // 定义一个长度为5的字符串数组
    String[] subjects = new String[5];

    // 等价于：
    String[] subjects1 = new String[]{ "Oracle", "PHP", "Linux", "Java", "HTML" };

    // 等价于：
    String[] subjects2 = { "Oracle", "PHP", "Linux", "Java", "HTML" };

    // 分别为数组中的元素赋值
    subjects[0]="Oracle";
    subjects[1]="PHP";
    subjects[2]="Linux";
    subjects[3]="Java";
    subjects[4]="HTML";

    System.out.println("数组中第四个科目为：" + subjects[3]);
  }
}
