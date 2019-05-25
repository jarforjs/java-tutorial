# java tutorial

#### java除法的结果是取整还是正常值与被除数有关。
```
(11 + 3 * 8) / 4 % 3) = 2;
// java除法的结果是取整还是正常值与被除数有关。
(11 + 3 * 8) / 4.0 % 3 = 2.75;
```

#### java的for in循环
```
for (int score : scores)
```

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
```
numbers[i] = (int) (Math.random() * 100);
```

#### for循环中i--的写法
```
for (int i = scores.length - 1; i >= 0 && count < 4; i--) {}
```