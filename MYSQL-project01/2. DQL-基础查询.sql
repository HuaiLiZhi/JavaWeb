--  =================== DQL: 基本查询 ======================
-- 1. 查询指定字段 name,entry_date 并返回
select name, entry_date
from emp;

-- 2. 查询返回所有字段
select *
from emp;

-- 3. 查询所有员工的 name,entry_date, 并起别名(姓名、入职日期)
select name '姓名', entry_date '入职日期'
from emp;


-- 4. 查询已有的员工关联了哪几种职位(不要重复)
select distinct job
from emp;


