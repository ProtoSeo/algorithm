# Write your MySQL query statement below
select round(sum(tiv_2016), 2) tiv_2016
from (
         select tiv_2016,
                count(*) over(partition by tiv_2015) tiv_2015_count,
                 count(*) over(partition by lat, lon) city_count
         from insurance
     ) t
where tiv_2015_count > 1 and city_count = 1;
