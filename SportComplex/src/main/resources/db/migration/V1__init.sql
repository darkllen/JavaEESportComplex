create table users
(
    id       int primary key auto_increment,
    login    varchar(30) not null,
    password varchar(40) not null,
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
    city       varchar not null
);

-- create table schedule
-- (
--     id              int primary key auto_increment,
--     schedule_date   date not null,
--     coach_id        int not null,
--     constraint fk_coach_to_schedule foreign key (coach_id) references users(id),
--     client_id       int null,
--     constraint fk_client_to_schedule foreign key (client_id) references users(id),
-- );
--
-- insert into schedule (schedule_date, coach_id, client_id) values
-- (CURRENT_DATE(), 1, 1),
-- (CURRENT_DATE(), 2, null);


insert into complex (`space`, floors_num, open_date, city) values
(175, 2, CURRENT_DATE(), 'Kyiv'),
(345, 4, null, 'Odessa');


insert into users (login, password) values
('admin', 'admin'),
('user', 'user');

insert into permissions (permission) values
('ADMIN'),
('ADMINISTRATOR'),
('COACH'),
('CLIENT');

insert into user_to_permissions (user_id, permission_id) values
((select id from users where login = 'admin'), (select id from permissions where permission = 'ADMIN')),
((select id from users where login = 'user'), (select id from permissions where permission = 'CLIENT'));