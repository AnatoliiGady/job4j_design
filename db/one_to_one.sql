create table client(
    id serial primary key,
    name_cl varchar(255)
);

create table insurance(
    id serial primary key,
    insuranceNumber int
);

create table client_insurance(
    id serial primary key,
    client_id int references client(id) unique,
    insurance_id int references insurance(id) unique
);

insert into client(name_cl) values ('Ivan');
insert into insurance(insuranceNumber) values (12345);
insert into client_insurance(client_id, insurance_id) values (1, 1);

insert into client(name_cl) values ('Petr');
insert into insurance(insuranceNumber) values (112233);
insert into client_insurance(client_id, insurance_id) values (2, 2);