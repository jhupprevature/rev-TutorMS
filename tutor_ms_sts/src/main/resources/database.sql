
drop table if exists date_events cascade;
drop table if exists schedules cascade;
drop table if exists account_types cascade;
drop table if exists courses cascade;
drop table if exists users cascade;
drop table if exists sessions cascade;
drop table if exists tutors_courses cascade;

create table account_types (
    id         serial primary key,
    type       varchar(50)
);

create table schedules (
    id                     serial primary key,
    sunday_start           varchar(255) null,
    sunday_end             varchar(255) null,
    monday_start           varchar(255) null,
    monday_end             varchar(255) null,
    tuesday_start          varchar(255) null,
    tuesday_end            varchar(255) null,
    wednesday_start        varchar(255) null,
    wednesday_end          varchar(255) null,
    thursday_start         varchar(255) null,
    thursday_end           varchar(255) null,
    friday_start           varchar(255) null,
    friday_end             varchar(255) null,
    saturday_start         varchar(255) null,
    saturday_end           varchar(255) null,
    pending_approval_since bigint null
);

create table users (
    id                 serial primary key,
    first_name         varchar(255),
    last_name          varchar(255),
    school_email       varchar(255) unique,
    password           varchar(255),
    phone_number       varchar(255) null,
    account_type_id    integer references account_types(id) on delete restrict,
    schedule_id        integer null references schedules(id) on delete cascade
);

create table courses (
    id         serial primary key,
    name       varchar(255),
    subject    varchar(4),
    level      integer,
    hours      int
);

create table tutors_courses (
    tutor_id   integer references users(id) on delete restrict,
    course_id  integer references courses(id) on delete restrict,
    primary key (tutor_id, course_id)
);

create table sessions (
    id             serial primary key,
    tutor_id       integer references users(id) on delete restrict,
    student_id     integer references users(id) on delete restrict,
    course_id      integer references courses(id) on delete restrict,
    start_time     bigint,
    end_time       bigint,
    tutor_notes    varchar(255) null,
    student_notes  varchar(255) null
);

create table date_events (
    date_id serial primary key,
    title varchar(150),
    start varchar(50),
    color varchar(50)
);

insert into date_events values (default, 'pancake making', '2021-08-08', 'blue');--1
insert into date_events values (default, 'meteor shower', '2021-08-12', 'red');  --2
insert into date_events values (default, 'blue moon', '2021-08-22', 'purple');   --3

insert into account_types values (default, 'Tutor Manager');--1
insert into account_types values (default, 'Tutor');        --2
insert into account_types values (default, 'Student');      --3

insert into schedules values
    (default, null, null, '07:00', '15:00', '07:00', '15:00', '07:00', '15:00', '07:00', '15:00', '07:00', '15:00', null, null, null),         --1 weekday morning manager
    (default, '10:00', '22:00', null, null, null, null, null, null, null, null, null, null, '10:00', '22:00', null),                           --2 weekend manager
    (default, null, null, '15:00', '23:00', '15:00', '23:00', '15:00', '23:00', '15:00', '23:00', '15:00', '23:00', null, null, null),         --3 weekday evening manager
    (default, null, null, '07:00', '11:00', '11:00', '15:00', '07:00', '11:00', '11:00', '15:00', '07:00', '11:00', null, null, null),         --4
    (default, null, null, '11:00', '15:00', '07:00', '11:00', '11:00', '15:00', '07:00', '11:00', '11:00', '15:00', null, null, null),         --5
    (default, null, null, '15:00', '19:00', '19:00', '23:00', '15:00', '19:00', '19:00', '23:00', '15:00', '19:00', null, null, null),         --6
    (default, null, null, '19:00', '23:00', '15:00', '19:00', '19:00', '23:00', '15:00', '19:00', '19:00', '23:00', null, null, null),         --7
    (default, '12:00', '20:00', null, null, null, null, null, null, null, null, null, null, '12:00', '20:00', null),                           --8
    (default, null, null, '19:00', '23:00', '19:00', '23:00', '19:00', '23:00', '19:00', '23:00', '19:00', '23:00', null, null, null),         --9
    (default, null, null, '15:00', '19:00', '15:00', '19:00', '15:00', '19:00', '15:00', '19:00', '15:00', '19:00', null, null, 1628187125123);--10 awaiting approval


insert into users values (default, 'Archibold', 'Moorhouse','amoorhouse0', 'amoorhouse0', '455-764-2236', 1, 1);    --1
insert into users values (default, 'Murielle', 'Arrundale', 'marrundale1', 'XANVv5IOWC0', '687-838-8250', 1, 2);--2
insert into users values (default, 'Law', 'Overel', 'loverel2', 'kLTq8k', '999-160-5044', 2, 4);                --3
insert into users values (default, 'Addie', 'Hurst', 'ahurst3', 'yQvDuW', '190-408-9564', 2, 5);                --4
insert into users values (default, 'Ax', 'McOrkill', 'amcorkill4', 'amcorkill4', '462-854-5968', 2, 6);          --5
insert into users values (default, 'Meade', 'Springall', 'mspringall5', 'NAnFQOzvR', '851-422-5573', 2, 7);     --6
insert into users values (default, 'Cynthy', 'Fullom', 'cfullom6', 'bP0WFUQ6g', '570-380-1292', 2, 8);          --7
insert into users values (default, 'Tina', 'Dymick', 'tdymick7', 'tdymick7', '560-285-5415', 3, null);            --8
insert into users values (default, 'Byrom', 'Parmeter', 'bparmeter8', 'ZRPbuOPy9k', '559-528-9800', 3, null);   --9
insert into users values (default, 'Tanitansy', 'Kleuer', 'tkleuer9', 'YeBlSsv0YoER', '671-981-4339', 3, null); --10
insert into users values (default, 'Lenore', 'Purple', 'lpurplea', 'UfqSYAJvx', '129-422-9435', 3, null);       --11
insert into users values (default, 'Winnah', 'Lathey', 'wlatheyb', 'suikHr6', '348-535-8149', 3, null);         --12
insert into users values (default, 'Kym', 'Gowthrop', 'kgowthropc', 'cTGgaE4aQ', '392-318-3644', 3, null);      --13
insert into users values (default, 'Vergil', 'Elleray', 'vellerayd', 'HeXJXSqJmz1G', '494-742-0215', 2, 9);     --14
insert into users values (default, 'Clayborne', 'Lind', 'clinde', 'cJo2yF1hFB', '589-352-9247', 2, 10);         --15
insert into users values (default, 'Theo', 'Orwell', 'torwellf', 'S2pH0dKe', '478-230-1653', 2, null);          --16
insert into users values (default, 'Alon', 'Treanor', 'atreanorg', 'HlWbj1GMmpIG', '569-637-6480', 3, null);    --17
insert into users values (default, 'Arda', 'Gouny', 'agounyh', 'eT22R0jV', '121-611-6851', 3, null);            --18
insert into users values (default, 'Germaine', 'Glanz', 'gglanzi', 'vWXAcnkZ6K1O', '283-898-8043', 3, null);    --19
insert into users values (default, 'Chen', 'McFetridge', 'cmcfetridgej', 'Myv7xVDs', '221-926-3593', 1, 3);     --20

insert into courses values
    (default, 'Composition I', 'ENGL', 1101, 3),   --1
    (default, 'Composition II', 'ENGL', 1102, 3),  --2
    
    (default, 'Quantitative Reasoning', 'MATH', 1001, 3),                  --3
    (default, 'Introduction to Mathematical Modeling', 'MATH', 1101, 3),   --4
    (default, 'College Algebra', 'MATH', 1111, 3),                         --5
    (default, 'Trigonometry', 'MATH', 1112, 3),                            --6
    (default, 'Precalculus', 'MATH', 1113, 3),                             --7
    (default, 'Elementary Statistics', 'MATH', 1401, 3),                   --8
    (default, 'Analytic Geometry and Calculus I', 'MATH', 2261, 4),        --9
    (default, 'Analytic Geometry and Calculus II', 'MATH', 2262, 4),       --10
    
    (default, 'World Literature I: The Ancient World', 'ENGL', 2111, 3),                   --11
    (default, 'World Literature II: The Age of Discovery', 'ENGL', 2112, 3),               --12
    (default, 'World Literature III: The Development of Modern Thought', 'ENGL', 2113, 3), --13
    
    (default, 'Introductory Physics I', 'PHYS', 1111, 4),  --14
    (default, 'Introductory Physics II', 'PHYS', 1112, 4), --15
    (default, 'Principles of Physics I', 'PHYS', 2211, 4), --16
    (default, 'Principles of Physics II', 'PHYS', 2212, 4);--17

insert into tutors_courses values 
    (3, 17),
    (3, 16),
    (3, 15),
    (3, 14),
    
    (4, 13),
    (4, 12),
    (4, 11),
    (4, 2),
    (4, 1),
    
    (5, 10),
    (5, 9),
    (5, 8),
    (5, 7),
    (5, 6),
    (5, 5),
    (5, 4),
    (5, 3),
    
    (6, 2),
    (6, 1),
    
    (7, 7),
    (7, 6),
    (7, 5),
    (7, 4),
    (7, 3),
    
    (14, 15),
    (14, 13),
    
    (15, 10),
    (15, 9),
    (15, 8),
    (15, 7),
    (15, 6),
    (15, 5),
    (15, 4),
    (15, 3),
    (15, 13),
    (15, 12),
    (15, 11),
    (15, 2),
    (15, 1),
    (15, 17),
    (15, 16),
    (15, 15),
    (15, 14),
    
    (16, 10),
    (16, 9),
    (16, 8),
    (16, 7),
    (16, 6),
    (16, 5),
    (16, 4),
    (16, 3),
    
    (1, 10),
    (1, 9),
    (1, 8),
    (1, 7),
    (1, 6),
    (1, 5),
    (1, 4),
    (1, 3),
    (1, 13),
    (1, 12),
    (1, 11),
    (1, 2),
    (1, 1),
    (1, 17),
    (1, 16),
    (1, 15),
    (1, 14),
    
    (2, 10),
    (2, 9),
    (2, 8),
    (2, 7),
    (2, 6),
    (2, 5),
    (2, 4),
    (2, 3),
    (2, 13),
    (2, 12),
    (2, 11),
    (2, 2),
    (2, 1),
    
    (20, 8),
    (20, 7),
    (20, 6),
    (20, 5),
    (20, 4),
    (20, 3),
    (20, 2),
    (20, 15),
    (20, 14);

insert into sessions values
    (default, 3, 8, 16, 1612890000000, 1612893600000, 'Tutored in STEM Physics 1. Kid did good.', 'Law is the best tutor!'),--1
    (default, 4, 9, 2, 1614694980000, 1614700800000, 'Byrom walked in today to get some help with his paper. Since I was free, I helped out until my shift was over.', null),--2
    (default, 7, 10, 7, 1617472800000, 1617476400000, 'Tanitansy needed some precalculus help.', 'Please fire this tutor!'),--3
    (default, 5, 9, 7, 1622642400000, 1622642400000, 'Byrom wanted help on his precalculus.', 'I think I get it now!'),     --4
    (default, 5, 11, 9, 1626102000000, 1626062400000, 'Lenore wanted to perfect her calculus', 'Ax is so smooth...'),       --5
    (default, 5, 12, 6, 1629864000000, 1629910800000, null, null);                                                          --6
