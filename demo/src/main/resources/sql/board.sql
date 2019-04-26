drop table if exists t_board;

create table t_board (
	bno int unsigned not null auto_increment primary key,
    title varchar(200) not null,
    content text null,
    writer varchar(50) not null,
    regdate timestamp not null default now(),
    upddate timestamp not null default now() on update now(),
    viewcnt int default 0
);

insert into t_board (title, content, writer) 
values ('test title', 'test content', 'tester');
