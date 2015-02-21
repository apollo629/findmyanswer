CREATE USER findmyanswer WITH PASSWORD 'q1w2e3r4';

CREATE DATABASE findmyanswer
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'tr_TR.UTF-8'
       LC_CTYPE = 'tr_TR.UTF-8'
       CONNECTION LIMIT = -1
       TEMPLATE = template0;

GRANT ALL PRIVILEGES ON DATABASE findmyanswer to findmyanswer;