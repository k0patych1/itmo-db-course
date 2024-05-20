#!/bin/bash

psql -U $POSTGRES_USER -d $POSTGRES_DB << EOF

CREATE ROLE reader;
GRANT SELECT ON ALL TABLES IN SCHEMA public TO reader;

CREATE ROLE writer;
GRANT SELECT, INSERT, UPDATE ON ALL TABLES IN SCHEMA public TO writer;

CREATE ROLE group_role;
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA public TO group_role WITH GRANT OPTION;

CREATE user ruslan;
GRANT group_role TO ruslan;

CREATE user aytal;
GRANT group_role TO aytal;