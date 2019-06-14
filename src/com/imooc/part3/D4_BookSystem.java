package com.imooc.part3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class D4_BookSystem {
  private static String[] books = new String[]{"java从入门到放弃", "react从入门到放弃"};

  public static void main(String[] args) {

    System.out.println("序号\t书名");
    for (int i = 0, len = books.length; i < len; i++) {
      System.out.println(i + 1 + ".\t" + books[i]);
    }
    D4_BookSystem bs = new D4_BookSystem();
    for (; ; ) {
      try {
        bs.test();
      } catch (InputMismatchException e) {
        System.out.println("命令输入错误！请根据提示输入数字命令！");
      } catch (ArrayIndexOutOfBoundsException e) {
        System.out.println("图书不存在！");
      } catch (D4_NotFoundBookException e) {
        System.out.println(e.getMessage());
      }
    }
  }

  private void test() throws D4_NotFoundBookException {
    System.out.println("输入命令：1.按照序号查找图书；2.按照名称查找图书");
    Scanner input = new Scanner(System.in);
    int inputValue = input.nextInt();
    if (inputValue == 1) {
      System.out.println("输入图书序号：");
      int bookIndex = input.nextInt();
      System.out.println("book：" + findBookById(bookIndex));
    } else if (inputValue == 2) {
      System.out.println("输入图书名称：");
      String bookName = input.next();
      System.out.println("book：" + findBookByName(bookName));
    } else {
      throw new D4_NotFoundBookException("命令输入错误！请根据提示输入数字命令！自定义错误！");
    }
  }

  private String findBookByName(String name) throws D4_NotFoundBookException {
    for (String book : books) {
      if (name.equals(book)) {
        return book;
      }
    }
    throw new D4_NotFoundBookException("图书不存在！自定义错误！");
  }

  private String findBookById(int bookIndex) {
    return books[bookIndex - 1];
  }
}
