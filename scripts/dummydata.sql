INSERT INTO customer (forename, lastname, phone, address, postcode, postaladdress)
	values ('Ola', 'Nordmann', '12345678', 'Munkegata 1', '7050', 'Trondheim');
INSERT INTO customer (forename, lastname, phone, address, postcode, postaladdress)
	values ('Sigurd', 'Lund', '11223344', 'Odd Brochmannsvei 49', '7051', 'Trondheim');
INSERT INTO customer (forename, lastname, phone, address, postcode, postaladdress)
	values ('Even', 'Lislebø', '92345699', 'Munkegata 5', '7050', 'Trondheim');
INSERT INTO customer (forename, lastname, phone, address, postcode, postaladdress)
	values ('Øivind', 'Binde', '81345678', 'Klostergata', '7050', 'Trondheim');
INSERT INTO customer (forename, lastname, phone, address, postcode, postaladdress)
	values ('Petter', 'Northug', '913345678', 'Motbakken 2', '7200', 'Trondheim');
INSERT INTO customer (forename, lastname, phone, address, postcode, postaladdress)
	values ('Lilly', 'Meister', '9334538', 'Berteveien 4', '7050', 'Trondheim');


INSERT INTO employee (forename, lastname, username)
	values ('David', 'Storjord', 'david');
INSERT INTO employee (forename, lastname, username)
	values ('Morten', 'Noddeland', 'mortnod');

INSERT INTO product (name, price)
	values ('Bari', '220');
INSERT INTO product (name, price)
	values ('Genoa', '150');
INSERT INTO product (name, price)
	values ('Cuneo', '220');
INSERT INTO product (name, price)
	values ('Palermo', '190');
INSERT INTO product (name, price)
	values ('Naples', '170');
INSERT INTO product (name, price)
	values ('Monza', '170');
INSERT INTO product (name, price)
	values ('Milan', '210');
INSERT INTO product (name, price)
	values ('Messina', '190');
INSERT INTO product (name, price)
	values ('Siena', '190');
INSERT INTO product (name, price)
	values ('Rømme', '30');
INSERT INTO product (name, price)
	values ('CocaCola', '40');
INSERT INTO product (name, price)
	values ('Hvitløk', '40');
INSERT INTO product (name, price)
	values ('Vann', '30');
INSERT INTO product (name, price)
	values ('Oristano', '220');
INSERT INTO product (name, price)
	values ('Frakt', '50');

INSERT INTO orders (status, customer_idcustomer)
	values ('Levert', 1);
INSERT INTO orders (status, customer_idcustomer)
	values ('Levert', 2);
INSERT INTO orders (status, customer_idcustomer)
	values ('Under levering', 1);
INSERT INTO orders (status, customer_idcustomer)
	values ('Under levering', 3);
INSERT INTO orders (status, customer_idcustomer)
	values ('Bestilt', 4);
INSERT INTO orders (status, customer_idcustomer)
	values ('Bestilt', 2);
INSERT INTO orders (status, customer_idcustomer)
	values ('Bestilt', 1);
INSERT INTO orders (status, customer_idcustomer)
	values ('Lages', 2);
INSERT INTO orders (status, customer_idcustomer)
	values ('Lages', 5);
INSERT INTO orders (status, customer_idcustomer)
	values ('Hentet', 4);
INSERT INTO orders (status, customer_idcustomer)
	values ('Laget ferdig', 2);
INSERT INTO orders (status, customer_idcustomer)
	values ('Klar til henting',5);

INSERT INTO product_has_order(product_idproduct, orders_idorder, quantity)
	values(1,1,3);
INSERT INTO product_has_order(product_idproduct, orders_idorder, quantity)
	values(1,2,5);
INSERT INTO product_has_order(product_idproduct, orders_idorder, quantity)
	values(2,1,6);
INSERT INTO product_has_order(product_idproduct, orders_idorder, quantity)
	values(4,3,2);
INSERT INTO product_has_order(product_idproduct, orders_idorder, quantity)
	values(7,4,1);
INSERT INTO product_has_order(product_idproduct, orders_idorder, quantity)
	values(5,1,3);
INSERT INTO product_has_order(product_idproduct, orders_idorder, quantity)
	values(2,5,3);
INSERT INTO product_has_order(product_idproduct, orders_idorder, quantity)
	values(10,6,3);
INSERT INTO product_has_order(product_idproduct, orders_idorder, quantity)
	values(9,7,3);
INSERT INTO product_has_order(product_idproduct, orders_idorder, quantity)
	values(12,8,3);
INSERT INTO product_has_order(product_idproduct, orders_idorder, quantity)
	values(1,9,3);
INSERT INTO product_has_order(product_idproduct, orders_idorder, quantity)
	values(1,10,3);
INSERT INTO product_has_order(product_idproduct, orders_idorder, quantity)
	values(1,11,7);
INSERT INTO product_has_order(product_idproduct, orders_idorder, quantity)
	values(2,12,3);
INSERT INTO product_has_order(product_idproduct, orders_idorder, quantity)
	values(1,12,3);

INSERT INTO properties(limitFreeDelivery) 
	values(50);
