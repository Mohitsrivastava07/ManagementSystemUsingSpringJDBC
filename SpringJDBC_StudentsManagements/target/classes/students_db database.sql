-- createing the database of name of students_db
create database students_db;

-- use as name of students_db
use students_db;

-- creating the table of regardings to input the students infoormation for students_db database
create table student_tb (
	kid varchar(6) not null primary key,
    name varchar(255) not null,
    course varchar(100) not null,
	semester int(2) not null,
    address varchar(255) not null,
    create_at timestamp default current_timestamp
);

-- retrieve the datasets of students_db
select * from student_tb;