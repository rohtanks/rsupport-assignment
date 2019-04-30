drop table if exists t_authority;

create table t_authority (
	userid varchar(50),
    authority_name varchar(20)
);

insert into t_authority(userid, authority_name) 
values('ahram1', 'ADMIN');
insert into t_authority(userid, authority_name) 
values('ahram1', 'USER');
insert into t_authority(userid, authority_name) 
values('ahram2', 'USER');
