USE oef_pdo;

-- creating tables
CREATE TABLE staff (
    PRIMARY KEY (id_staff),
    id_staff    int(5)      AUTO_INCREMENT,
    name_first  varchar(30) NOT NULL,
    name_last   varchar(30) NOT NULL
);

-- inserting values
INSERT INTO staff (id_staff, name_first, name_last)
VALUES  (1, 'Martin', 'Freeman'),
        (2, 'Feynman', 'Tomson'),
        (3, 'Graves', 'Wonder');
