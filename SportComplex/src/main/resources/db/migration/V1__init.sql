create table users
(
    id       int primary key auto_increment,
    login    varchar(30) not null,
    name     varchar (20) not null,
    surname  varchar (20) not null,
    password varchar(40) not null,
    role     varchar (10) not null,
    unique uniq_login (login)
);

create table permissions
(
    id         int primary key auto_increment,
    permission varchar(30) not null,
    unique uniq_permission (permission)
);

create table user_to_permissions
(
    user_id int not null,
    permission_id int not null,
    constraint fk_user_to_permission_user foreign key (user_id) references users(id),
    constraint fk_user_to_permission_permission foreign key (permission_id) references permissions(id)
);


create table complex
(
    id         int primary key auto_increment,
    name       varchar (25) not null,
    description varchar (100) null,
    space      int not null,
    floors_num int not null,
    open_date  date null,
    city       varchar (20) not null
);

create table schedule_ind
(
    id              int primary key auto_increment,
    schedule_date   date not null,
    coach_id        int not null,
    constraint fk_coach_to_schedule_ind foreign key (coach_id) references users(id),
    client_id       int not null,
    constraint fk_client_to_schedule_ind foreign key (client_id) references users(id)
);

create table schedule_group
(
    id              int primary key auto_increment,
    name            varchar (20) not null,
    coach_id        int not null,
    constraint fk_coach_to_schedule_group foreign key (coach_id) references users(id),
    day_of_week     varchar (10) not null,
    time            time not null
);




insert into complex (name, description, `space`, floors_num, open_date, city) values
('wowC', null, 175, 2, CURRENT_DATE(), 'Kyiv'),
('myC', 'super complex', 345, 4, null, 'Odessa');


insert into users (login, name, surname, password, role) values
('admin', 'Ihor', 'Yankin', 'admin', 'ADMIN'),
('coach', 'Anna', 'Hinkul', 'coach', 'COACH'),
('user', 'Angelina', 'Volkova', 'user', 'CLIENT');

insert into permissions (permission) values
('ADMIN'),
('ADMINISTRATOR'),
('COACH'),
('CLIENT');

insert into schedule_ind (schedule_date, coach_id, client_id) values
(CURRENT_DATE(), 2, 3),
(CURRENT_DATE(), 2, 3);

insert into schedule_group (name, coach_id, day_of_week, time) values
('swimming', 2, 'MONDAY', CURRENT_TIME()),
('skalolasing', 2, 'TUESDAY', CURRENT_TIME());

insert into user_to_permissions (user_id, permission_id) values
((select id from users where login = 'admin'), (select id from permissions where permission = 'ADMIN')),
((select id from users where login = 'user'), (select id from permissions where permission = 'CLIENT'));