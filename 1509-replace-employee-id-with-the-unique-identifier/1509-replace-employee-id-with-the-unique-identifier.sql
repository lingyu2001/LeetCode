# Write your MySQL query statement below
SELECT b.unique_id, name
FROM Employees AS a
LEFT JOIN EmployeeUNI AS b on a.id = b.id;
