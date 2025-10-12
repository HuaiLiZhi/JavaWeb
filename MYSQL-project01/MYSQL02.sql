create table emp (
    id int unsigned primary key auto_increment comment 'ID',
    username varchar(20) not null unique comment '用户名',
    password varchar(32) default '123456' comment '密码',
    name varchar(10) not null comment '姓名',
    gender tinyint unsigned not null comment '性别， 1 男；2 女',
    phone char(11) not null unique comment '手机号',
    job tinyint unsigned comment '职位,1~9分别表示：1.员工；2.经理；3.总监；4.7950；5.CIO；6.CMO；7.CTO；8.COO；9.CFO',
    salary int unsigned comment '薪资',
    entry_date date comment '入职日期',
    image varchar(255) comment '头像',
    create_time datetime comment '创建时间',
    update_time datetime comment '修改时间'
) comment '员工表';