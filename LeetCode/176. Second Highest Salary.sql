Select max(Salary) as secondhighestsalary 
from employee 
where salary not in(select max(salary) from employee);
