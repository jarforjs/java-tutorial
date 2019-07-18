<?php
$eno = $_REQUEST['eno'];

$sql = 'SELECT ename,gender,birthday,salary,isMarried,deptNo FROM emp WHERE eno='.$eno;
$conn = mysqli_connect('localhost','root', '', 'tarena');
mysqli_query($conn, 'SET NAMES utf8');
$result = mysqli_query($conn, $sql);
$row=mysqli_fetch_array($result);	//根据主键查询，结果集中最多只有一行记录
//var_dump($row);

//查询所有的部门的编号和名称，用于下拉框的选择
$sql = 'SELECT dno,dname FROM dept';
$result2 = mysqli_query($conn, $sql);
$deptArr = [];
while($dept=mysqli_fetch_array($result2)){
	$deptArr[] = $dept;
}
//var_dump($deptArr);
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
  <h2>修改员工信息</h2>
  <?php
  if(!$row){
	echo '待修改的员工编号不存在!';
  }else{
  ?>
	<form action="1-updemp.do.php" method="post">
	<input type="hidden" name="eno" value="<?php echo $eno?>"/>

	员工姓名：<input name="ename" value="<?php echo $row['ename']?>"/><br/>
	员工性别：<input type="radio" name="gender" value="男" <?php echo $row['gender']=='男'?'checked="true"':''?>/>男
	<input type="radio" name="gender" value="女" <?php echo $row['gender']=='女'?'checked="true"':''?>/>女<br/>
	员工工资：<input name="salary" value="<?php echo $row['salary']?>"/><br/>
	员工生日：<input name="birthday" value="<?php echo $row['birthday']?>"/><br/>
	是否已婚：<select name="isMarried">
				<option value="1" <?php echo $row['isMarried']?'selected="true"':''?>>已婚</option>
				<option value="0" <?php echo $row['isMarried']==0?'selected="true"':''?>>未婚</option>
			  </select><br/>
	<!--TODO: 此处的部门列表应该改为动态数据，从数据库中读取部门表中的记录-->
	所在部门：<select name="deptNo">
				<?php
				for($i=0; $i<count($deptArr); $i++){
					$dept = $deptArr[$i];
				?>
				  <option value="<?php echo $dept['dno']?>" <?php echo $dept['dno']==$row['deptNo']?'selected="true"':''?>><?php echo $dept['dname']?></option>
				<?php
				}	
				?>
			  </select><br/>
		<input type="submit" value="保存修改"/>
	</form>
  <?php
  }	  
  ?>
 </body>
</html>
