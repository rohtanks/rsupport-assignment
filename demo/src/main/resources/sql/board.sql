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
insert into t_board (title, content, writer) 
values ('test title2', 'test content2', 'tester2');
insert into t_board (title, content, writer) 
values ('테스트 제목', '테스트 내용', '테스트 작가');

insert into t_board (title, content, writer)
(select title, content, writer from t_board);
insert into t_board (title, content, writer)
(select title, content, writer from t_board);
insert into t_board (title, content, writer)
(select title, content, writer from t_board);
insert into t_board (title, content, writer)
(select title, content, writer from t_board);
insert into t_board (title, content, writer)
(select title, content, writer from t_board);
