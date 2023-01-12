create database EventPlanner;
use EventPlanner;

create table `Admin-Table`(
`id` int auto_increment primary key,
`Full Name` text,
`Email` varchar(30),
`Gender` varchar(10),
`Password` varchar(10)
);

create table `Customer-Table`(
`id` int auto_increment primary key,
`Full Name` text,
`Email` varchar(30),
`Gender` varchar(10),
`Password` varchar(10));

create table `Event-Table`(
`id` int auto_increment primary key,
`Name` text,
`Address` text,
`No. of people` int,
`Price per hour` int,
`Phone Number` varchar(15),
`Picture` blob,
`Total-Price` int
);

create table `Dj-Table`(
`id` int auto_increment primary key,
`Name` text,
`Address` text,
`Price per hour` int,
`Phone Number` varchar(15),
`Picture` blob,
`Total-Price` int
);

create table `Food-Table`(
`id` int auto_increment primary key,
`Name` text,
`Address` text,
`Phone Number` varchar(15),
`Picture` blob
);

create table `card`(
`id` int auto_increment primary key,
`Event-center-id` int references `Event-Table`(`id`),
`Dj-id` int references `Dj-Table`(`id`),
`Food-id` int references `Food-Table`(`id`) ,
`Total` int
);
