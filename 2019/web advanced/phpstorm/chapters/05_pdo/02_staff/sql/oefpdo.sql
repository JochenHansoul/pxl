DROP DATABASE IF EXISTS oefpdo;

CREATE DATABASE oefpdo;

GRANT ALL PRIVILEGES ON oefpdo.* TO student@localhost;

USE oefpdo;

CREATE TABLE staff (
    PRIMARY KEY (user_id),
    user_id int(5)      AUTO_INCREMENT,
    name    varchar(30) NOT NULL
);

INSERT INTO staff (user_id, name)
VALUES  (1, 'Martin'),
        (2, 'Feynman'),
        (3, 'Graves');
