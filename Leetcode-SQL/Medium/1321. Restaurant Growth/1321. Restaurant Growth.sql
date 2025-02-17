# Write your MySQL query statement below
with cte as(
    select visited_on, sum(amount) amount
    from customer
    group by visited_on
)
select visited_on, amount, round(average_amount, 2) average_amount
from (
         select visited_on
              , sum(amount) over(order by visited_on rows between 6 preceding and current row) amount
        , avg(sum(amount)) over(order by visited_on rows between 6 preceding and current row) average_amount
        , count(*) over(order by visited_on rows between 6 preceding and current row) cnt
         from cte
         group by visited_on
     ) l
where cnt = 7
order by visited_on;
