drop database if exists stu_exm;
create database stu_exm default charset utf8mb4;

use stu_exm;

create table stu (
                     id int primary key auto_increment,
                     name varchar(80)
);
create table course (
                        id int primary key auto_increment,
                        name varchar(80)
);
create table score (
                       id int primary key auto_increment,
                       score decimal(4,1),  -- 150分以下，1位小数。（总长度，小数长度）
                       stu_id int ,
                       course_id int,
                       foreign key (stu_id) references stu(id),
                       foreign key (course_id) references  course(id)
);

insert into stu(name) value ('卡卡');
insert into course (name) values ('英语');
insert into score(score, stu_id, course_id) values (100,1,1);
insert into score(score, stu_id, course_id) values (122,1,1);
insert into score(score, stu_id, course_id) values (141,1,1);
insert into score(score, stu_id, course_id) values (163,1,1);
