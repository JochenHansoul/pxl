create table cursussen (
curs_code VARCHAR2(4) NOT NULL,
curs_omschr char(20) NOT NULL,
curs_type char(20),
curs_lengte number(2),
constraint curs_code_pk primary key(curs_code),
constraint curs_type_upper_check check(upper(curs_type) = curs_type),
constraint curs_lengte_check check(curs_lengte >= 0 and curs_lengte <= 10)
);
