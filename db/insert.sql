insert into users(name) values ('Ivan');
insert into users(name) values ('Petr');
insert into users(name) values ('Anatolii');

insert into roles(name, user_id) values ('admin', 2);
insert into roles(name, user_id) values ('user', 3);
insert into roles(name, user_id) values ('guest', 1);

insert into rules(name) values ('full');
insert into rules(name) values ('reading');
insert into rules(name) values ('reading and copying');

insert into items(name, user_id) values ('install drivers for the printer', 2);
insert into items(name, user_id) values ('to send a letter', 3);
insert into items(name, user_id) values ('view file', 1);

insert into comments(name, item_id) values ('high priority', 1);
insert into comments(name, item_id) values ('medium priority', 2);
insert into comments(name, item_id) values ('normal priority', 3);

insert into attachs(name, item_id) values ('Excel work schedule.xlsx', 2);
insert into attachs(name, item_id) values ('job description.docx', 3);
insert into attachs(name, item_id) values ('drivers.exe', 1);

insert into states(name, item_id) values ('In process', 3);
insert into states(name, item_id) values ('Done', 1);
insert into states(name, item_id) values ('New', 2);

insert into categories(name, item_id) values ('Vip', 1);
insert into categories(name, item_id) values ('Regular', 2);
insert into categories(name, item_id) values ('Other', 3);

insert into roles_rules(role_id, rule_id) values (1, 1);
insert into roles_rules(role_id, rule_id) values (2, 2);
insert into roles_rules(role_id, rule_id) values (3, 3);
