drop table if exists t_member;

create table t_member (
	userid varchar(50) primary key,
    userpw varchar(50) not null,
    username varchar(50) not null,
    email varchar(100),
    regdate timestamp default now(),
    updatedate timestamp default now()
);