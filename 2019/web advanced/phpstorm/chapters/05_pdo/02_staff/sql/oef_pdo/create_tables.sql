USE oef_pdo;

-- staff
CREATE TABLE IF NOT EXISTS staff (
    PRIMARY KEY (id_staff),
    id_staff    int(5)      AUTO_INCREMENT,
    email       varchar(30) NOT NULL UNIQUE,
    name_first  varchar(30) NOT NULL,
    name_last   varchar(30) NOT NULL
);
