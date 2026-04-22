-- creating the database of spring_faculty
create database spring_faculty;

-- use the database of spring_faculty
use spring_faculty;

-- creating the table of faculty_tb
create table faculty_tb (
	fid varchar(6) primary key not null,
    faculty_name varchar(255) not null,
    email_id varchar(355) unique not null,
    room_number varchar(4) not null,
    which_month varchar(20) not null,
    date_time timestamp default current_timestamp
);

-- retrieve the table of faculty_tb
select * from faculty_tb;