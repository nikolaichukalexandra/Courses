CREATE database marketdb;
USE marketdb;

CREATE TABLE item (
id INTEGER AUTO_INCREMENT PRIMARY KEY,
item_name VARCHAR(30),
item_cost DOUBLE,
release_date_from varchar(10),
release_date_to varchar(10),
color varchar (20),
category varchar(30),
fresh binary,
note varchar(50)
);


create table photo(
id INTEGER auto_increment primary key,
image blob,
local_date varchar(10),
note varchar(100)
);
 
