select c.id, c.name as "Автомобиль", b.name as "Кузов", e.name as "Двигатель", t.name as "Коробка передач"
from cars as c
left join car_bodies as b
on c.body_id = b.id
left join car_engines as e
on c.engine_id = e.id
left join car_transmissions as t
on c.transmission_id = t.id

select car_bodies.name as "Кузов"
from car_bodies
left join cars
on cars.body_id = car_bodies.id
where cars.name is null

select car_engines.name as "Двигатель"
from car_engines
left join cars
on cars.engine_id = car_engines.id
where cars.name is null

select car_transmissions.name as "Коробка передач"
from car_transmissions
left join cars
on cars.transmission_id = car_transmissions.id
where cars.name is null