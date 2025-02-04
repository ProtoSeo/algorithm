-- First
# Write your MySQL query statement below
select distinct a.num consecutivenums
from logs a join logs b on a.id + 1 = b.id and a.num = b.num
            join logs c on b.id + 1 = c.id and b.num = c.num;
-- Second
# Write your MySQL query statement below
with cte as (
    select num,
    lead(num,1) over() num1,
    lead(num,2) over() num2
    from logs
)
select distinct num consecutivenums from cte where num = num1 and num1 = num2;
