# Write your MySQL query statement below
select max(m.num) num
from (
    select num
    from mynumbers
    group by num
    having count(num) = 1
) m;
