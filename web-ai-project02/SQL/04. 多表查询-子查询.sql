-- ========================= 子查询 ================================
-- 标量子查询
-- A. 查询 最早入职 的员工信息


select *
from emp
where entry_date = (
    select min(entry_date)
    from emp
    );

-- B. 查询在 "阮小五" 入职之后入职的员工信息
select *
from emp
where entry_date > (
    select entry_date
    from emp
    where name = '阮小五'
    );

-- 列子查询
-- A. 查询 "教研部" 和 "咨询部" 的所有员工信息
select *
from emp
where dept_id in (
    select dept.id
    from dept
    where dept.name in ('教研部', '咨询部')
    );


-- 行子查询
-- A. 查询与 "李忠" 的薪资 及 职位都相同的员工信息 ;
select *
from emp
where (salary, job) = (
    select salary, job
    from emp
    where name = '李忠'
    ) and name != '李忠';


-- 表子查询
-- A. 获取每个部门中薪资最高的员工信息

select *
from emp
where (dept_id, salary) in (
    select dept_id, max(salary)
    from emp
    group by dept_id
    )




