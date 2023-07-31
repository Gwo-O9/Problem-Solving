# Write your MySQL query statement below
Select user_id, MAX(time_stamp) as last_stamp from Logins
where time_stamp <= "2020-12-31 23:59:59" and time_stamp >= "2020-01-01 00:00:00"
Group by user_id
