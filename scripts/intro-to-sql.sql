/*
 * SQL (Structured Query Language) is a query language designed to help us interact with relational databases
 * 
 * Relational Database?
 * A database consisting of tables with rows and columns and the tables are related to each other
 * 
 * SQL is useful for all core operations for working with databases including defining, altering and removing tables,
 * inserting or manipulating data, managing transactions of statements, controlling access to the database and just 
 * generally querying the database for information
 * 
 * It has a simple syntax that is very similar to english so it's generally a very simple language to start with.
 */

-- Let's create our very first table

-- We can do this with the CREATE keyword
-- This first line defines the table name and everything the parantheses decides the columns and their information
CREATE TABLE people (
	person_id int PRIMARY KEY,
	first_name varchar(30),
	last_name varchar(30),
	age int,
	isMarried bool,
	height numeric(5,2)
); -- ; IS NOT technically required

-- Let's break this down
-- Every column in SQL has 3 different pieces for its definition
/*
 * First piece is the column name
 * 	- person_id
 * 	- first_name
 * 	- age
 * 		- NOTE that columns with multiple words are separated by _ because most of the time SQL is case insensitive
 * 		for column/table names
 * 
 * Next thing we need is the column datatype
 * 	- int -> standard integer
 * 	- varchar(n) -> variable length string with character length of 0 to n
 * 	- bool/boolean -> standard boolean value
 * 	- numeric(p,s) / decimal(p,s) -> Floating point number with p total digits and s digits after the decimal point
 * 	- text -> unlimited length string
 * 	- char(n) -> Is like varchar but it must be EXACTLY n characters long
 * 	- THERE ARE A LOT MORE, we don't need to remember all of them but these are some of the core few
 * 
 * Last thing each column needs is a constraint
 * 	- Not every column has these but they control the data that can be inserted into them
 * 	- PRIMARY KEY
 * 	- UNIQUE
 * 	- NOT NULL
 * 	- CHECK
 * 	- DEFAULT
 * 	- FOREIGN KEY
 */

-- Let's insert in some data
-- Creating data is associated with INSERT
INSERT INTO people VALUES 
(1, 'Bryan', 'Serfozo', 25, FALSE, 182.88),
(2, 'Kaitlyn', 'Graves', 25, FALSE, 150);

-- this actually enters 2 different people

-- If I wanted to get the info back from the table how do I do that?
-- SELECT is used for reading data from the table
SELECT * FROM people;

/*
 * SQL Sublanguages
 * There are a lot of different SQL commands to remember but they can be grouped into 5 different categories
 * 
 * DDL (Data Definition Language)
 * 	- This is a sublanguage associated with the creation and maintenence of Schema (tables, columns, etc)
 * 	- This language DEFINES what the data should look like
 * 	- Commands
 * 		- CREATE 
 * 			- Used to create new tables or schema
 * 		- ALTER
 * 			- Used to update tables or columns (adding columns, changing datatypes, adding constraints, etc)
 * 		- TRUNCATE
 * 			- Used to remove all of the data in a table (but does not remove the table itself)
 * 		- DROP
 * 			- Used to delete a table and all of its data
 * 
 * DML (Data Manipulation Language)
 * 	- This sublanguage is associated with manipulation of Data
 * 	- The main ways we can manipulate data align with our CRUD operations
 * 		- CRUD -> Create, Read, Update, Delete
 * 		- This is the simplest way we can interact with data
 * 	- Commands
 * 		- INSERT
 * 			- Used for CREATING data / inserting it into a table
 * 		- SELECT
 * 			- Used for READING data
 * 		- UPDATE
 * 			- Used for UPDATING data
 * 		- DELETE
 * 			- Used for DELETING data
 * 
 * DQL (Data Query Language)
 * 	- Some people do not consider this its own sublanguage but rather a part of DML
 * 	- This language is associated with all the ways we can query a database
 * 		- All of the additional clauses that we can apply to a SELECT statment
 * 	- Keywords
 * 		- WHERE
 * 		- HAVING
 * 		- GROUP BY
 * 		- ORDER BY
 * 		- BETWEEN
 * 		- LIKE/ILIKE
 * 
 * DCL (Data Control Language)
 * 	- This language is associated with controlling permission on who can access and update the database
 * 	- Commands
 * 		- GRANT
 * 			- Used to grant permissions to specific users
 * 		- REVOKE
 * 			- Used to remove permissions from specific users
 * 
 * TCL (Transaction Control Language)
 * 	- A transaction is a block of DML statements that all get executed together in a block (either they all work or none
 * 		of them do)
 * 	- Think of this like version control (git) but for your database
 * 	- Commands
 * 		- COMMIT
 * 		- SAVEPOINT
 * 		- ROLLBACK
 */


-- DDL
CREATE TABLE pets(
	pet_id int PRIMARY KEY,
	name TEXT,
	age int
);

-- DML
INSERT INTO pets VALUES 
(1, 'Cash', 12),
(2, 'Mya', 15),
(3, 'Rex', 3);


-- SELECT Statements
-- Get ALL columns I use *
SELECT * FROM PETS;

-- Select specific columns
SELECT name, age FROM pets;

-- Simple Filter with SELECT and WHERE
-- WHERE is used to filter how the query affects data in different DML queries
SELECT * FROM PETS WHERE age < 10;

-- DDL
-- I can truncate the table to remove the info
TRUNCATE TABLE PETS;
-- This removes the data not the table

DROP TABLE pets; 
-- This removes the data and the table entirely

-- Constraints
/*
 * Constraints affect the values of data we can insert into a column
 * 
 * - UNIQUE
 * 	- This guarantees each record will have a unique value across the entire table
 * 	- Ex: Username
 * - NOT NULL
 * 	- This guarantees a value must be entered for that record
 * - PRIMARY KEY
 * 	- This is a combination of UNIQUE and NOT NULL
 * 	- This creates a unique identifier for the table, every row must have a value in this column and it must be unique
 * 	- Using the primary key you can easily identify any single record in the entire table
 * - FOREIGN KEY
 * 	- This marks a column as a reference to another table and its primary key (generally)
 * - CHECK
 * 	- This verifies the data matches a specific criteria
 * 	- Age > 0
 * - DEFAULT
 * 	- Enters in a default value for a column if none is provided
 */

CREATE TABLE EMPLOYEES(
	-- SERIAL is a sub datatype of int (all serial values are int)
	-- SERIAL is nice since it will auto increment the values for this column so I don't have to specify anything
	employee_id serial PRIMARY KEY,
	name TEXT NOT NULL,
	email TEXT UNIQUE,
--	age int CHECK (age > 0),
	salary decimal(10,2) CHECK (salary > 0),
	is_manager bool DEFAULT false
); 

-- Test some constraints
INSERT INTO employees VALUES 
(1, 'Bryan Serfozo', 'bryan.serfozo@revature.com', 25, TRUE);

-- Let's try entering a NULL Name
INSERT INTO EMPLOYEES VALUES 
(2, NULL, 'kgraves@example.com', 26, false);
-- This doesn't work because we cannot enter in a null name

-- Email is supposed to be UNIQUE so let's test that
INSERT INTO EMPLOYEES VALUES 
(2, 'Kaitlyn Graves', 'bryan.serfozo@revature.com', 26, false);
-- This doesn't work because the email was already taken

-- Let's test our primary key
INSERT INTO EMPLOYEES VALUES 
(NULL, 'Kaitlyn Graves', 'kgraves@example.com', 26, false);
INSERT INTO EMPLOYEES VALUES 
(1, 'Kaitlyn Graves', 'kgraves@example.com', 26, false);
-- The first one doesn't work because the id is NULL and the second doesn't work because the id is already taken

-- Check makes sure everything follows the rules specified by the constraint
INSERT INTO EMPLOYEES VALUES 
(2, 'Kaitlyn Graves', 'kgraves@example.com', -37, false);
-- Doesn't work because age is less than 0

-- DEFAULT provides a value in the event we do not provide one ourselves
INSERT INTO EMPLOYEES (employee_id, name, age) VALUES 
(2, 'Kaitlyn Graves', 26);

SELECT * FROM EMPLOYEES;

DROP TABLE EMPLOYEES;


-- Let's insert in some records to do some DML statements
-- Adding in mock data from mockaroo
insert into employees (name, email, salary, is_manager) values ('Son Mulvey', 'smulvey0@bravesites.com', 21558.84, null);
insert into employees (name, email, salary, is_manager) values ('Lutero Mumbey', 'lmumbey1@nasa.gov', 93366.33, true);
insert into employees (name, email, salary, is_manager) values ('Pauli Beveredge', 'pbeveredge2@com.com', 94077.56, false);
insert into employees (name, email, salary, is_manager) values ('Annmaria Tombs', 'atombs3@dagondesign.com', 53270.62, true);
insert into employees (name, email, salary, is_manager) values ('Devonna Rappaport', 'drappaport4@usnews.com', 56003.3, false);
insert into employees (name, email, salary, is_manager) values ('Correy Soames', 'csoames5@indiatimes.com', 45124.9, true);
insert into employees (name, email, salary, is_manager) values ('Brady Egger', 'begger6@dailymotion.com', 46126.32, false);
insert into employees (name, email, salary, is_manager) values ('Symon Rustan', 'srustan7@tmall.com', 19888.2, false);
insert into employees (name, email, salary, is_manager) values ('Jamie McGuire', 'jmcguire8@e-recht24.de', 60931.31, true);
insert into employees (name, email, salary, is_manager) values ('Denice Ind', 'dind9@dailymail.co.uk', 33100.14, true);
insert into employees (name, email, salary, is_manager) values ('Xenos Schafer', 'xschafera@discuz.net', 28840.32, true);
insert into employees (name, email, salary, is_manager) values ('Janice Stickins', 'jstickinsb@goodreads.com', 13400.78, false);
insert into employees (name, email, salary, is_manager) values ('Marketa Nazaret', 'mnazaretc@sitemeter.com', 22237.57, true);
insert into employees (name, email, salary, is_manager) values ('Gwennie Connichie', 'gconnichied@toplist.cz', 96280.9, false);
insert into employees (name, email, salary, is_manager) values ('Elvina Grunnill', 'egrunnille@pen.io', 76752.35, null);



-- DML statements
SELECT * FROM Employees;

-- Update some records
-- UPDATE table SET column=newValue WHERE identifier
UPDATE employees SET salary = 1.07 * salary, is_manager = TRUE WHERE employee_id=15;

-- DELETE 
-- DELETE FROM table WHERE identifier
-- We'll remove all employees who have a salary less than 20k
DELETE FROM employees WHERE salary < 20000;

-- DELETE vs DROP vs TRUNCATE
/*
 * TRUNCATE
 * 	- Removes all the data from a table and leaves the table structure behind
 * 	- DDL
 * DROP
 * 	- Removes the table and all of its associated data
 * 	- DDL
 * DELETE
 * 	- Deletes individual rows from the table itself based off some criteria
 * 	- DML
 * 	- NOTE: Just saying 'DELETE FROM table' with no WHERE clause is the same as a truncate
 */

-- DQL
-- Data Query Language and it refers to the various clauses we can add on to a SELECT statement

-- SELECT All
SELECT * FROM employees;

-- SELECT specific columns
SELECT name, email FROM employees;

-- WHERE for basic filtering
SELECT * FROM employees WHERE salary > 80000;

-- ORDER BY
-- Allows you to order by a column, default ordering is ascending
SELECT * FROM employees ORDER BY salary;
-- We can reverse the ordering by descending the column
SELECT * FROM employees ORDER BY salary DESC;


-- We can use BETWEEN to specify upper and lower bounds on a column
SELECT * FROM EMPLOYEES WHERE salary > 30000 AND salary < 50000;
SELECT * FROM EMPLOYEES WHERE salary BETWEEN 30000 AND 50000;

-- Offsetting and Limiting
-- We can LIMIT the amount of results that are returned by using limit
-- Let's show our top 5 earners
SELECT name, salary FROM EMPLOYEES ORDER BY SALARY DESC LIMIT 5;
-- Now we can also offset this amount, so let's say I want the second lowest earner in the table
SELECT name, salary FROM employees ORDER BY SALARY LIMIT 1 OFFSET 1;
-- OFFSET cuts records from the top of the result set and LIMIT cuts off the bottom
SELECT name, salary FROM employees ORDER BY SALARY OFFSET 1 LIMIT 1;


-- Like and ILIKE
-- Like and ILIKE are used for text pattern matching
-- Let's say I wanted all of the employees whose name begins with B
SELECT * FROM EMPLOYEES WHERE NAME LIKE 'B%';
-- What is happening here? The % is an operator that means 0-any number of characters
-- This will return all records that start with the character B and any number of characters afterwards
-- _ specifies a single character that can be any value
-- Let's get all people who have e as the second letter in their name
SELECT * FROM employees WHERE NAME LIKE '_e%';
-- I can put the wild cards pretty much wherever I want
-- People with emails who end in .com
SELECT email FROM employees WHERE email LIKE '%.com';

-- All people whose name have the letter r
SELECT name FROM employees WHERE name LIKE '%r%';

-- It's important to note that Like is case sensitive
SELECT name FROM employees WHERE name LIKE '%b%';

-- Use ILIKE (ignore case like) to perform this operation without case sensitivity
SELECT name FROM employees WHERE name ILIKE '%b%';


-- IN is used during filtering to check if something belongs in a list of values
SELECT * FROM employees WHERE employee_id IN (1,2,3,7,9);















