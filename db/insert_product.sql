insert into type(name) values ('СЫР');
insert into type(name) values ('МОЛОКО');
insert into type(name) values ('МОРОЖЕННОЕ');

insert into product(name, type_id, expired_date, price)
values ('Сыр плавленный', 1, '15.03.2024', 280);
insert into product(name, type_id, expired_date, price)
values ('Сыр мацарелла', 1, '25.03.2024', 630);
insert into product(name, type_id, expired_date, price)
values ('Сыр черный принц', 1, '19.03.2024', 310);
insert into product(name, type_id, expired_date, price)
values ('Сыр золото артура', 1, '30.03.2024', 330);

insert into product(name, type_id, expired_date, price)
values ('Молоко фермерское', 2, '25.03.2024', 110);
insert into product(name, type_id, expired_date, price)
values ('Молоко подворье', 2, '15.03.2024', 125);
insert into product(name, type_id, expired_date, price)
values ('Молоко вечелый молочник', 2, '31.03.2024', 630);

insert into product(name, type_id, expired_date, price)
values ('Мороженное ванильное', 3, '30.06.2024', 200);
insert into product(name, type_id, expired_date, price)
values ('Мороженное шоколадное', 3, '10.05.2024', 250);
insert into product(name, type_id, expired_date, price)
values ('Мороженное клубничное', 3, '02.01.2024', 80);
insert into product(name, type_id, expired_date, price)
values ('Мороженное пикантное', 3, '31.12.2024', 630);

select product.name as "Продукт"
from product join type
on product.type_id = type.id
where type.name like '%СЫР%'

select name from product
where name like '%Мороженное%'

select name, expired_date
from product
where expired_date < now()

select name, price
from product
where price = (select all max(price) from product)

select type.name as "Тип", count(type.name) as "Количество"
from product join type
on product.type_id = type.id
group by type.name

select product.name as "Продукт"
from product join type
on product.type_id = type.id
where type.name like '%СЫР%' or
type.name like '%МОЛОКО%'

select type.name as "Тип продукта", count(type.name) as "Количество"
from type join product
on product.type_id = type.id
group by type.name
having count(type.name) < 10

select product.name as "Продукт", type.name as "Тип продукта"
from product join type
on product.type_id = type.id