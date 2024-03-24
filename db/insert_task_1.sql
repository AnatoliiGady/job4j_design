insert into departments(name) values ('ГКС');
insert into departments(name) values ('Связь');
insert into departments(name) values ('Энерговодоснабжение');
insert into departments(name) values ('КИПиА');
insert into departments(name) values ('САиМО');

insert into positions(name) values ('Начальник станции');
insert into positions(name) values ('Инженер-энергетик');
insert into positions(name) values ('инженер');
insert into positions(name) values ('Зам.начальника станции');
insert into positions(name) values ('Слесарь-ремонтник');
insert into positions(name) values ('Машинист');

insert into groups(name) values ('V');
insert into groups(name) values ('IV');
insert into groups(name) values ('III');
insert into groups(name) values ('II');
insert into groups(name) values ('I');

insert into employees(name, salary, department_id, position_id, group_id) values ('Кочергин И.Н.', 180000, 1, 1, 2);
insert into employees(name, salary, department_id, position_id, group_id) values ('Пановицин Д.Ю.', 120000, 1, 3, 3);
insert into employees(name, salary, department_id, position_id, group_id) values ('Лазарев С.Н.', 115000, 1, 3, 3);
insert into employees(name, salary, department_id, position_id, group_id) values ('Галиновский С.А.', 133500, 2, 3, 2);
insert into employees(name, salary, department_id, position_id, group_id) values ('Гады А.Н.', 150000, 3, 2, 1);
insert into employees(name, salary, department_id, position_id, group_id) values ('Кривенко Н.А', 160000, 3, 2, 1);
insert into employees(name, salary, department_id, position_id, group_id) values ('Любимов А.В.', 170000, 1, 3, 2);
insert into employees(name, salary, department_id, position_id, group_id) values ('Щербаков А.А.', 140000, 1, 5, 2);
insert into employees(name, salary, department_id, position_id, group_id) values ('Аликин Н.А.', 170000, 1, 3, 2);
