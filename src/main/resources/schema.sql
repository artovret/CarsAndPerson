drop table if exists cars,persons;

create table persons (
                      id serial primary key ,
                      name text,
                      birthdate timestamp with time zone
);

create table cars (
    id serial primary key ,
    model text,
    power integer,
    person_id bigint,
    foreign key (person_id) references persons (id)
);

insert into persons (name,birthdate) values
                                            ('Arti','1994-11-11'),
                                            ('Max','19841212'),
                                            ('Vlad','1992-05-05');

insert into cars (model,power,person_id) values
    ('BMW',200,1),
    ('BMW2',200,1),
    ('LADA',100,2),
    ('FERRARI',300,3);