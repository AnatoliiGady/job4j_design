insert into car_bodies(name) values ('Седан');
insert into car_bodies(name) values ('Минивен');
insert into car_bodies(name) values ('Пикап');
insert into car_bodies(name) values ('Джип');
insert into car_bodies(name) values('Хетчбек');


insert into car_engines(name) values ('5A-FE');
insert into car_engines(name) values ('4A-FHE');
insert into car_engines(name) values ('A25A-FKS');
insert into car_engines(name) values ('6AR-FSE');
insert into car_engines(name) values ('1UZ-FE');
insert into car_engines(name) values ('4VZ-FE');
insert into car_engines(name) values ('2UZ-FE');


insert into car_transmissions(name) values ('АКП');
insert into car_transmissions(name) values ('МКП');
insert into car_transmissions(name) values ('Вариатор');


insert into cars(name, body_id, engine_id, transmission_id) values ('Toyota GAIA', 1, 1, 3);
insert into cars(name, body_id, engine_id, transmission_id) values ('Toyota Allion', 1, 1, 3);
insert into cars(name, body_id, engine_id, transmission_id) values ('Toyota Ipsum', 2, 6, 1);
insert into cars(name, body_id, engine_id, transmission_id) values ('Toyota LCP-150', 4, 7, 2);
insert into cars(name, body_id, engine_id, transmission_id) values ('Toyota Hilux', 4, 6, 2);
insert into cars(name, body_id, engine_id) values ('Toyota Rav4', 4, 5);
insert into cars(name, body_id, transmission_id) values ('Toyota Mark-2', 1, 2);
insert into cars(name, engine_id, transmission_id) values ('Toyota Crown', 4, 1);