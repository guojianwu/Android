TYPE=VIEW
query=select `mugua`.`em`.`id` AS `id`,`mugua`.`em`.`name` AS `name`,`mugua`.`dep`.`dename` AS `dename` from (`mugua`.`em` left join `mugua`.`dep` on((`mugua`.`em`.`de` = `mugua`.`dep`.`de`)))
md5=3338a43dfba76dda25262ced07e3218e
updatable=0
algorithm=1
definer_user=root
definer_host=localhost
suid=2
with_check_option=0
timestamp=2015-11-19 06:29:29
create-version=1
source=select id,name,dep.dename from em left join dep on em.de =dep.de
client_cs_name=gb2312
connection_cl_name=gb2312_chinese_ci
view_body_utf8=select `mugua`.`em`.`id` AS `id`,`mugua`.`em`.`name` AS `name`,`mugua`.`dep`.`dename` AS `dename` from (`mugua`.`em` left join `mugua`.`dep` on((`mugua`.`em`.`de` = `mugua`.`dep`.`de`)))
