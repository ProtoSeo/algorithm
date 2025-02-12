# Write your MySQL query statement below
select department, employee, salary
from (
         select d.name department, e.name employee, e.salary salary,
                dense_rank() over(partition by e.departmentId order by e.salary desc) rnk
         from department d join employee e on d.id = e.departmentId
     ) t
where t.rnk <= 3;
