<?php
//接收请求中提交的eno
$eno = $_REQUEST['eno'];

//根据eno作数据库的删除操作
$sql = "DELETE FROM emp WHERE eno=".$eno;
echo $sql;

//把操作的结果显示给客户端
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
  <h2>删除员工操作的结果：</h2>
 </body>
</html>
