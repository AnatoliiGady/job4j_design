insert into roles(name) values ('admin');
insert into roles(name) values ('user');
insert into roles(name) values ('guest');

insert into rules(name) values ('full');
insert into rules(name) values ('reading');
insert into rules(name) values ('reading and copying');

insert into users(name, role_id) values ('Ivan', 3);
insert into users(name, role_id) values ('Petr', 1);
insert into users(name, role_id) values ('Anatolii', 2);

insert into roles_rules(role_id, rule_id) values (1, 1);
insert into roles_rules(role_id, rule_id) values (2, 2);
insert into roles_rules(role_id, rule_id) values (3, 3);

insert into states(name) values ('In process');
insert into states(name) values ('Done');
insert into states(name) values ('New');

insert into categories(name) values ('Vip');
insert into categories(name) values ('Regular');
insert into categories(name) values ('Other');

insert into items(name, user_id, category_id, state_id) values ('install drivers for the printer', 2, 1, 2);
insert into items(name, user_id, category_id, state_id) values ('to send a letter', 3, 2, 1);
insert into items(name, user_id, category_id, state_id) values ('view file', 1, 3, 3);

insert into comments(name, item_id) values ('high priority', 1);
insert into comments(name, item_id) values ('medium priority', 2);
insert into comments(name, item_id) values ('normal priority', 3);

insert into attachs(name, item_id) values ('Excel work schedule.xlsx', 2);
insert into attachs(name, item_id) values ('job description.docx', 3);
insert into attachs(name, item_id) values ('drivers.exe', 1);

