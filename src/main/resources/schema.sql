create database if not exists academic_erp;

use academic_erp;

create table if not exists employee (
    employee_id bigint auto_increment primary key,
    first_name varchar(30) not null,
    last_name varchar(30),
    email varchar(255) unique not null,
    department_id bigint not null,
    password varchar(255) not null
);

create table if not exists organisation (
    id bigint auto_increment primary key,
    name varchar(255) not null,
    address varchar(255)
);

create table if not exists domain (
    id bigint auto_increment primary key,
    name varchar(255) not null
);

create table if not exists specialisation (
    id bigint auto_increment primary key,
    code varchar(50) not null,
    name varchar(255) not null,
    description text,
    cred_required double
);

create table if not exists placement (
     id bigint auto_increment primary key,
     organisation_id bigint not null,
     profile varchar(255),
     description text,
     min_grade decimal(3, 2),
     intake int
);

create table if not exists placement_domain (
    id bigint auto_increment primary key,
    placement_id bigint not null,
    domain_id bigint not null
);

create table if not exists placement_specialisation (
    id bigint auto_increment primary key,
    placement_id bigint not null,
    specialisation_id bigint not null
);
