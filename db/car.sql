create table car(
    id serial primary key,
    model text,
    color varchar,
    enginePower int
);
insert into car (model, color, enginePower) values('Lexus', 'Green', 3);
select * from car;
update car set model = 'BMW', id = 1;
delete from car;

