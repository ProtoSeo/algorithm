# Write your MySQL query statement below
delete from person
where id not in (
    select min from (
                        select min(id) min
                        from person
                        group by email
                    ) as t
);
