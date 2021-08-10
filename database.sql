
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
	username		varchar(255) unique,
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
	student_notes	varchar(255) null,
	tutor_notes		varchar(255) null
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

insert into users values (1, 'Archibold', 'Moorhouse', 'amoorhouse0', 'AvF4qVJ', '455-764-2236', 1);
insert into users values (2, 'Murielle', 'Arrundale', 'marrundale1', 'XANVv5IOWC0', '687-838-8250', 1);
insert into users values (3, 'Law', 'Overel', 'loverel2', 'kLTq8k', '999-160-5044', 2);
insert into users values (4, 'Addie', 'Hurst', 'ahurst3', 'yQvDuW', '190-408-9564', 2);
insert into users values (5, 'Ax', 'McOrkill', 'amcorkill4', 'Y4nj627QP', '462-854-5968', 2);
insert into users values (6, 'Meade', 'Springall', 'mspringall5', 'NAnFQOzvR', '851-422-5573', 2);
insert into users values (7, 'Cynthy', 'Fullom', 'cfullom6', 'bP0WFUQ6g', '570-380-1292', 2);
insert into users values (8, 'Tina', 'Dymick', 'tdymick7', 'bqm4f4', '560-285-5415', 3);
insert into users values (9, 'Byrom', 'Parmeter', 'bparmeter8', 'ZRPbuOPy9k', '559-528-9800', 3);
insert into users values (10, 'Tanitansy', 'Kleuer', 'tkleuer9', 'YeBlSsv0YoER', '671-981-4339', 3);
insert into users values (11, 'Lenore', 'Purple', 'lpurplea', 'UfqSYAJvx', '129-422-9435', 3);
insert into users values (12, 'Winnah', 'Lathey', 'wlatheyb', 'suikHr6', '348-535-8149', 3);
insert into users values (13, 'Kym', 'Gowthrop', 'kgowthropc', 'cTGgaE4aQ', '392-318-3644', 3);
insert into users values (14, 'Vergil', 'Elleray', 'vellerayd', 'HeXJXSqJmz1G', '494-742-0215', 2);
insert into users values (15, 'Clayborne', 'Lind', 'clinde', 'cJo2yF1hFB', '589-352-9247', 2);
insert into users values (16, 'Theo', 'Orwell', 'torwellf', 'S2pH0dKe', '478-230-1653', 3);
insert into users values (17, 'Alon', 'Treanor', 'atreanorg', 'HlWbj1GMmpIG', '569-637-6480', 3);
insert into users values (18, 'Arda', 'Gouny', 'agounyh', 'eT22R0jV', '121-611-6851', 3);
insert into users values (19, 'Germaine', 'Glanz', 'gglanzi', 'vWXAcnkZ6K1O', '283-898-8043', 3);
insert into users values (20, 'Chen', 'McFetridge', 'cmcfetridgej', 'Myv7xVDs', '221-926-3593', 3);

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
	