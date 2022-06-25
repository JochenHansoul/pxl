-- DATABASE
DROP DATABASE IF EXISTS oef_pdo;

CREATE DATABASE IF NOT EXISTS oef_pdo;

-- USER
DROP USER IF EXISTS 'oef_pdo_user'@'localhost';

CREATE USER IF NOT EXISTS 'oef_pdo_user'@'localhost' IDENTIFIED BY 'password';

GRANT SELECT, INSERT, UPDATE ON oef_pdo.* TO 'oef_pdo_user'@'localhost';
FLUSH PRIVILEGES;
