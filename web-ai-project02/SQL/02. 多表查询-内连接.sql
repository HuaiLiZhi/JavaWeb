-- ============================= 内连接 ==========================
-- A. 查询所有员工的ID, 姓名 , 及所属的部门名称 (隐式、显式内连接实现)
select emp.id, emp.name, dept.name from emp, dept where emp.dept_id = dept.id;

select emp.id, emp.name, dept.name from emp inner join dept on emp.dept_id = dept.id;


-- B. 查询 性别为男, 且工资 高于8000 的员工的ID, 姓名, 及所属的部门名称 (隐式、显式内连接实现)
select emp.id, emp.name, dept.name from emp, dept where emp.dept_id = dept.id and salary > 8000 and emp.gender = 1;

select emp.id, emp.name, dept.name from emp inner join dept on emp.dept_id = dept.id and salary > 8000 and emp.gender = 1;

select e.id, e.name, d.name from emp e inner join dept d on e.dept_id = d.id and salary > 8000 and e.gender = 1;
