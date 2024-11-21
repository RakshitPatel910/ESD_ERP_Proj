
create database if not exists academic_erp;

use academic_erp;

create table if not exists organisation(
    id bigint auto_increment primary key,
    name varchar(255) not null,
    address varchar(255)
);

create table if not exists domain(
    id bigint auto_increment primary key,
    name varchar(255) not null
);

create table if not exists specialisation(
    id bigint auto_increment primary key,
    code varchar(50) not null,
    name varchar(255) not null,
    description text,
    cred_required double
);

create table if not exists placement(
    id bigint auto_increment primary key,
    organisation_id bigint not null,
    profile varchar(255),
    description text,
    min_grade decimal(3, 2),
    intake int,
    foreign key (organisation_id) references organisation(id) on delete cascade
);

create table if not exists placement_domain(
    id bigint auto_increment primary key,
    placement_id bigint not null,
    domain_id bigint not null,
    foreign key (placement_id) references placement(id) on delete cascade,
    foreign key (domain_id) references domain(id) on delete cascade
);

create table if not exists placement_specialisation(
    id bigint auto_increment primary key,
    placement_id bigint not null,
    specialisation_id bigint not null,
    foreign key (placement_id) references placement(id) on delete cascade,
    foreign key (specialisation_id) references specialisation(id) on delete cascade
)

