
alter table if exists users drop constraint users_account_type_id_fkey;
alter table if exists sessions drop constraint sessions_tutor_id_fkey;
alter table if exists sessions drop constraint sessions_student_id_fkey;
alter table if exists sessions drop constraint sessions_course_id_fkey;
alter table if exists tutors_courses drop constraint tutors_courses_tutor_id_fkey;
alter table if exists tutors_courses drop constraint tutors_courses_course_id_fkey;

drop table if exists schedules;
drop table if exists account_types;
drop table if exists courses;
drop table if exists users;
drop table if exists sessions;
drop table if exists tutors_courses;

create table account_types (
	id			serial primary key,
	type		varchar(50)
);

create table users (
	id				serial primary key,
	first_name		varchar(255),
	last_name		varchar(255),
	user_name		varchar(255),
	school_email	varchar(255) unique,
	password		varchar(255),
	phone_number	varchar(255) null,
	account_type_id	integer references account_types(id) on delete restrict
);

create table courses (
	id			serial primary key,
	name		varchar(255),
	subject		varchar(4),
	level		integer,
	hours		int
);

create table tutors_courses (
	tutor_id	integer references users(id) on delete restrict,
	course_id	integer references courses(id) on delete restrict,
	primary key (tutor_id, course_id)
);

create table schedules (
	tutor_id				integer primary key references users(id) on delete set null,
	sunday_start			time null,
	sunday_end				time null,
	monday_start			time null,
	monday_end				time null,
	tuesday_start			time null,
	tuesday_end				time null,
	wednesday_start			time null,
	wednesday_end			time null,
	thursday_start			time null,
	thursday_end			time null,
	friday_start			time null,
	friday_end				time null,
	saturday_start			time null,
	saturday_end			time null,
	pending_approval_since	bigint null
);

create table sessions (
	id				serial primary key,
	tutor_id		integer references users(id) on delete restrict,
	student_id		integer references users(id) on delete restrict,
	course_id		integer references courses(id) on delete restrict,
	start_time		bigint,
	end_time		bigint,
	tutor_notes		varchar(255) null,
	student_notes	varchar(255) null
);

drop table date_events cascade;
create table date_events (
	date_id serial primary key,
	title varchar(150),
	date varchar(50)
);

insert into date_events values (default, 'pancake making', '2021/08/08');
insert into date_events values (default, 'meteor shower', '2021/08/12');
insert into date_events values (default, 'blue moon', '2021/08/22');

insert into account_types values (1, 'Tutor Manager');
insert into account_types values (2, 'Tutor');
insert into account_types values (3, 'Student');

insert into users values (1, 'Archibold', 'Moorhouse', 'ahouse','amoorhouse0', 'AvF4qVJ', '455-764-2236', 1);
insert into users values (2, 'Murielle', 'Arrundale',  'marrundale','marrundale1', 'XANVv5IOWC0', '687-838-8250', 1);
insert into users values (3, 'Law', 'Overel',  'loverel','loverel2', 'kLTq8k', '999-160-5044', 2);
insert into users values (4, 'Addie', 'Hurst',  'ahurst','ahurst3', 'yQvDuW', '190-408-9564', 2);
insert into users values (5, 'Ax', 'McOrkill',  'amcorkill','amcorkill4', 'Y4nj627QP', '462-854-5968', 2);
insert into users values (6, 'Meade', 'Springall',  'mspringall','mspringall5', 'NAnFQOzvR', '851-422-5573', 2);
insert into users values (7, 'Cynthy', 'Fullom',  'cfullom','cfullom6', 'bP0WFUQ6g', '570-380-1292', 2);
insert into users values (8, 'Tina', 'Dymick',  'tdymick','tdymick7', 'bqm4f4', '560-285-5415', 3);
insert into users values (9, 'Byrom', 'Parmeter',  'bparmeter','bparmeter8', 'ZRPbuOPy9k', '559-528-9800', 3);
insert into users values (10, 'Tanitansy', 'Kleuer',  'tkleuer','tkleuer9', 'YeBlSsv0YoER', '671-981-4339', 3);
insert into users values (11, 'Lenore', 'Purple',  'lpurple','lpurplea', 'UfqSYAJvx', '129-422-9435', 3);
insert into users values (12, 'Winnah', 'Lathey',  'wlathey','wlatheyb', 'suikHr6', '348-535-8149', 3);
insert into users values (13, 'Kym', 'Gowthrop',  'kgowthrop','kgowthropc', 'cTGgaE4aQ', '392-318-3644', 3);
insert into users values (14, 'Vergil', 'Elleray',  'velleray','vellerayd', 'HeXJXSqJmz1G', '494-742-0215', 2);
insert into users values (15, 'Clayborne', 'Lind',  'clind','clinde', 'cJo2yF1hFB', '589-352-9247', 2);
insert into users values (16, 'Theo', 'Orwell',  'torwell','torwellf', 'S2pH0dKe', '478-230-1653', 2);
insert into users values (17, 'Alon', 'Treanor',  'atreanor','atreanorg', 'HlWbj1GMmpIG', '569-637-6480', 3);
insert into users values (18, 'Arda', 'Gouny',  'agouny','agounyh', 'eT22R0jV', '121-611-6851', 3);
insert into users values (19, 'Germaine', 'Glanz',  'gglanz','gglanzi', 'vWXAcnkZ6K1O', '283-898-8043', 3);
insert into users values (20, 'Chen', 'McFetridge',  'cmcfetridge','cmcfetridgej', 'Myv7xVDs', '221-926-3593', 1);

insert into courses values
	(1, 'Composition I', 'ENGL', 1101, 3),
	(2, 'Composition II', 'ENGL', 1102, 3),
	
	(3, 'Quantitative Reasoning', 'MATH', 1001, 3),
	(4, 'Introduction to Mathematical Modeling', 'MATH', 1101, 3),
	(5, 'College Algebra', 'MATH', 1111, 3),
	(6, 'Trigonometry', 'MATH', 1112, 3),
	(7, 'Precalculus', 'MATH', 1113, 3),
	(8, 'Elementary Statistics', 'MATH', 1401, 3),
	(9, 'Analytic Geometry and Calculus I', 'MATH', 2261, 4),
	(10, 'Analytic Geometry and Calculus II', 'MATH', 2262, 4),
	
	(11, 'World Literature I: The Ancient World', 'ENGL', 2111, 3),
	(12, 'World Literature II: The Age of Discovery', 'ENGL', 2112, 3),
	(13, 'World Literature III: The Development of Modern Thought', 'ENGL', 2113, 3),
	
	(14, 'Introductory Physics I', 'PHYS', 1111, 4),
	(15, 'Introductory Physics II', 'PHYS', 1112, 4),
	(16, 'Principles of Physics I', 'PHYS', 2211, 4),
	(17, 'Principles of Physics II', 'PHYS', 2212, 4);
	
-- The course listed means that the tutor knows that course and any levels below
insert into tutors_courses values 
	(3, 17),
	(4, 13),
	(5, 10),
	(6, 2),
	(7, 7),
	(14, 15),
	(15, 10),
	(15, 13),
	(15, 17),
	(16, 10),
	(1, 10),
	(1, 13),
	(1, 17),
	(2, 10),
	(2, 13),
	(20, 8),
	(20, 2),
	(20, 15);

insert into schedules values
	(1, null, null, '07:00', '15:00', '07:00', '15:00', '07:00', '15:00', '07:00', '15:00', '07:00', '15:00', null, null, null), --weekday morning manager
	(2, '10:00', '22:00', null, null, null, null, null, null, null, null, null, null, '10:00', '22:00', null), --weekend manager
	(20, null, null, '15:00', '23:00', '15:00', '23:00', '15:00', '23:00', '15:00', '23:00', '15:00', '23:00', null, null, null), --weekday evening manager
	(3, null, null, '07:00', '11:00', '11:00', '15:00', '07:00', '11:00', '11:00', '15:00', '07:00', '11:00', null, null, null),
	(4, null, null, '11:00', '15:00', '07:00', '11:00', '11:00', '15:00', '07:00', '11:00', '11:00', '15:00', null, null, null),
	(5, null, null, '15:00', '19:00', '19:00', '23:00', '15:00', '19:00', '19:00', '23:00', '15:00', '19:00', null, null, null),
	(6, null, null, '19:00', '23:00', '15:00', '19:00', '19:00', '23:00', '15:00', '19:00', '19:00', '23:00', null, null, null),
	(7, '12:00', '20:00', null, null, null, null, null, null, null, null, null, null, '12:00', '20:00', null),
	(14, null, null, '19:00', '23:00', '19:00', '23:00', '19:00', '23:00', '19:00', '23:00', '19:00', '23:00', null, null, null),
	(15, null, null, '15:00', '19:00', '15:00', '19:00', '15:00', '19:00', '15:00', '19:00', '15:00', '19:00', null, null, 1628187125123), --awaiting approval
	(16, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null); --no longer working

insert into sessions values
	(1, 3, 8, 16, 1612890000000, 1612893600000, 'Tutored in STEM Physics 1. Kid did good.', 'Law is the best tutor!'),
	(2, 4, 9, 2, 1614694980000, 1614700800000, 'Byrom walked in today to get some help with his paper. Since I was free, I helped out until my shift was over.', null),
	(3, 7, 10, 7, 1617472800000, 1617476400000, 'Tanitansy needed some precalculus help.', 'Please fire this tutor!');

