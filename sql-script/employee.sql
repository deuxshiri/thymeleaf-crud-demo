CREATE DATABASE IF NOT EXISTS `employee_directory`;

USE `employee_directory`;

--
-- Table structure for the table `employee`
--

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee`
(
    `id`         int(11) NOT NULL AUTO_INCREMENT,
    `first_name` varchar(45) DEFAULT NULL,
    `last_name`  varchar(45) DEFAULT NULL,
    `email`      varchar(45) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = latin1;

--
-- Data for the table `employee`
--

INSERT INTO `employee`
VALUES (1, 'Sina', 'Deuxshiri', 'deuxshiri@gmail.com'),
       (2, 'Bill', 'Gates', 'gates@outlook.com'),
       (3, 'Steve', 'Jobs', 'jobs@apple.com'),
       (4, 'Larry', 'Ellison', 'ellison@oracle.com'),
       (5, 'Jony', 'Ive', 'ive@apple.com');
