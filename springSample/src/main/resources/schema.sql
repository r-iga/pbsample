CREATE TABLE ACCOUNT (
  id integer not null primary key,
  username varchar(50) not null,
  password varchar(100) not null,
  enable boolean,
  admin boolean
);

CREATE TABLE CUSTOMER (
 ID integer not null primary key,
 NAME varchar(100) not null,
 email varchar(100) not null
);
