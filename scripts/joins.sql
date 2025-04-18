/*
 * Relationships and Multiplicity
 * 
 * When talked about SQL Databases we've mentioned that they're a series of RELATED tables
 * 
 * These tables are typically related through primary key - foreign key relationship
 * The different types of relationships are what we mean when use the term multiplicity
 * 
 * Multiplicity: Ways tables can be related
 * - One to One: One record in a table directly relates to only one other record in another table
 * 			- Personal Info related to user
 * 			- Employee and a workbadge
 * - One to Many: One record in the first table can relate to many records in the second table
 * 			- Authors and Books: One author can publish many books but a book typically has only one author
 * 			- Courses and assignments: One course can have many assignments and each assignment belongs to exactly
 * 				one course
 * 			- Departments and employees: One Department can have many employees but one employee only belongs to one 
 * 				department
 * - Many to One: The same thing as a 1:M but read from the other table
 * - Many to Many: Describes relationships where many items in the first table can relate to many items in the 
 * 		second table.
 * 		- Actors and Movies: One actor can play in many movies and one move contains many actors
 * 		- Students and Courses: One student can enroll in many courses and many students can enroll in a single course
 * 
 * NOTE: Many to Many relationship is a combination of a 1:M and M:1 relationship
 * 
 */

-- One to One
-- Students and Student info


CREATE TABLE students(
	student_id serial PRIMARY KEY,
	email TEXT UNIQUE,
	PASSWORD TEXT
);

CREATE TABLE student_info(
	student_info_id serial PRIMARY KEY,
	first_name TEXT,
	last_name TEXT,
	address TEXT,
	student_id int,
	FOREIGN KEY (student_id) REFERENCES students(student_id)
	-- This is saying the student_id column in this table directly references the table called students
);

-- Let's add in some students
INSERT INTO STUDENTS (email, password) VALUES 
('bryan.serfozo@revature.com', 'Password'),
('valerie.frizzle@school.com', 'SecretPassword'),
('kaitlyn.graves@example.com', 'VerySecretPassword');

-- Let's add in their student info
INSERT INTO student_info (first_name, last_name, address,  student_id) VALUES 
('Bryan', 'Serfozo', '123 Example Street', 1),
('Kaitlyn', 'Graves', '456 Sample Street', 3),
('Valerie', 'Frizzle', '789 Example Street', 2);

-- At this point we've added in some info, let's make sure the info is 1-1
INSERT INTO student_info(first_name, last_name, address, student_id) VALUES
('Not Bryan', 'Not Serfozo', 'test', 1);

-- When working with a 1-1 relationship the foreign key needs to be unique, otherwise multiple values can
-- relate to the same record
DELETE FROM STUDENT_INFO WHERE STUDENT_INFO_ID=4

-- We'll add on a unique constraint to make sure this doesn't happen again
-- DDL Command: ALTER
ALTER TABLE student_info ADD CONSTRAINT one2one UNIQUE(student_id);
-- Now the foreign key should be unique and we can only have one set of student info associated with one user

-- Recap: We related the tables using the foreign key constraint. If we wanted to make sure it was 1:1 we needed to
-- make it unique


-- ONE TO MANY
/*
 * One course is associated with many assignments
 * When doing one to many or many to one you should put the foreign key on the many side for most circumstances
 */

CREATE TABLE COURSES(
	course_id serial PRIMARY KEY,
	name TEXT,
	credits int
);

CREATE TABLE ASSIGNMENTS(
	assigment_id serial PRIMARY KEY,
	name TEXT,
	description TEXT,
	max_points int,
	course_id int REFERENCES COURSES
	-- This is saying this column references the COURSES table and if we don't specify a column it choose the PK
);

INSERT INTO COURSES (name, credits) VALUES 
('Intro to Java', 3),
('Calculus I', 4);

INSERT INTO ASSIGNMENTS (name, description, max_points, course_id) VALUES 
('Java Coding Challenge', 'Complete the coding challenge and pass the tests', 100, 1),
('Java Exam', 'Complete the multiple choice Java exam and pass', 50, 1),
('Calculus Math Test', 'Complete all the math questions', 200, 2);

-- In this case we have many assignments associated with one course

-- MANY TO MANY Relationships
-- Students enrolling in courses
-- One student can enroll in many courses
-- Many students can enroll in one course

-- We need a junction table to represent the relationship between students and courses
CREATE TABLE ENROLLMENTS(
	student_id int REFERENCES students,
	course_id int REFERENCES courses,
	PRIMARY KEY (student_id, course_id)
);

-- Enrollments is a bridge between students and courses to prevent redundant repeats of info
INSERT INTO ENROLLMENTS VALUES 
(1,1),
(1,2),
(2,1),
(2,2),
(3,1),
(3,2);

-- REFERENTIAL INTEGRITY
-- Don't reference a record that doesn't exist
INSERT INTO ENROLLMENTS VALUES (1, 10);
-- The statement above does not work because there is no course 10
-- This has to do with referential integrity which means the references between tables ALWAYS point to an exisitng record

-- Let's try to delete a student
DELETE FROM STUDENTS WHERE STUDENT_ID = 3;
-- This doesn't work because records are depending on this value to exist
-- Student Info and Enrollments BOTH reference this student so we cannot delete the student unless we delete the other
-- records first

-- WE CAN AVOID THIS WITH CASCADE



-- JOINS in SQL
/*
 * At this point we have the data for our "school" spread out across 5 different tables which is great for storing
 * the info since it's not being stored in a redundant way but it's bad for a user trying to figure out the information
 * in a way that might be useful
 * 
 * We're going to JOIN the tables back together to get information out of multiple tables
 * 
 * INNER JOIN
 * LEFT JOIN 
 * RIGHT JOIN
 * OUTER JOIN
 * NATURAL JOINS
 */


-- Inner Join
-- We can join 2 tables together based off their common column
SELECT * FROM STUDENTS
JOIN STUDENT_INFO
-- JOIN Predicate defines HOW to join the tables together
ON students.student_id = student_info.student_id;

SELECT first_name, last_name, email, PASSWORD, address FROM STUDENTS 
JOIN STUDENT_INFO
ON students.student_id = student_info.student_id;

-- The order in which you join the tables matter. The first table is the LEFT table and the second is the RIGHT table

-- Left Join
INSERT INTO STUDENTS (email, password) VALUES ('dewey.finn@schoolofrock.com', 'Password123');
-- The above student does not have any student info stored
SELECT * FROM STUDENTS;
SELECT * FROM STUDENT_INFO;

-- The left join will show ALL of the information from the first (LEFT) table regardless of whether it has matching
-- values in the right table. It will show as null for those fields
SELECT * FROM STUDENTS 
LEFT JOIN student_info
ON students.student_id = student_info.student_id;
-- The above shows dewey.finn@schoolofrock.com but the below does not

SELECT * FROM STUDENT_INFO
LEFT JOIN students
ON students.student_id = student_info.student_id;

-- Right Join
-- The same thing as a left join only it shows all the data in the right table and only matching records on the left

SELECT * FROM STUDENTS 
RIGHT JOIN student_info
ON students.student_id = student_info.student_id;
-- The below shows dewey.finn@schoolofrock.com but the above does not

SELECT * FROM STUDENT_INFO
RIGHT JOIN students
ON students.student_id = student_info.student_id;


-- Outer Join
-- Let's add in a record for the student info that is not related to a student
INSERT INTO STUDENT_INFO(FIRST_NAME, LAST_NAME) VALUES ('Not a', 'Student');

-- This join is really only useful for finding orphaned records because those are the only ones with null values
-- Order matters in this one too but really it's just for the table placement

SELECT * FROM STUDENTS 
FULL OUTER JOIN student_info
ON students.student_id = student_info.student_id 

-- Natural Join
-- If you're careful about how you name columns inside of your Database you can away with a natural join
-- A natural join is a variant of a regular join but it determines the join predicate implicitly based off column names
SELECT * FROM STUDENTS
NATURAL JOIN STUDENT_INFO;

-- We cannot use a natural join if we have multiple columns with the same name
SELECT * FROM COURSES 
NATURAL JOIN ASSIGNMENTS; -- This does work but doesn't SHOW anything since I think it's trying TO JOIN ON 2 COLUMNS
-- BE CAREFUL


-- Let's show all the student's first name, last name, email, course name, and assignments associated with them

SELECT first_name, last_name, email, courses.name, assignments."name"  FROM STUDENT_INFO 
JOIN students 
ON students.student_id = student_info.student_id
JOIN enrollments
ON students.student_id = enrollments.student_id
JOIN courses
ON enrollments.course_id = courses.course_id
JOIN assignments
ON courses.course_id = assignments.course_id
ORDER BY first_name;




















