# Write your MySQL query statement below
SELECT e_1.Name as Employee 
FROM Employee as e_1 
INNER JOIN Employee as e_2 
ON e_1.ManagerId = e_2.Id AND e_1.Salary > e_2.Salary