/*SHOW DATABASES;
SHOW DATABASES; 多行注释*/
##SHOW DATABASES;  单行注释

/*
SQL语句本身是不区分大小写的！
习惯上，SQL关键字都大写，自定义的内容都小写。
*/

##试着删除数据库tarena
DROP DATABASE IF EXISTS tarena;

##创建一个数据库tarena,指定其中所有的数据默认的编码方式
CREATE DATABASE tarena CHARSET=UTF8 ;  /*MySQL中不能写UTF-8*/

##进入指定的数据库
USE tarena;

##创建一个部门表——指定其中包含的列
CREATE TABLE dept(
	dno INT,
	dno NUMBER(6, 2),//9999.99
	dname VARCHAR(16),//不写长度，默认是1个字符；16个字符，一个汉字一个字符
	loc VARCHAR(32),
	PRIMARY KEY(dno)		/*一个表中应该有一列为主键*/
);

##向部门表中插入记录行				//字符串只能用'引起来
INSERT INTO dept(dno,dname,loc) VALUES(10,'Research', 'BJ');
INSERT INTO dept(dno,dname,loc) VALUES(20,'Market', 'BJ');
INSERT INTO dept(dno,dname,loc) VALUES(30,'Market', 'SH');
INSERT INTO dept(dno,dname,loc) VALUES(40,'Operation', 'TJ');

##删除表中的记录行
DELETE FROM dept WHERE dno=30;	/*SQL中没有==和===*/

##修改某行记录
UPDATE dept SET dname='Development',loc='JN'  WHERE dno=10;

##查询所有的部门数据
SELECT dno,dname,loc FROM dept  /*WHERE dno=10*/;


##创建一个员工表
CREATE TABLE emp(
	eno INT AUTO_INCREMENT,		/*自增列*/
	ename VARCHAR(32),
	gender VARCHAR(1),
	salary FLOAT(8,2),
	birthday DATE,
	isMarried BOOLEAN,
	deptNo INT,
	PRIMARY KEY(eno)
);

##向员工表中插入记录行			注意SQL中DATE的赋值
INSERT INTO emp(ename,gender,salary,birthday,isMarried,deptNo)
VALUES('唐木','男',3500,'2010-10-1',TRUE, 10);
INSERT INTO emp(ename,gender,salary,birthday,isMarried,deptNo)
VALUES('玛丽','女',4000,'2011-1-15',FALSE, 10);
INSERT INTO emp(ename,gender,salary,birthday,isMarried,deptNo)
VALUES('约翰','男',5500,'2001-12-1',TRUE,20);

##查询所有的员工数据
SELECT eno,ename,gender,salary,birthday,isMarried,deptNo
FROM emp;


