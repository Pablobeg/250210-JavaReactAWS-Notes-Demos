-- This is going to be used to set up our table for our DB
-- The tables in here should line up with our Model classes
CREATE TABLE items(
	item_id serial PRIMARY KEY,
	name TEXT,
	quantity int,
	category varchar(20)
);

INSERT INTO ITEMS (name, quantity, category) VALUES 
('Tomatoes', 4, 'PRODUCE'),
('Grill', 2, 'OUTDOORS');

-- HOW DO I GET ALL THE INFO FROM THE TABLE
SELECT * FROM items;

INSERT INTO ITEMS (name, quantity, category) VALUES 
('Onions', 10, 'PRODUCE');

-- RETURNING *
-- RETURNING * allows us to return all of the rows that were just inserted 
-- This does exist in POSTGRES but not all vendors
INSERT INTO ITEMS (name, quantity, category) VALUES 
('Mario Kart World', 1, 'ELECTRONICS') RETURNING *;











