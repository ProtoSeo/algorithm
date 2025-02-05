# Write your MySQL query statement below
select o.person_name
from (
         select person_id, person_name, sum(weight) over (order by turn) as total_weight
         from queue
     ) o
where o.total_weight <= 1000
order by o.total_weight desc
    limit 1;
