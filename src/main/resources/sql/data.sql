drop database if exists `test`;
create database `test` default char set utf8mb4;

use `test`;

drop table if exists `student`;
create table `student`
(
    `id`   int auto_increment comment '学生主键',
    `name` varchar(10) not null comment '学生姓名',
    `gender` char default '男' comment '性别',
    `age`  int comment '学生年龄',
    `address` varchar(30) comment '家庭地址',
    `telephone` varchar(15) comment '电话号码',
    primary key (`id`)
)ENGINE = Innodb character set utf8mb4 comment '学生表';

drop table if exists `teacher`;
create table `teacher`
(
    `id`   int auto_increment comment '教师主键',
    `name` varchar(10) not null comment '教师姓名',
    `gender` char default '男' comment '性别',
    `age`  int comment '教师年龄',
    `address` varchar(30) comment '家庭地址',
    `telephone` varchar(15) comment '电话号码',
    primary key (`id`)
)ENGINE = Innodb character set utf8mb4 comment '教师表';

drop table if exists `course`;
create table `course`
(
    `id`   int auto_increment comment '课程主键',
    `name` varchar(10) not null comment '课程名',
    `teacher_id` int comment '发布课程教师id',
    primary key (`id`)
)ENGINE = Innodb character set utf8mb4 comment '课程表';


drop table if exists `student_course`;
create table `student_course`
(
    `id`   int auto_increment comment '学生选课表主键',
    `student_id` int not null comment '学生主键id',
    `course_id` int comment '课程id',
    `score` int comment '分数',
    primary key (`id`)
)ENGINE = Innodb character set utf8mb4 comment '学生选课表';


insert into `course` (id, name, teacher_id)
values  (1, 'C语言程序设计', 1),
        (2, 'java程序设计', 2),
        (3, '数据结构与算法分析', 3),
        (4, '高等数学', 4),
        (5, '大学英语1', 5),
        (6, '思修', 6);


insert into `student` (id, name, gender, age, address, telephone)
values  (1, 'jack', '男', 18, '上海', '15551338933'),
        (2, 'mary', '女', 17, '北京', '15551338933'),
        (3, 'tom', '男', 18, '武汉', '15551338933'),
        (4, 'lucy', '女', 16, '杭州', '15551338933'),
        (5, 'bob', '男', 19, '广州', '15551338933'),
        (6, 'jackson', '男', 19, '南京', '15551338933');


insert into `student_course` (id, student_id, course_id, score)
values  (1, 1, 3, 98),
        (2, 2, 2, 89),
        (3, 3, 1, 79),
        (4, 4, 4, 89),
        (5, 5, 5, 98),
        (6, 6, 6, 95);


insert into `teacher` (id, name, gender, age, address, telephone)
values  (1, 'hello', '男', 35, '上海', '15551338933'),
        (2, 'world', '女', 32, '北京', '15551338933'),
        (3, 'java', '男', 30, '武汉', '15551338933'),
        (4, 'Golang', '女', 28, '南京', '15551338933'),
        (5, 'PHP', '男', 29, '杭州', '15551338933'),
        (6, 'Javascript', '男', 38, '厦门', '15551338933');