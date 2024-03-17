create table model (
    id serial primary key,
    name_car varchar(255)
);

create table sts (
    id serial primary key,
    number int,
    model_id int references model(id)
);

insert into model (name_car) values ('Lexus LX570');
insert into model (name_car) values ('BMW X5');
insert into model (name_car) values ('Volvo XC90');
insert into model (name_car) values ('Toyota RAV4');
insert into model (name_car) values ('Mazda MPV');
insert into model (name_car) values ('Honda CRV');

insert into sts (number, model_id) values (1111, 1);
insert into sts (number, model_id) values (2222, 2);
insert into sts (number, model_id) values (3333, 3);
insert into sts (number, model_id) values (4444, 4);
insert into sts (number, model_id) values (5555, 5);
insert into sts (number, model_id) values (6666, 6);

select * from sts inner
join model on sts.model_id = model.id;

select s.model_id, s.number, m.name_car
from sts as s join model as m on s.model_id = m.id;

select m.name_car, s.number, s.model_id
from sts as s join model as m on s.model_id = m.id;

select s.model_id as №, s.number as Номера, m.name_car as Модель
from sts as s join model as m on s.model_id = m.id;

select s.model_id as "№ п/п", s.number "Номер автомобиля", m.name_car Модель
from sts s join model m on s.model_id = m.id;