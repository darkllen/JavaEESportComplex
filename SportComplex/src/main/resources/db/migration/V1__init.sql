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
    city       varchar (20) not null,
    admin_id   int null,
    constraint fk_complex_to_user foreign key (admin_id) references users(id)
);


create table type
(
    id              int primary key auto_increment,
    name            varchar (20) not null,
    vip             bit not null,
    price           int not null
);

create table abonement
(
    id              int primary key auto_increment,
    price           int not null,
    time_in_month   int not null,
    type_id         int not null,
    constraint fk_abonement_to_type foreign key (type_id) references type(id),
    complex_id      int not null,
    constraint fk_abonement_to_complex foreign key (complex_id) references complex(id),
    user_id         int null,
    constraint fk_abonement_to_user foreign key (user_id) references users(id),
    user_phone      varchar (13) null
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
    time            time not null,
    for_vip         bit not null
);


create table complex_coach
(
    id          int primary key auto_increment,
    coach_id    int not null,
    constraint fk_complex_coach_coach foreign key (coach_id) references users(id),
    unique uniq_coach (coach_id),
    complex_id  int not null,
    constraint fk_complex_coach_complex foreign key (complex_id) references complex(id)
);


create table codes
(
    id          varchar (20) primary key,
    role        varchar (10) not null,
    complex     int not null
);




insert into users (login, name, surname, password, role) values
('admin', 'Ihor', 'Yankin', 'admin', 'ADMIN'),
('coach', 'Anna', 'Hinkul', 'coach', 'COACH'),
('user', 'Angelina', 'Volkova', 'user', 'CLIENT'),
('coach2', 'Ira', 'Linki', 'coach2', 'COACH'),
('coach3', 'Inna', 'Ugan', 'coach3', 'COACH');
('owner', 'Maria', 'Kovaleva', 'owner', 'OWNER');


insert into permissions (permission) values
('ADMIN'),
('ADMINISTRATOR'),
('COACH'),
('CLIENT'),
('OWNER');


insert into complex (name, description, `space`, floors_num, open_date, city, admin_id) values
('wowC', null, 175, 2, CURRENT_DATE(), 'Kyiv', 1),
('myC', 'super complex', 345, 4, null, 'Odessa', null);

insert into type (name, vip, price) values
('usual', 0, 2000),
('super', 1, 4000);

insert into abonement (price, time_in_month, type_id, complex_id, user_id, user_phone) values
(8000, 12, 1, 1,3, null),
(1200, 6, 2, 2,null, '0661534986');

insert into schedule_ind (schedule_date, coach_id, client_id) values
('2021-09-12', 2, 3),
(CURRENT_DATE(), 2, 3);

insert into schedule_group (name, coach_id, day_of_week, time,for_vip) values
('swimming', 2, 'MONDAY', CURRENT_TIME(), 0),
('skalolasing', 2, 'TUESDAY', CURRENT_TIME(), 1),
('swimming', 5, 'TUESDAY', CURRENT_TIME(), 1),
('skalolasing', 4, 'FRIDAY', CURRENT_TIME(), 1);

insert into complex_coach (coach_id, complex_id) values
(2, 1),
(5,1),
(4, 1);

insert into user_to_permissions (user_id, permission_id) values
((select id from users where login = 'admin'), (select id from permissions where permission = 'ADMIN')),
((select id from users where login = 'user'), (select id from permissions where permission = 'CLIENT')),
((select id from users where login = 'coach'), (select id from permissions where permission = 'COACH')),
((select id from users where login = 'coach2'), (select id from permissions where permission = 'COACH')),
((select id from users where login = 'coach3'), (select id from permissions where permission = 'COACH')),
((select id from users where login = 'owner'), (select id from permissions where permission = 'OWNER'));