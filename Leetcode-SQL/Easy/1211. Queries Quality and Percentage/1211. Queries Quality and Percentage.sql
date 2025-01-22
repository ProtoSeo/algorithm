# Write your MySQL query statement below
select query_name,
       round(sum(rating / position) / count(query_name), 2) quality,
       round(sum(rating < 3) / count(query_name) * 100, 2) poor_query_percentage
from queries
group by query_name;
