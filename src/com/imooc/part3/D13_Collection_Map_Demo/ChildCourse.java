package com.imooc.part3.D13_Collection_Map_Demo;

//继承的时候报错，因为之前给Course类型定义了一个含参构造器，所以编译器不会为他自动添加一个隐式的无参构造器
//而子类ChildCourse又必须调用父类隐式的无参构造器，我们可以给子类也写一个有参构造器，或者在父类写一个无参构造器
public class ChildCourse extends Course {

}
