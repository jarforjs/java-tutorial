package com.imooc.part3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class D10_Date_SimpleDateFormat {
  public static void main(String[] args) throws ParseException {
    Date d = new Date();
    System.out.println(d);

    // 创建SimpleDateFormat对象，指定目标格式
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd HH:mm:ss");
    // 1。调用format方法，转换为指定格式字符串
    String today = sdf.format(d);
    // 转换后的字符串
    System.out.println(today);

    // 2。调用parse方法,将字符串转换为日期
    String day = "2019年06月18日 16:40:00";
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
    Date date = sdf1.parse(day);
    System.out.println(day);

    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
    SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy/MM/dd HH:mm");
    SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    Date now = new Date();
    String d2 = "2014-6-1 21:05:36";
    System.out.println();
    System.out.println(sdf2.format(now));
    System.out.println(sdf3.format(now));
    System.out.println(sdf4.format(now));
    System.out.println(sdf5.parse(d2));
  }
}
