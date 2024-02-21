create table student(
    id serial primary key,
    studentName varchar(255)
);

create table item(
    id serial primary key,
    itemName varchar(255)
);

create table student_item(
    id serial primary key,
    studentName_id int references student(id),
    itemName_id int references item(id)
);

insert into student ("studentname") values ('Ivan');
insert into student (studentname) values ('Petr');
insert into student (studentname) values ('Alex');

insert into item (itemname) values ('Math');
insert into item (itemname) values ('Geography');
insert into item (itemname) values ('Chemistry');
insert into item (itemname) values ('Physics');

insert into student_item(studentName_id, itemName_id) values (1, 3);
insert into student_item(studentName_id, itemName_id) values (1, 4);
insert into student_item(studentName_id, itemName_id) values (2, 1);
insert into student_item(studentName_id, itemName_id) values (2, 2);
insert into student_item(studentName_id, itemName_id) values (2, 3);
insert into student_item(studentName_id, itemName_id) values (3, 1);
