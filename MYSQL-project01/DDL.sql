show tables ;

desc emp;

show create table emp;

alter table emp add qq varchar(13) comment 'QQ号码';

alter table emp modify qq varchar(15) comment 'QQ号码';

alter table emp change qq qq_num varchar(15) comment 'QQ号码';

alter table emp drop column qq_num;

alter table emp rename to employee;

drop table employee;