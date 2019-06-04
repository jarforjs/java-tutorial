package com.imooc.part2;

public class D8_Inherit_Initial {

  public static void main(String[] args) {
    D8_Inherit_Dog dog = new D8_Inherit_Dog(9527);
    D8_Inherit_Dog dog1 = new D8_Inherit_Dog(9528);
    if(dog.equals(dog1)){
      System.out.println("两个对象相同");
    }else {
      System.out.println("两个对象不相同");
    }
    dog.age = 1;
    dog.name = "jack";
    dog.eat();
    D8_Inherit_Animal animal = new D8_Inherit_Animal(9999);
    System.out.println("父类animal中的属性age是:" + animal.age + ".手机号码是:" + animal.phoneNumber);


    // D11_Referee_Transform_Cat引用类型转换开始
    D8_Inherit_Dog dog2 = new D8_Inherit_Dog(9529);

    // 自动类型提升 向上类型转换
    D8_Inherit_Animal animal1 = dog2;

    // 我们再次将父类引用转换成子类引用
    // 这样子是存在风险的，虽然我们知道这个父类引用指向的就是Dog对象，但是编译器也认为你这种类型转换是存在风险的
    // D8_Inherit_Dog dog3 = animal1;
    // 那我们怎么来解决这个问题呢？
//    D8_Inherit_Dog dog3 = (D8_Inherit_Dog) animal1;//强制转换，向下类型转换
//
//    dog3.age=2;
//    dog3.name="tom";
//    dog3.eat();

    // 如果我把这个父类的引用转化成Cat类型的引用
    // 虽然我强制转换了animal引用为Cat对象，但是毕竟animal引用指向的是一个Dog对象，显然它没有办法转换为Cat对象，根本就是不同的对象类型
    // D11_Referee_Transform_Cat_Instanceof_D8_Inherit_Initial cat = (D11_Referee_Transform_Cat_Instanceof_D8_Inherit_Initial)animal1; // 语法没有错，编译器在执行的过程中没有检测出这个错误，但是当我真正运行这个程序的时候报错了！

    // 我们真正开辟的内存空间是什么呢？
    // 是21行，new D8_Inherit_Dog(9529);是Dog类型，程序发现两个类型不匹配不能进行强制类型哦转换
    // 我们可以用instanceof运算符避免类型转换的安全性问题
    if (animal1 instanceof D11_Referee_Transform_Cat_Instanceof_D8_Inherit_Initial){
      D11_Referee_Transform_Cat_Instanceof_D8_Inherit_Initial cat = (D11_Referee_Transform_Cat_Instanceof_D8_Inherit_Initial)animal1;
    } else {
      System.out.println("无法进行类型转换，Cat类型");
    }

    //我们把30到34行注释掉，给它也加一下
    if(animal1 instanceof D8_Inherit_Dog){
      D8_Inherit_Dog dog3 = (D8_Inherit_Dog) animal1;//强制转换，向下类型转换
      dog3.age=2;
      dog3.name="tom";
      dog3.eat();
    }else {
      System.out.println("无法进行类型转换，Dog类型");
    }
  }
}
