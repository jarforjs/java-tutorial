package com.imooc.cartesianProduct;

import java.util.Arrays;

public class cartesianProduct {

  public static void main(String[] args) {

    //使用二维数组，模拟student表
    String[][] student = {
        {"0", "jsonp"},
        {"1", "alice"}
    };

    //使用二维数组，模拟student_subject表
    String[][] student_subject2 = {
        {"0", "0", "语文"},
        {"1", "0", "数学"}
    };

    //模拟 SELECT * from student JOIN student_subject;
    String[][] resultTowArray1 = getTwoDimensionArray(student, student_subject2);
    //模拟 SELECT * from student_subject JOIN student;
    String[][] resultTowArray2 = getTwoDimensionArray(student_subject2, student);

    int length1 = resultTowArray1.length;
    for (int i = 0; i < length1; i++) {
      System.out.println(Arrays.toString(resultTowArray1[i]));
    }
    System.err.println("-----------------------------------------------");
    int length2 = resultTowArray2.length;
    for (int i = 0; i < length2; i++) {
      System.out.println(Arrays.toString(resultTowArray2[i]));
    }
  }

  /**
   * 模拟两张表连接的操作
   *
   * @param towArray1
   * @param towArray2
   * @return
   */
  public static String[][] getTwoDimensionArray(String[][] towArray1, String[][] towArray2) {

    //获取二维数组的高(既该二维数组中有几个一维数组,用来指代数据库表中的记录数)
    int high1 = towArray1.length;
    int high2 = towArray2.length;

    //获取二维数组的宽度(既二位数组中，一维数组的长度,用来指代数据库表中的列)
    int wide1 = towArray1[0].length;
    int wide2 = towArray2[0].length;

    //计算出两个二维数组进行笛卡尔乘积运算后获得的结果集数组的高度和宽度,既笛卡尔积表的行数和列数
    int resultHeight = high1 * high2;
    int resultWidth = wide1 + wide2;

    //初始化结果集数组,既笛卡尔积表
    String[][] resultArray = new String[resultHeight][resultWidth];

    //迭代变量
    int index = 0;

    //先对第二二维数组遍历
    for (int i = 0; i < high2; i++) {

      //拿出towArray2这个二维数组的元素
      String[] tempArray = towArray2[i];

      //循环嵌套，对第towArray1这个二维数组遍历
      for (int j = 0; j < high1; j++) {

        //初始化一个长度为'resultWidth'的数组,作为结果集数组的元素,既笛卡尔积表中的一行
        String[] tempExtend = new String[resultWidth];

        //拿出towArray1这个二维数组的元素
        String[] tempArray1 = towArray1[j];

        //把tempArray1和tempArray两个数组的元素拷贝到结果集数组的元素中去。(这里用到了数组扩容）
        System.arraycopy(tempArray1, 0, tempExtend, 0, tempArray1.length);
        System.arraycopy(tempArray, 0, tempExtend, tempArray1.length, tempArray.length);

        //把tempExtend放入结果集数组中
        resultArray[index] = tempExtend;

        //迭代加一
        index++;
      }
    }

    return resultArray;
  }
}
