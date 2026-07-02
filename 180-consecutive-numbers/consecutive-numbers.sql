SELECT DISTINCT a.num AS ConsecutiveNums
FROM Logs a
JOIN Logs b
    ON a.num = b.num
   AND a.id + 1 = b.id
JOIN Logs c
    ON b.num = c.num
   AND b.id + 1 = c.id;