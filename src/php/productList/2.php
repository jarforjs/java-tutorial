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
  <h2>PHP可以为HTML添加循环能力、选择能力</h2>
  <?php
	for($i=0; $i<3; $i++){
		echo '<hr width="50%" color="red"/>';
	}
  ?>


  <?php
	//PHP可以为HTML添加循环能力、选择能力
	for($i=0; $i<3; $i++){
  ?>
	<hr width="50%" color="green"/>
  <?php
  }	  
  ?>

  <table border="1" width="500">
    <?php
	  for($i=0;$i<3;$i++){
	?>
		<tr>
			<td><?php echo $i?></td>
			<td>222</td>
		</tr>
	<?php
	  }
	?>
  </table>
  <hr/>
  <?php
	$data = [
		['ename'=>'tom', 'salary'=>3500],
		['ename'=>'mary', 'salary'=>4500],
		['ename'=>'john', 'salary'=>500]
	];
	$data[] = ['ename'=>'lily', 'salary'=>6000];
  ?>
  <table border="1" width="500">
	<tr>
		<th>姓名</th>
		<th>工资</th>
	</tr>
	<?php
	  for($i=0; $i<count($data); $i++){
	    $row = $data[$i];
	?>
		<tr>
			<td><?php echo $row['ename']?></td>
			<td><?php echo $row['salary']?></td>
		</tr>
	<?php
      }
	?>
  </table>
 </body>
</html>
