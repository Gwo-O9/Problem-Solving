SELECT firstName, lastName, city, state
FROM Person
LEFT JOIN address
ON person.personId = Address.personId;
