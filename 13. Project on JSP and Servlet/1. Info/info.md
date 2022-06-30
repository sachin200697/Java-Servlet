## Tables:
-----------

## User: 
create table user(id int(20) primary key auto_increment, name varchar(500) not null, email varchar(500) not null, password varchar(20) not null, gender varchar(10) not null, about varchar(1000) default "hey! I am using SacBlock");

alter table user add rdate timestamp default now();

alter table user add profile varchar(100) default 'default.png';


## Categories:
create table categories(cid int(12) primary key auto_increment, name varchar(100) not null, description varchar(200) );

## Posts:
create table posts(pid int(12) primary key not null auto_increment, title varchar(150) not null, content longtext, code longtext, pic varchar(100), date timestamp default now(), catid int(12), foreign key (catid) references categories(cid));

alter table posts add foreign key(userid) references user(id) on delete cascade;

## likes:
create table likes(lid int(12) primary key auto_increment not null, pid int(12), uid int(12), foreign key(pid) references posts(pid) on delete cascade, foreign key(uid) references user(id) on delete cascade);





## For image in the form:
We need to tell that we are sending mix data(images and text):
In form: 
<form enctype="multipart/form-data">

In servlet: @MultipartConfig    (annotation on the class: import javax.servlet.annotation.MultipartConfig;)

