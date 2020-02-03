CREATE DATABASE montanadb;

CREATE USER 'montana'@'localhost' IDENTIFIED BY '123456';

GRANT SELECT, INSERT, UPDATE, DELETE, CREATE, INDEX, DROP, ALTER, CREATE TEMPORARY TABLES, LOCK TABLES ON montanadb.* TO 'montana'@'localhost';
