# Write your MySQL query statement below
SELECT name AS customers
FROM customers 
WHERE Id NOT IN (
    SELECT customerId FROM orders
);