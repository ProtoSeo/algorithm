# Write your MySQL query statement below
select n.id
from weather w left join weather n
on date_add(w.recordDate, interval 1 day) = n.recordDate
where w.temperature < n.temperature;
