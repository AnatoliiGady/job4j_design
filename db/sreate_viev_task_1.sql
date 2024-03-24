create view salary_employees_150000
as
select d.name as "Служба", e.name, e.salary
from employees as e
	join departments as d on d.id = e.department_id
	join positions_emp as p on p.id = e.position_id
group by (d.name, e.name, e.salary)
having e.salary >= 150000
order by e.salary desc