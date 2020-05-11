/* Create schema and table */
CREATE DATABASE IF NOT EXISTS `trainermvc`;
USE `trainermvc`;

CREATE TABLE `trainers` (
    `id` BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `first_name` VARCHAR(25) NOT NULL,
    `last_name` VARCHAR(25) NOT NULL,
    `subject` VARCHAR(25) NOT NULL
);

/* Populate table */
INSERT INTO `trainers`(`first_name`,`last_name`,`subject`) VALUES('DIMITRIS','NIKOLAOU', 'JAVA');
INSERT INTO `trainers`(`first_name`,`last_name`,`subject`) VALUES('MICHALIS','PAPADOPOULOS', 'RUBY');
INSERT INTO `trainers`(`first_name`,`last_name`,`subject`) VALUES('GEORGE','PAPACHRISTOU', 'C++');
INSERT INTO `trainers`(`first_name`,`last_name`,`subject`) VALUES('JOHN','VASILOPOULOS', 'KOTLIN');