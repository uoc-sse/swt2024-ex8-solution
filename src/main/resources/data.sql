INSERT INTO Product (id, name, description, price) VALUES (0, 'yScreen', 'Monitor for y computers.', 63599);
INSERT INTO Product (id, name, description, price) VALUES (1, 'yMini', 'The smallest y computer.', 85999);
INSERT INTO Product (id, name, description, price) VALUES (2, 'yBook', 'A portable y computer.', 183999);
INSERT INTO Product (id, name, description, price) VALUES (3, 'yPhone', 'The y smartphone.', 89999);
INSERT INTO Product (id, name, description, price) VALUES (4, 'yWatch', 'A smartwatch by y.', 39999);
ALTER TABLE Product ALTER COLUMN id RESTART WITH 5;

INSERT INTO Store (id, location) VALUES (0, 'Köln');
INSERT INTO Store (id, location) VALUES (1, 'Düsseldorf');
INSERT INTO Store (id, location) VALUES (2, 'Bonn');
ALTER TABLE Store ALTER COLUMN id RESTART WITH 3;

INSERT INTO Stock (product_id, store_id, quantity) VALUES (0, 0, 58);
INSERT INTO Stock (product_id, store_id, quantity) VALUES (0, 1, 70);
INSERT INTO Stock (product_id, store_id, quantity) VALUES (1, 0, 123);
INSERT INTO Stock (product_id, store_id, quantity) VALUES (1, 1, 26);
INSERT INTO Stock (product_id, store_id, quantity) VALUES (2, 0, 33);
INSERT INTO Stock (product_id, store_id, quantity) VALUES (2, 1, 139);

INSERT INTO Employee (id, name, age) VALUES (0, 'Alice Example', 25);
INSERT INTO Employee (id, name, age) VALUES (1, 'Bob Beispiel', 38);
INSERT INTO Employee (id, name, age) VALUES (2, 'Carl Sample', 30);
ALTER TABLE Employee ALTER COLUMN id RESTART WITH 3;
