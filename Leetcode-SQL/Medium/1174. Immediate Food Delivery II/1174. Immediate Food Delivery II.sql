# Write your MySQL query statement below
select round(sum(if(order_date = customer_pref_delivery_date, 1, 0)) / count(customer_id), 4) * 100 immediate_percentage
from delivery
where (customer_id, order_date) in (
    select customer_id, min(order_date) order_date
    from delivery
    group by customer_id
);
