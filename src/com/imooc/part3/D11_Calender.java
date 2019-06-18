package com.imooc.part3;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class D11_Calender {
  public static void main(String[] args) {
    // 调用getInstance静态方法获取一个Calendar对象
    Calendar c = Calendar.getInstance();

    System.out.println(c);
    // 通过c.get()方法获取日期时间信息，参数为需要获取的字段的值
    // Calendar.Year等为Calendar类中定义的静态常量
    int year = c.get(Calendar.YEAR);
    // 月份从0开始
    int month = c.get(Calendar.MONTH) + 1;
    int day = c.get(Calendar.DAY_OF_MONTH);
    int hour = c.get(Calendar.HOUR_OF_DAY);
    int minute = c.get(Calendar.MINUTE);
    int second = c.get(Calendar.SECOND);

    System.out.println("当前时间："+year+'-'+month+'-'+day+' '+hour+':'+minute+':'+second);

    // 通过getTime()来获取Date对象，完成Calendar和Date的转换，还可以通过getTimeMillis()方法获取时间毫秒值
    Date date = c.getTime();
    Long time = c.getTimeInMillis();
    System.out.println("当前时间："+date);
    System.out.println("当前毫秒值："+time);

    System.out.println();

    Calendar c1 = Calendar.getInstance();
    Date date1 = c1.getTime();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String now = sdf.format(date1);
    System.out.println("当前的时间："+now);
  }
}
