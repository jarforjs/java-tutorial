package com.imooc.part2.D14_Dada;

import java.util.Scanner;

public class Initial {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int exitFlag = 1;
    do {
      System.out.printf("欢迎使用答答租车系统：%n您是否要租车：1是 0否%n");
      int choose = input.nextInt();

      switch (choose) {
        case 1:
          renderAutomobiles(input);
          exitFlag = 0;
          break;
        case 0:
          System.out.println("欢迎下次光临！");
          exitFlag = 0;
          break;
        default:
          System.out.println("输入有误，请重新输入！");
      }
    } while (exitFlag == 1);
  }

  private static void renderAutomobiles(Scanner input) {
    Automobile[] automobiles = {
        new PassageCar("奥迪A4", 500, 4),
        new PassageCar("马自达", 400, 4),
        new PassageCar("金龙", 800, 20),
        new Lorry("松花江", 400, 4),
        new Lorry("依维柯", 1000, 20),
        new Pickup("汉兰达", 450, 4, 2)
    };
    System.out.printf("%n您可租车的类型及价目表：%n");
    System.out.println("序号\t汽车名称\t租金\t\t\t\t容量");
    for (int i = 0; i < automobiles.length; i++) {
      Automobile automobile = automobiles[i];
      System.out.printf("%d. \t%s\t\t%d元/天\t\t%s%n", i + 1, automobile.getName(), automobile.getRent(), automobile.getCapacity());
    }

    // 租车数量
    System.out.println("请输入您的租车的数量：");
    int count = input.nextInt();
    int[] choices = new int[automobiles.length];

    for (int i = 0; i < count; i++) {
      System.out.println("请输入第" + (i + 1) + "辆车的序号：");
      int index = input.nextInt() - 1;
      choices[index]++;
    }

    // 租车天数
    System.out.println("请输入租车天数：");
    int days = input.nextInt();

    // 账单
    System.out.println("您的账单：");
    System.out.println("***可载人的车有：");
    int seatCountTotal = 0;
    for (int i = 0; i < choices.length; i++) {
      int choice = choices[i];
      Automobile automobile = automobiles[i];
      if (choice != 0 && automobile instanceof ITranPeople) {
        System.out.printf("%s*%d ", automobile.getName(), choice);
        seatCountTotal += ((ITranPeople) automobile).getSeatCount() * choice;
      }
    }
    System.out.printf("共载人：%d人%n", seatCountTotal);

    System.out.println("***可载货的车有：");
    int goodsWeightTotal = 0;
    for (int i = 0; i < choices.length; i++) {
      int choice = choices[i];
      Automobile automobile = automobiles[i];
      if (choice != 0 && automobile instanceof ITranGoods) {
        System.out.printf("%s*%d ", automobile.getName(), choice);
        /*
        因为automobile(automobiles[i])是父类Automobile的实例对象，所以该父类对象不能调用子类的方法
        （如果想让父类调用子类对象，可以创建一个父类的引用指向子类对象，则父类的引用对象可以调用子类的方法）

        因此把automobile强制转换为接口的实例，利用接口的实例访问所要调用子类的方法

        automobile instanceof ITranGood
        ((ITranHuman) automobile).getSeatCount()
        这两个语句个人感觉有点像面向接口编程（Interface-Oriented Programming）

        另外说明一下：父类的引用对象其实就是指向子类对象，也就可以调用子类的方法了
        由此说明：对象调用方法时，首先应该判断该对象所在的类与该方法的关系.

        接口不能被实例化。（接口 引用对象 = new 类L()（该类已经实现此接口）），
        引用对象要想调用类L的方法只能是接口中的抽象方法，若想访问类L的其他方法，
        则引用对象需要强制类型转换成L类，才能调用。

        多态：父类 引用对象a = new 子类L( );
        编译的时候引用对象a加载的是父类的方法、父类的成员变量，
        运行的时候引用对象a调用的是子类的【同名】方法
        （子类继承父类的方法，重写父类的方法时，a调用的是子类的重写方法【同名】）、父类的成员变量，这种现象叫多态（方法的多态），
        还有多态最重要的一点是，子类其他方法【不同名父类的子类其他方法】，引用对象a不能调用（因为编译的时候没有加载这个方法）

        (ITranHuman) CARS[i]就是向下转型，把父类Car的实例CATS[i]转为接口的实现类的实例，
        从而调用子类（接口实现类）特有的getSeatCount()方法。

        总结：父类的多个子类特有的属性有有的同时有多个时，可以设计接口，让那个有多个属性的子类实现多个接口即可，
        这样统计所有子类某个属性时，只需把父类的引用实例a强转为接口实现类即可
        */
        goodsWeightTotal += ((ITranGoods) automobile).getGoodsWeight() * choice;
      }
    }
    System.out.printf("共载货：%d吨%n", goodsWeightTotal);

    int rentTotal = 0;
    for (int i = 0; i < count; i++) {
      if (choices[i] != 0) {
        rentTotal += automobiles[i].getRent() * choices[i];
      }
    }
    System.out.printf("***租车总价格：%d元%n", rentTotal * days);
  }

}
