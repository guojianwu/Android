<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>留言板主页</title>
</head>
<body>




	<div id="header">
		<a href="login.php">登录</a>
		<a href="register.php">注册</a>
	</div>





	<div id="content">



		<h2>留言板留言列表</h2>



		<table border="1px" cellspacing="0">
		<tr>
			<th>序号</th>
			<th>标题</th>
			<th>作者</th>
			<th>时间</th>
			<th>内容</th>
			<th>操作</th>
		</tr>

<?php

require_once 'db_connect.php';
$sql ="select msg.id,msg.title,user.name,time from msg,user where user.id=msg.authorid";
$results =mysql_query($sql);
while($row = mysql_fetch_assoc($results)){
	echo <<<STR
	<tr>
	    <td>{$row['id']}</td>
	    <td><a href="viewMsg.php?id={$row['id']}">{$row['title']}</a></td>
	    <td>{$row['name']}</td>
	    <td>{$row['time']}</td>
	    <td>
           <a href="deleteMsg.php">删除</a>
           <a href="updateMsg.php">修改</a>
	    </td>
	</tr>
STR;
}
mysql_close();

?>

        </table>


	</div>








	<div id ="footer">
		$copy;中山火炬职业技术学院
	</div>




</body>
</html>


