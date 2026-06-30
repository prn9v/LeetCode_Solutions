CREATE FUNCTION getNthHighestSalary(N IN NUMBER) RETURN NUMBER IS
    result NUMBER;
BEGIN
    SELECT MAX(Salary)
    INTO result
    FROM (
        SELECT Salary,
               DENSE_RANK() OVER (ORDER BY Salary DESC) ranking
        FROM Employee
    )
    WHERE ranking = N;

    RETURN result;
END;