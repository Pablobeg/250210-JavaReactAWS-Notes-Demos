/*
 * So our next thing is still kinda part of DQL but these are some common functions we can look at when querying
 * 
 * Aggregate Functions
 * 	These functions aggregrate or combine multiple rows together and return a single result for that group
 * 	- SUM
 * 	- MAX/MIN
 * 	- AVERAGE
 * 	- COUNT
 * Scalar Functions
 * 	These take in a number of rows and return the same amount of rows (it's to scale) with a data transformation
 * 	- LOWER/UPPER
 * 	- LENGTH
 * 	- ROUND
*/

CREATE TABLE sales(
	sale_id serial PRIMARY KEY,
	product TEXT,
	quantity int,
	unit_price decimal(5,2),
	sale_date DATE DEFAULT CURRENT_DATE -- This should DEFAULT TO the CURRENT date
);

INSERT INTO SALES (product, quantity, unit_price, sale_date) VALUES 
('Item A', 3, 10.00, '2025-01-01'),
('Item B', 2, 15.16, '2025-01-02'),
('Item C', 1, 20.00, '2025-01-03'),
('Item A', 7, 10.00, '2025-01-02'),
('Item B', 5, 15.16, '2025-01-02'),
('Item C', 4, 20.00, '2025-01-03');


-- Let's calculate a couple of values
-- Let's count the total number of sales
-- This counts the total number of records in the table
SELECT COUNT(*) FROM sales;
-- Reminder: These generally return one value per group so we just get 6 here

-- Maybe we want to count the number of items sold
-- This should be a SUM of the quantity column
SELECT SUM(quantity) FROM SALES;

-- We can also perform math operations on columns
-- Let's calculate the total revenue
-- Revenue is the sum of the quantity times price
SELECT SUM(quantity * unit_price) FROM SALES;

-- Let's get the average unit price
SELECT AVG(unit_price) FROM sales;

-- Let's say I need more detailed info about the sales
-- WE NEED TO GROUP THE DATA

-- How many of each product were bought
-- WE NEED TO USE GROUP BY TO DEFINE A GROUP
SELECT product, SUM(quantity) FROM SALES GROUP BY product;

-- What is the total revenue per product?
SELECT product, SUM(quantity * unit_price) FROM SALES GROUP BY product ORDER BY product;
-- The name "sum" in the result set it's the most expressive of what the column is
-- The column actually represents REVENUE so we should give it an alias and call it that
SELECT product, SUM(quantity * unit_price) AS revenue FROM SALES 
GROUP BY product ORDER BY product;

SELECT product, SUM(quantity * unit_price) AS revenue FROM SALES 
WHERE unit_price > 15
GROUP BY product ORDER BY product;


-- What day had the most sales?
SELECT sale_date, COUNT(*) FROM SALES GROUP BY sale_date ORDER BY sale_date desc;

-- What happens if I wanted to filter AFTER aggregating
-- I want the revenue of all products whose total revenue is GREATER than 100
SELECT product, SUM(quantity * unit_price) AS revenue FROM SALES 
GROUP BY product 
-- HAVING is like WHERE but it happens AFTER aggregation, WHERE happens before
WHERE SUM(quantity * unit_price) > 100
ORDER BY product;


-- Scalar functions
-- These are typically used for data transformations
SELECT UPPER(Product) FROM sales;
-- Transforms all data to uppercase
SELECT LOWER(Product) FROM sales;
-- Notice this takes in 6 rows and returns 6 rows
SELECT product, LENGTH(product) FROM sales;

-- ROUND
SELECT product, ROUND(unit_price, 1) FROM sales

-- CEIL, FLOOR, NOW(), AGE() (Difference in dates)
SELECT sale_date, AGE(NOW(), sale_date) FROM sales

SELECT ROUND(2.34567, 2); -- This is weird



















