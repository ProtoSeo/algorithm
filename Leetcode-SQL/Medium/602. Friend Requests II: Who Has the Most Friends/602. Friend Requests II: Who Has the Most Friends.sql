# Write your MySQL query statement below
with cte as (
select r.id, count(r.id) num
from (
    (select requester_id id
    from requestaccepted)
    union all
    (select accepter_id id
    from requestaccepted)
) r group by r.id)

select id, num
from cte
order by num desc limit 1;
