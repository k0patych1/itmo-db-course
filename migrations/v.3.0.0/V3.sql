-- Create partitioned table
CREATE TABLE IF NOT EXISTS booking_partitioned
(
    id bigint,
    start_time timestamp without time zone not null,
    end_time timestamp without time zone not null,
    client_id bigint not null,
    table_id bigint not null,
    primary key (id, start_time),
    foreign key (client_id) references client(id),
    foreign key (table_id) references table_data(id)
)
    PARTITION BY RANGE (start_time);

CREATE TABLE booking_partitioned_2024_02 PARTITION OF booking_partitioned
    FOR VALUES FROM ('2024-02-01') TO ('2024-03-01');

CREATE TABLE booking_partitioned_2024_03 PARTITION OF booking_partitioned
    FOR VALUES FROM ('2024-03-01') TO ('2024-04-01');

CREATE TABLE booking_partitioned_2024_04 PARTITION OF booking_partitioned
    FOR VALUES FROM ('2024-04-01') TO ('2024-05-01');

CREATE TABLE booking_partitioned_2024_05 PARTITION OF booking_partitioned
    FOR VALUES FROM ('2024-05-01') TO ('2024-06-01');

CREATE TABLE booking_partitioned_2024_06 PARTITION OF booking_partitioned
    FOR VALUES FROM ('2024-06-01') TO ('2024-07-01');

INSERT INTO booking_partitioned
SELECT id, start_time, end_time, client_id, table_id
FROM booking;

DROP TABLE booking;

ALTER TABLE booking_partitioned RENAME TO booking;