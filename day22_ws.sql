create database day22_ws;
use day22_ws;

create table rsvp (
	id int auto_increment not null,
	fullname varchar(50) not null,
    email varchar(50) not null,
    phone varchar(30) not null,
    confirmation_date date not null,
    comments text not null,
    constraint pk_id primary key(id)
);

select * from rsvp;
select count(distinct fullname) from rsvp;

    