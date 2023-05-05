create database university;

create table if not exists degree
(
    id   int auto_increment
        primary key,
    name varchar(255) not null
);

create table if not exists lector
(
    id        int auto_increment
        primary key,
    name      varchar(255)   not null,
    degree_id int            null,
    salary    decimal(10, 2) not null,
    constraint lector_ibfk_1
        foreign key (degree_id) references degree (id)
            on update cascade on delete cascade
);

create table if not exists department
(
    id                    int auto_increment
        primary key,
    name                  varchar(255) not null,
    head_of_department_id int          not null,
    constraint department_lector__fk
        foreign key (head_of_department_id) references lector (id)
);

create table if not exists department_lector
(
    id            int auto_increment
        primary key,
    department_id int null,
    lector_id     int null,
    constraint department_lector_ibfk_1
        foreign key (department_id) references department (id)
            on update cascade on delete cascade,
    constraint department_lector_ibfk_2
        foreign key (lector_id) references lector (id)
            on update cascade on delete cascade
);

create index department_id
    on department_lector (department_id);

create index lector_id
    on department_lector (lector_id);

create index lectors_ibfk_1
    on lector (degree_id);

