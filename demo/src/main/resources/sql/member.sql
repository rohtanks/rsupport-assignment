drop table if exists t_member;

create table t_member (
	userid varchar(50) primary key,
    userpw varchar(50) not null,
    username varchar(50) not null,
    email varchar(100),
    regdate timestamp default now(),
    upddate timestamp default now()
);

insert into t_member(userid, userpw, username, email) 
values('ahram1', 'pw111', 'ahram', 'ahram1@naver.com');
insert into t_member(userid, userpw, username, email) 
values('ahram2', 'pw222', '아람', 'ahram2@naver.com');