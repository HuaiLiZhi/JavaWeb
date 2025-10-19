-- =============================== 外连接 ============================
-- A. 查询员工表 所有 员工的姓名, 和对应的部门名称 (左外连接)
select e.name, d.name from emp e left join dept d on e.dept_id = d.id;

-- B. 查询部门表 所有 部门的名称, 和对应的员工名称 (右外连接)
select d.name, e.name from emp e right join dept d on e.dept_id = d.id;

-- C. 查询工资 高于8000 的 所有员工的姓名, 和对应的部门名称 (左外连接)
select e.name, d.name from emp e left join dept d on e.dept_id = d.id where e.salary > 8000;

select e.name, d.name from emp e left join dept d on e.dept_id = d.id and e.salary > 8000;
