create table teens(
    id serial primary key,
    name varchar(255),
    gender varchar(1)
);

insert into teens(name, gender) values ('Сашeнька', 'Ж');
insert into teens(name, gender) values ('Вася', 'М');
insert into teens(name, gender) values ('Саша', 'М');
insert into teens(name, gender) values ('Петр', 'М');
insert into teens(name, gender) values ('Толя', 'М');
insert into teens(name, gender) values ('Катя', 'Ж');
insert into teens(name, gender) values ('Таня', 'Ж');

select  t1.name, t2.name
from teens t1
cross join teens t2
where t1.gender != t2.gender

