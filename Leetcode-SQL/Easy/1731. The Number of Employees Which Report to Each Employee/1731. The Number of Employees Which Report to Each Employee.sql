# Write your MySQL query statement below
select r.employee_id, r.name, count(r.name) reports_count, round(sum(e.age) / count(r.name)) average_age
from employees e join employees r on e.reports_to = r.employee_id
group by r.employee_id, r.name
order by r.employee_id;
