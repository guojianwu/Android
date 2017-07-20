<?php

//获取URL参数
$msgId = $_GET['id'];
//连接数据库
require_once 'db_connect.php';
$sql ="select msg.title,msg.content,msg.time,user.name from 
      msg left join user on user.id = msg.authorid where msg.id =$msgId";

$results = mysql_query($sql);

$msg = mysql_fetch_assoc($results);

mysql_free_result($results);

mysql_close();
?>


<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>显示留言</title>
</head>
<body>

	<div>留言标题：<?php echo $msg['title']; ?></div>
	<div>留言发表者：<?php echo $msg['name']; ?></div>
	<div>留言内容：<?php echo $msg['content']; ?></div>
	<div>留言时间：<?php echo $msg['time']; ?></div>
</body>
</html>