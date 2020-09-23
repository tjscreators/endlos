
CREATE DATABASE dbendlos
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    CONNECTION LIMIT = -1;
	
 
create table tbldata (
 	pkid bigserial not null,
 	numberentryid BIGINT not null,
 	primary key(pkid),
 	constraint positive_pkid check(pkid > 0)	
);
