# Write your MySQL query statement below
SELECT Department, Employee, Salary FROM
(SELECT d.name AS Department, e.name AS Employee, e.salary AS Salary, DENSE_RANK() OVER(PARTITION BY e.departmentId ORDER BY e.salary DESC) AS rk
FROM Department d JOIN Employee e 
ON e.departmentId = d.id) AS t
WHERE rk <= 3;