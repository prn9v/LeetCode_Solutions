CREATE FUNCTION getNthHighestSalary(N IN NUMBER) RETURN NUMBER IS
    result NUMBER;
BEGIN
    SELECT MAX(e.Salary)
    INTO result
    FROM (
        SELECT Salary,
               DENSE_RANK() OVER (ORDER BY Salary DESC) ranking
        FROM Employee
    ) e
    WHERE ranking = N;

    RETURN result;
END;