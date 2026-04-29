-- create the database of spring_patientappointment_db
create database spring_patientappointment_db;

-- use the database of spring_patientappointment_db
use spring_patientappointment_db;

-- create the table of patient_tb
create table patient_tb (
	patient_id varchar(4) primary key not null,
    patient_name varchar(255) not null,
    patient_gender varchar(10) not null,
    patient_age int(3) not null,
    patient_address varchar(355) not null,
    date_time timestamp default current_timestamp
);

-- create the table of doctor_tb
create table doctor_tb (
	doctor_id varchar(4) primary key not null,
    doctor_name varchar(255) not null,
    doctor_gender varchar(10) not null,
    specialization varchar(50) not null
);

-- create the table of appointment_tb
create table appointment_tb (
	appointment_id varchar(4) primary key not null,
    patient_id varchar(4) not null, foreign key(patient_id) references patient_tb(patient_id),
    doctor_id varchar(4) not null, foreign key(doctor_id) references doctor_tb(doctor_id),
    appointment_date_time datetime not null
);

-- insert into data of doctors (already present)
insert into doctor_tb (doctor_id, doctor_name, doctor_gender, specialization) values
('D101', 'Dr. Amit Sharma', 'Male', 'Cardiologist'),
('D102', 'Dr. Priya Verma', 'Female', 'Dermatologist'),
('D103', 'Dr. Rajesh Kumar', 'Male', 'Neurologist'),
('D104', 'Dr. Sneha Patel', 'Female', 'Pediatrician'),
('D105', 'Dr. Vikram Singh', 'Male', 'Orthopedic Surgeon'),
('D106', 'Dr. Neha Joshi', 'Female', 'Gynecologist'),
('D107', 'Dr. Arjun Mehta', 'Male', 'Ophthalmologist'),
('D108', 'Dr. Kavita Rao', 'Female', 'Psychiatrist');


-- retrieve the patient_tb
select * from patient_tb;

-- retrive the doctor_tb
select * from doctor_tb;

-- retrive the appointment_tb
select * from appointment_tb;