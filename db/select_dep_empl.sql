select * from departments
left join employees
on department_id = departments.id

select * from employees
right join departments
on department_id = departments.id

select * from departments
full join employees
on department_id = departments.id

select departments.name as "Департамент"
from departments
left join employees
on department_id = departments.id
where employees.name is null

select * from departments
left join employees
on department_id = departments.id

select * from departments
right join employees
on department_id = departments.id