insert into persons (id, name, birthdate)
values (1, 'Arti', '1994-11-11'),
       (2, 'Max', '19841212'),
       (33, 'Vlad', '1992-05-05');

insert into cars (id, vendor, model, power, person_id)
values (1, 'BMW', 'X5-rrgrt', 200, 1),
       (2, 'BMW', 'X6', 200, 1),
       (3, 'LADA', 'Granta', 100, 2),
       (4, 'FERRARI', 'M4', 300, 33);


SELECT DISTINCT c.vendor
FROM cars c