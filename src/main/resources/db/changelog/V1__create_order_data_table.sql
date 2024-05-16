create table if not exists order_data
(
    id bigint,
    time timestamp without time zone not null,
    client_id bigint not null,
    count int not null,

    primary key (id),
    foreign key (client_id) references client(id)
)