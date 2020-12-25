DROP DATABASE IF EXISTS oefpdo;

CREATE DATABASE oefpdo;

USE oefpdo;

CREATE TABLE werknemers
(
   id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
   name varchar(30) NOT NULL
);

INSERT INTO werknemers (`id`, `name`) VALUES
(1, 'Martin'),
(2, 'Feynman'),
(3, 'Graves');
