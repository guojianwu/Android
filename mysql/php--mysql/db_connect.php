<?php
//引入数据库配置文件
require_once 'db_config.php';
//1、连接数据库
$link = mysql_connect($db_info['db_host'].':'.$db_info['db_port'],$db_info['db_user'],$db_info['db_pwd']);
if (! $link ) {
    die( 'Could not connect: '  .  mysql_error ());
}
echo  'Connected successfully' ;
//2、选择数据库
mysql_select_db ( $db_info['db_name']) or die ( 'Can\'t use shop: '  .  mysql_error ());
//2.2 设置数据库连接所采用的字符编码
mysql_set_charset($db_info['db_charset']);
?>