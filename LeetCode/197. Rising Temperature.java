select a1.id as id
from weather as a1 join weather as a2
on DATEDIFF(a1.recorddate, a2.recorddate) = 1 and a1.temperature > a2.temperature
