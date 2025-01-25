# Write your MySQL query statement below
select round(count(a.player_id) / (select count(distinct player_id) from activity), 2) fraction
from activity a
where (a.player_id, date_sub(event_date, interval 1 day))
in (select f.player_id, min(f.event_date) from activity f group by player_id);
