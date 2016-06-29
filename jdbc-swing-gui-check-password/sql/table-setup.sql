create database if not exists demo;

use demo;

drop table if exists audit_history;
drop table if exists employees;
drop table if exists users;

CREATE TABLE `employees` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `last_name` varchar(64) DEFAULT NULL,
  `first_name` varchar(64) DEFAULT NULL,
  `email` varchar(64) DEFAULT NULL,
  `department` varchar(64) DEFAULT NULL,
  `salary` DECIMAL(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `last_name` varchar(64) DEFAULT NULL,
  `first_name` varchar(64) DEFAULT NULL,
  `email` varchar(64) DEFAULT NULL,
  `password` varchar(256) DEFAULT NULL,
  `is_admin` tinyint DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE `audit_history` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `employee_id` int(11) NOT NULL,
  `action` varchar(128) DEFAULT NULL,
  `action_date_time` timestamp,
  PRIMARY KEY (`id`),
  FOREIGN KEY (user_id) REFERENCES  users(id),
  FOREIGN KEY (employee_id) REFERENCES  employees(id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO `employees` (`id`,`last_name`,`first_name`,`email`, `department`, `salary`) VALUES (1,'Doe','John','john.doe@foo.com', 'HR', 55000.00);
INSERT INTO `employees` (`id`,`last_name`,`first_name`,`email`, `department`, `salary`) VALUES (2,'Public','Mary','mary.public@foo.com', 'Engineering', 75000.00);
INSERT INTO `employees` (`id`,`last_name`,`first_name`,`email`, `department`, `salary`) VALUES (3,'Queue','Susan','susan.queue@foo.com', 'Legal', 130000.00);

INSERT INTO `employees` (`id`,`last_name`,`first_name`,`email`, `department`, `salary`) VALUES (4,'Williams','David','david.williams@foo.com', 'HR', 120000.00);
INSERT INTO `employees` (`id`,`last_name`,`first_name`,`email`, `department`, `salary`) VALUES (5,'Johnson','Lisa','lisa.johnson@foo.com', 'Engineering', 50000.00);
INSERT INTO `employees` (`id`,`last_name`,`first_name`,`email`, `department`, `salary`) VALUES (6,'Smith','Paul','paul.smith@foo.com', 'Legal', 100000.00);

INSERT INTO `employees` (`id`,`last_name`,`first_name`,`email`, `department`, `salary`) VALUES (7,'Adams','Carl','carl.adams@foo.com', 'HR', 50000.00);
INSERT INTO `employees` (`id`,`last_name`,`first_name`,`email`, `department`, `salary`) VALUES (8,'Brown','Bill','bill.brown@foo.com', 'Engineering', 50000.00);
INSERT INTO `employees` (`id`,`last_name`,`first_name`,`email`, `department`, `salary`) VALUES (9,'Thomas','Susan','susan.thomas@foo.com', 'Legal', 80000.00);

INSERT INTO `employees` (`id`,`last_name`,`first_name`,`email`, `department`, `salary`) VALUES (10,'Davis','John','john.davis@foo.com', 'HR', 45000.00);
INSERT INTO `employees` (`id`,`last_name`,`first_name`,`email`, `department`, `salary`) VALUES (11,'Fowler','Mary','mary.fowler@foo.com', 'Engineering', 65000.00);
INSERT INTO `employees` (`id`,`last_name`,`first_name`,`email`, `department`, `salary`) VALUES (12,'Waters','David','david.waters@foo.com', 'Legal', 90000.00);

INSERT INTO `users` (`id`,`last_name`,`first_name`,`email`,`password`,`is_admin`) VALUES (1,'Alpha','Joe','joe.alpha@foo.com','k4AXDX87vLHmzXC18klyPqt84vp6HlrPd+cnU4IggndUq8Vrikonz/pbdrXQUJlz',0);
INSERT INTO `users` (`id`,`last_name`,`first_name`,`email`,`password`,`is_admin`) VALUES (2,'Beta','Jane','jane.beta@foo.com','X70IvzjITvoh76FV2gBXPdnt6hYr6KgUoTm+fJcrhlGWpNigYQRY8Ql/+lI/rcdx',0);
INSERT INTO `users` (`id`,`last_name`,`first_name`,`email`,`password`,`is_admin`) VALUES (3,'Zeta','Becky','becky.zeta@foo.com','zO3IE+Yb23RpGiYWeSHkZzKVu0YXQ0/pY0omSWIyi1SexPuuEpdDxl2nlDerx2TM',0);
INSERT INTO `users` (`id`,`last_name`,`first_name`,`email`,`password`,`is_admin`) VALUES (4,'Charlie','Admin','charlie.admin@foo.com','C9VcMJhFKQCiK9WHQ2cM0DxbuRbpHt2o5/K8078ci5XQGkGg/Zfv5HCpG6wGwrR1',1);
INSERT INTO `users` (`id`,`last_name`,`first_name`,`email`,`password`,`is_admin`) VALUES (5,'Miracles','Percy','percy@foo.com','7LhDtE2xbCJHKcvH80XpSKUolWnlC0SokdX83ZiBfHSP7xHwTKm6KLwmxQeiXvvV',1);
