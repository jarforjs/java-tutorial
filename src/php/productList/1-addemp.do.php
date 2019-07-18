<?php
//读取客户端提交的表单数据
$ename = $_REQUEST['ename'];
$gender = $_REQUEST['gender'];	//男/女
$birthday = $_REQUEST['birthday'];	//规定格式
$salary = $_REQUEST['salary']; 
$isMarried = $_REQUEST['isMarried'];  //1/0
$deptNo = $_REQUEST['deptNo']; //10/20/....

//连接数据库，执行INSERT语句
$sql = "INSERT INTO emp(ename,gender,birthday,salary,isMarried,deptNo) VALUES('$ename','$gender','$birthday','$salary','$isMarried','$deptNo')";
//echo $sql;
$conn = mysqli_connect('127.0.0.1','root','','tarena');
mysqli_query($conn, 'SET NAMES utf8');	/*告诉数据库接下来的SQL语句的编码方式*/
$result = mysqli_query($conn, $sql);

//根据执行的结果，给客户端以提示
$msg = '';
if($result){
	$msg = '添加记录成功！新员工的自增编号为：' . mysqli_insert_id($conn);
}else{
	$msg = '添加记录失败！错误编号为：' . mysqli_errno($conn);
}
?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
 <head>
  <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
  <title></title>
  <style type="text/css">
	*{margin:0; padding:0;}
  </style>
 </head>

 <body>
  <h2>新添员工操作执行结果：</h2>
  <h3><?php echo $msg; ?></h3>
  <p><a href="1-addemp.html">继续添加新员工</a></p>
  <p><a href="1.html">返回主菜单</a></p>
 </body>
</html>
