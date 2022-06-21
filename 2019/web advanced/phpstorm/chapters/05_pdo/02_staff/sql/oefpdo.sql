-- deleting data
DROP DATABASE IF EXISTS oef_pdo;

DROP USER IF EXISTS 'oef_pdo_user'@'localhost';

-- creating database
CREATE DATABASE oef_pdo;

-- creating user
CREATE USER 'oef_pdo_user'@'localhost' IDENTIFIED BY 'password';
GRANT SELECT, INSERT, UPDATE ON oef_pdo.* TO 'oef_pdo_user'@'localhost';
FLUSH PRIVILEGES;
