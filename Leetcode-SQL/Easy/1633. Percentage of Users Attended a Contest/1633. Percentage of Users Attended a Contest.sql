# Write your MySQL query statement below
select r.contest_id, round(count(r.user_id) / c.cnt * 100, 2) percentage
from register r, (select count(*) cnt from users) c
group by r.contest_id
order by percentage desc, r.contest_id;
