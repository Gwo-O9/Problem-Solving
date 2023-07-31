# Write your MySQL query statement below
SELECT name, sum(amount) AS balance FROM Users, Transactions
WHERE users.account = Transactions.account
GROUP BY name
HAVING balance > 10000
