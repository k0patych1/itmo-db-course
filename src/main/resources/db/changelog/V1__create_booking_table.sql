create table if not exists booking
(
    id bigint,
    start_time timestamp without time zone not null,
    end_time timestamp without time zone not null,
    client_id bigint not null,
    table_id bigint not null,

    primary key (id),
    foreign key (client_id) references client(id),
    foreign key (table_id) references table_data(id)
)