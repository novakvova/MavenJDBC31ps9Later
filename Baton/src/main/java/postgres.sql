psql -U postgres

CREATE USER alkash with PASSWORD 'Qwerty1-';

\du

CREATE DATABASE petrovnadb;

\l

GRANT ALL PRIVILEGES ON DATABASE "petrovnadb" to alkash;

\q