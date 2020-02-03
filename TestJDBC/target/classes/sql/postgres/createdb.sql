psql -U postgres

CREATE USER montana with PASSWORD 'Qwerty1-';

\du

CREATE DATABASE montanadb;

\l

GRANT ALL PRIVILEGES ON DATABASE "montanadb" to montana;

\q
