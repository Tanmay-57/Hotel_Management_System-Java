create database hotelmanagementsystem;

use hotelmanagementsystem;

create table login(username varchar(25) , password varchar(25));

insert into login values('admin' , '12345');

select * from login;

create table employee(name varchar(25),age varchar(100),gender varchar(15),job varchar(30),salary varchar(15),phone varchar(15),email varchar(40));

describe employee;

select * from employee;

create table room(roomnumber varchar(10), availability varchar(20), cleaning_status varchar(20), price varchar(20), bed_type varchar(20));

select * from room;

create table customer(document varchar(20), number varchar(10), name varchar(30), gender varchar(15), room varchar(10), checkintime varchar(80), deposit varchar(20));

select * from customer;