# Write your MySQL query statement below
SELECT Visits.customer_id, count(Visits.customer_id) AS count_no_trans
FROM Visits
WHERE Visits.visit_id not IN (SELECT Transactions.visit_id FROM Transactions)
GROUP BY Visits.customer_id
