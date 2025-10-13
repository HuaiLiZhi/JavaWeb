--  =================== DQL: 分组查询 ======================
-- 聚合函数

-- 1. 统计该企业员工数量
select count(*)
from emp;

-- 2. 统计该企业员工的平均薪资
select avg(salary)
from emp;

-- 3. 统计该企业员工的最低薪资
select min(salary)
from emp;

-- 4. 统计该企业员工的最高薪资
select max(salary)
from emp;

-- 5. 统计该企业每月要给员工发放的薪资总额(薪资之和)
select sum(salary)
from emp;




-- 分组
-- 1. 根据性别分组 , 统计男性和女性员工的数量
select gender, count(*)
from emp
group by gender;

-- 2. 先查询入职时间在 '2015-01-01' (包含) 以前的员工 , 并对结果根据职位分组 , 获取员工数量大于等于2的职位
select job, count(*)
from emp
where entry_date <= '2015-01-01'
group by job
having count(*) >= 2;