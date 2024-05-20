create table if not exists table_data
(
    id bigint,
    seats int not null,
    is_veranda bool not null,
    is_around_window bool not null,

    primary key (id)
)