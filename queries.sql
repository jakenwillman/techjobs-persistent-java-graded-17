--Part 1
-- List the columns from the job table and their data types using SQL comments
---------------------------------------------------------------------------

--id(INT, pk)
--employer(VARCHAR)
--name(VARCHAR)
--skills(VARCHAR)

--Part 2
-- write an SQL query to list the names of employers only in St. Louis City
----------------------------------------------------------------------------

SELECT name
FROM employer
WHERE location = "St. Louis City";

--Part 3
-- write an SQL query to remove the job table

DROP TABLE job;

--Part 4

-- write a query to return the names of all skills that are attached to jobs in alphabetical order.
-- If a skill does not have a job listed, it should not be included in the results of this query.

SELECT * FROM skill
INNER JOIN job_skills ON skill.id = job_skills.skills_id
WHERE job_skills.jobs_id IS NOT NULL
ORDER BY name ASC;