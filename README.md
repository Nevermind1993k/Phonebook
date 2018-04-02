**Phone Book project**

Java application for storing phone contacts.

**To start it you will need to:**
1. Have MySQL server installed on your machine
2. Manually create database 'dataDb' and set up credentials for DB (by default used 'root'-'root')
3. Specify path to properties in PhoneBookApplication.class
4. Run SpringBoot in PhoneBookApplication.class.

**Queary for application :**

create table user (
id int auto_increment,
username varchar(255) not null unique,
password varchar(255) not null,
first_name varchar (255) not null,
last_name varchar(255) not null,
middle_name varchar(255) not null,
primary key (id));

create table contact (
id int auto_increment,
first_name varchar (255) not null,
last_name varchar(255) not null,
middle_name varchar(255) not null,
mobile_phone_number varchar(255) not null,
home_phone_number varchar(255),
address varchar(255),
email varchar(255),
user_id int,
primary key(id),
foreign key (user_id) references user(id) );
