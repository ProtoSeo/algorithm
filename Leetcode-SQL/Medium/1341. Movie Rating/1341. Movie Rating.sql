# Write your MySQL query statement below
(select u.name results
from movierating r join users u on r.user_id = u.user_id
group by r.user_id
order by count(r.user_id) desc, u.name limit 1)
union all
(select m.title results
from movierating r join movies m on r.movie_id = m.movie_id
where r.created_at between '2020-02-01' and '2020-02-28'
group by r.movie_id
order by avg(r.rating) desc, m.title limit 1);
