package com.imooc.part2.D13_Dada;

import java.util.Scanner;

public class Initial {
  public static void main(String[] args) {
    RentSystem[] automobiles = {
        new Car("奥迪A4", 500, 4),
        new Car("马自达6", 400, 4),
        new Bus("金龙", 800, 20),
        new Lorry("松花江", 400, 4),
        new Lorry("依维柯", 1000, 20),
        new Jeep("汉兰达", 450, 4, 2)
    };

    System.out.println("欢迎使用答答租车系统:");
    System.out.println("您是否要租车: 1是 0否");
    Scanner input = new Scanner(System.in);

    switch (input.nextInt()){
      case 1:
        renderAutomobileList(automobiles);
        break;
      case 0:
        break;
        default:
    }
  }

  private static void renderAutomobileList(RentSystem[] automobiles){
    System.out.printf("%n您可租车的类型及其价目表:%n");
    System.out.println("序号\t汽车名称\t租金\t\t容量");
    for (int i=1,len=automobiles.length;i<=len;i++){
      System.out.println(i+". "+automobiles[i]);
      System.out.printf("%d. \t%s\t\t%d元/天\t%s%n", i);
    }

    System.out.println("请输入你要租汽车的数量");

    Scanner needCount = new Scanner(System.in);
    for(int j=1;j<=needCount.nextInt();j++){
      System.out.println("请输入第"+j+"辆车的序号:");

    }
  }
}
