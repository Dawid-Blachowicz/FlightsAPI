alter table if exists users_favourite_departures drop constraint if exists FK9iawn03goo6nqsnny8fcv5q60
drop table if exists token cascade
drop table if exists users cascade
drop table if exists users_favourite_departures cascade
drop sequence if exists users_seq
create sequence users_seq start with 1 increment by 50
create table token (is_used boolean not null, exp_date timestamp(6), id bigserial not null, email varchar(255), value varchar(255), primary key (id))
create table users (is_enabled boolean not null, id bigint not null, email varchar(255) not null unique, first_name varchar(255) not null, last_name varchar(255) not null, password varchar(255) not null, primary key (id))
create table users_favourite_departures (users_id bigint not null, favourite_departures varchar(255))
alter table if exists users_favourite_departures add constraint FK9iawn03goo6nqsnny8fcv5q60 foreign key (users_id) references users