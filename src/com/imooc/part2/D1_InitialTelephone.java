package com.imooc.part2;
import com.imooc.part2.second.D1_Telephone_Construct_Static_Variable;
public class D1_InitialTelephone {

  public static void main(String[] args) {
    // 无参的构造方法
    D1_Telephone_Construct_Static_Variable phone = new D1_Telephone_Construct_Static_Variable();
    // 有参的构造方法
    D1_Telephone_Construct_Static_Variable phone1 = new D1_Telephone_Construct_Static_Variable(2.0f,2.0f,3.0f);

    phone.sendMessage();
    phone.screen = 5.0f;
    phone.cpu = 2;
    phone.memory = 2.9f;
    phone.sendMessage();
    // 静态变量可以直接使用类名访问，无需创建类的对象
    System.out.println(D1_Telephone_Construct_Static_Variable.hobby);
    // 创建类的对象
    System.out.println(phone.hobby + "通过类对象来访问静态变量");
    // 推荐使用类名直接访问！！！
    // 修改静态变量
    D1_Telephone_Construct_Static_Variable.hobby = "www.google.com";
    System.out.println("修改后的静态变量的值为："+ D1_Telephone_Construct_Static_Variable.hobby);
  }
}
