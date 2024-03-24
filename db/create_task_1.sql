create table departments(
    id serial primary key,
    name varchar(255)
);

create table positions_emp(
    id serial primary key,
    name varchar(255)
);

create table groups(
    id serial primary key,
    name varchar(3)
);


create table employees(
    id serial primary key,
    name varchar(255),
    salary float,
    department_id int references departments(id),
    position_id int references positions_emp(id),
    group_id int references groups(id)
);