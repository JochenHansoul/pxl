DROP DATABASE IF EXISTS oefpdo;

CREATE DATABASE oefpdo;

GRANT ALL PRIVILEGES ON oefpdo.* TO student@localhost;

USE oefpdo;

CREATE TABLE user (
    PRIMARY KEY (user_id),
    user_id int         AUTO_INCREMENT,
    name    varchar(30) NOT NULL
);

INSERT INTO user (user_id, name)
VALUES  (1, 'Martin'),
        (2, 'Feynman'),
        (3, 'Graves');
