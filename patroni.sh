#!/bin/bash

cd replications

docker build -t patroni .
docker compose up -d

sleep 10

PGPASSWORD="postgres" pg_dump -U postgres -h localhost  > patroni_backup.sql
PGPASSWORD="postgres" psql -h localhost -p 5000 -U postgres < patroni_backup.sql
