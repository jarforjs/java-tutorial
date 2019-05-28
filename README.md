# java tutorial

#### java除法的结果是取整还是正常值与被除数有关。
```
(11 + 3 * 8) / 4 % 3) = 2;
// java除法的结果是取整还是正常值与被除数有关。
(11 + 3 * 8) / 4.0 % 3 = 2.75;
```

#### java的for in循环
`
for (int score : scores)
`

#### java创建数组
```
// 定义一个长度为5的字符串数组
String[] subjects = new String[5];

// 等价于：
String[] subjects1 = new String[]{ "Oracle", "PHP", "Linux", "Java", "HTML" };

// 等价于：
String[] subjects2 = { "Oracle", "PHP", "Linux", "Java", "HTML" };
```

#### java中定义二维数组
```
// 定义一个两行三列的二维数组并赋值
String [][] arrays = new String[2][3];
String [][] names = {{"tom","jack","mike"},{"zhangsan","lisi","wangwu"}};
```

#### 强制类型转换
`
numbers[i] = (int)(Math.random() * 100);
`

#### for循环中i--的写法
`
for (int i = scores.length - 1; i >= 0 && count < 4; i--) {}
`

## 类
- 类是模子,是用来描述对象将会拥有的特征(属性)和行为(方法).

### 类的特点:
- 类是对象(具体数据信息比如手机)的类型
- 具有相同属性和方法的一组对象的集合

### 类和对象的关系
- 类是抽象的概念,它只是我们脑海里的想象,其实客观是不存在的,仅仅是模板而已.
- 对象是一个你能够看的到,摸得着的具体实体,是客观存在的.

### 创建对象
`类名 对象名 = new 类名();`
- 引用对象的属性：对象名.属性
`phone.screen = 5;// 给screen属性赋值5`
- 引用对象的方法：对象名.方法
`phone.call()`

### 给float型变量赋值时必须加f，不然会认为时double型

### 成员变量局部变量区别
1. 作用域不同
   - 局部变量的作用域仅限于定义它的方法
   - 成员变量的作用域在整个类内部都是可见的
2. 初始值不同
   - java会给成员变量一个初始值
   - java不会给局部变量赋予初始值
3. 同一个方法不允许有同名局部变量，不同方法中可以有同名局部变量
4. 两类变量同名时，局部变量具有更高的优先级


