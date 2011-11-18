INSERT INTO customer (forename, lastname, phone, address, postcode, postaladdress)
	values ('Ola', 'Nordmann', '12345678', 'Munkegata 1', '7050', 'Trondheim');
INSERT INTO customer (forename, lastname, phone, address, postcode, postaladdress)
	values ('Sigurd', 'Lund', '11223344', 'Odd Brochmannsvei 49', '7051', 'Trondheim');
INSERT INTO customer (forename, lastname, phone, address, postcode, postaladdress)
	values ('Petter', 'Northug', '913345678', 'Motbakken 2', '7200', 'Trondheim');
INSERT INTO customer (forename, lastname, phone, address, postcode, postaladdress)
	values ('Lilly', 'Meister', '9334538', 'Berteveien 4', '7050', 'Trondheim');

INSERT INTO product (name, price, visability)
	values ('Bari', '220', '1');
INSERT INTO product (name, price, visability)
	values ('Genoa', '150', '1');
INSERT INTO product (name, price, visability)
	values ('Cuneo', '220', '1');
INSERT INTO product (name, price, visability)
	values ('Palermo', '190', '1');
INSERT INTO product (name, price, visability)
	values ('Naples', '170', '1');
INSERT INTO product (name, price, visability)
	values ('Frakt', '50', '1');

INSERT INTO properties(limitFreeDelivery, name, address, postcode, postaladdress, phone) 
	values(500, 'Pizzamart', 'Munkegata 1', '7050', 'Trondheim', '22408070');
