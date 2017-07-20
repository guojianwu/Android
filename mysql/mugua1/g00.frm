TYPE=VIEW
query=select `mugua`.`em`.`id` AS `id`,`mugua`.`em`.`name` AS `name`,`mugua`.`dep`.`dename` AS `dename`,`mugua`.`em`.`score` AS `score` from (`mugua`.`em` left join `mugua`.`dep` on((`mugua`.`em`.`de` = `mugua`.`dep`.`de`)))
md5=15bd297565522a09ead79fbcad93ef3d
updatable=0
algorithm=1
definer_user=root
definer_host=localhost
suid=2
with_check_option=0
timestamp=2015-11-19 06:30:03
create-version=1
source=select id,name,dep.dename,score from em left join dep on em.de =dep.de
client_cs_name=gb2312
connection_cl_name=gb2312_chinese_ci
view_body_utf8=select `mugua`.`em`.`id` AS `id`,`mugua`.`em`.`name` AS `name`,`mugua`.`dep`.`dename` AS `dename`,`mugua`.`em`.`score` AS `score` from (`mugua`.`em` left join `mugua`.`dep` on((`mugua`.`em`.`de` = `mugua`.`dep`.`de`)))
