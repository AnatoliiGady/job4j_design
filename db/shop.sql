create table devices (
    id serial primary key,
    name_device varchar(255),
    price float
);

create table people (
    id serial primary key,
    name varchar(255)
);

create table devices_people (
    id serial primary key,
    device_id int references devices (id),
    people_id int references people (id)
);

insert into devices(name_device, price) values ('iphone 14pro', 120000);
insert into devices(name_device, price) values ('ipad ultra', 180000);
insert into devices(name_device, price) values ('LOC 2138', 30000);
insert into devices(name_device, price) values ('Samsung S21FE', 80000);
insert into devices(name_device, price) values ('Gigabyte N200', 100000);
insert into devices(name_device, price) values ('Samsung S22', 115000);
insert into devices(name_device, price) values ('LG 2028', 12300);
insert into devices(name_device, price) values ('Nokia C8', 2000);

insert into people (name) values ('Petr');
insert into people (name) values ('Ivan');
insert into people (name) values ('Anatolii');
insert into people (name) values ('Anya');
insert into people (name) values ('Gena');
insert into people (name) values ('Anzela');
insert into people (name) values ('Egor');

insert into devices_people (device_id, people_id) values (1, 1);
insert into devices_people (device_id, people_id) values (2, 2);
insert into devices_people (device_id, people_id) values (3, 2);
insert into devices_people (device_id, people_id) values (4, 3);
insert into devices_people (device_id, people_id) values (8, 7);
insert into devices_people (device_id, people_id) values (6, 1);

select avg(price) from devices;

select p.name as "Покупатель", avg(d.price) as "Средняя цена"
from devices_people as dp
join devices as d
on dp.device_id = d.id
join people as p
on dp.people_id = p.id
group by p.name
having avg(d.price) > 50000;
