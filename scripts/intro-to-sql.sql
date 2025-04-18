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
 * 	- Enters in a default value for a column if non is provided
 */

CREATE TABLE EMPLOYEES(


)
























