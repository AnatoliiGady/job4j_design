create table fauna
(
    id             serial primary key,
    name           text,
    avg_age        int,
    discovery_date date
);
insert into fauna(name, avg_age, discovery_date)
values ('Черепаха', 100500, '01.01.1568');
insert into fauna(name, avg_age, discovery_date)
values ('Сабака', 3650, '01.01.1643');
insert into fauna(name, avg_age, discovery_date)
values ('Кошка', 5475, '01.01.1645');
insert into fauna(name, avg_age, discovery_date)
values ('Хомяк', 1825, '01.01.1482');
insert into fauna(name, avg_age, discovery_date)
values ('Обезьяна', 7300, '01.01.1023');
insert into fauna(name, avg_age, discovery_date)
values ('Тигр', 10950, '01.01.1602');
insert into fauna(name, avg_age, discovery_date)
values ('Лев', 9125, '01.01.1608');
insert into fauna(name, avg_age, discovery_date)
values ('Слон', 18250, '01.01.1836');
insert into fauna(name, avg_age, discovery_date)
values ('fish', 18250, '01.01.1836');

select * from fauna where name like 'fish%';
select * from fauna where avg_age > 10000 and avg_age < 21000;
select * from fauna where discovery_date is null;
select * from fauna where discovery_date < '01.01.1950';