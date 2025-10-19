-- 需求:
-- 1. 查询 "教研部" 性别为 男，且在 "2011-05-01" 之后入职的员工信息 。
select *
from emp
where dept_id = (select id from dept where dept.name = '教研部') and
      gender = 1 and
      entry_date > '2011-05-01';

-- 2. 查询工资 低于公司平均工资的 且 性别为男 的员工信息 。
select *
from emp
where salary < (select avg(salary) from emp) and
      gender = 1;

-- 3. 查询部门人数超过 10 人的部门名称 。
# select name, a.dept_count
# from (
#     select dept_id, count(*) dept_count
#     from emp
#     group by dept_id
#      ) a, dept
# where a.dept_count > 10 and
#       a.dept_id = dept.id;
select d.name, count(*)
from emp e, dept d
where e.dept_id = d.id
group by d.name
having count(*) > 10;

-- 4. 查询在 "2010-05-01" 后入职，且薪资高于 10000 的 "教研部" 员工信息，并根据薪资倒序排序。
select *
from emp
where entry_date > '2010-05-01' and
      salary > 10000 and
      dept_id = (select dept.id from dept where dept.name = '教研部')
order by salary desc ;

-- 5. 查询工资 低于本部门平均工资的员工信息 。
select *
from emp e, (
    select dept_id, avg(salary) avg_salary
    from emp
    group by dept_id
    ) a
where salary < a.avg_salary and
      a.dept_id = e.dept_id;

