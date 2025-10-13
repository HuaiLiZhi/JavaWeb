insert into emp(username, password, name, gender, phone) values ('songjiang', '12345678', '宋江', 1, '13300001111');

insert into emp(id, username, password, name, gender, phone, job, salary, entry_date, image, create_time, update_time)
values (null, 'linchong', '12345678', '林冲', 1, '13300001112', 1, 6000, '2020-01-01', '1.jpg', now(), now());

insert into emp(username, password, name, gender, phone)
values ('ruanxiaoer', '12345678', '阮小二', 1, '13300001114'),
       ('ruanxiaowu', '12345678', '阮小五', 1, '13300001115');


update emp set username = 'zhangsan', name = '张三'
where id = 1;

update emp set entry_date = '2010-01-01';


delete from emp;