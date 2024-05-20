create table if not exists client
(
    id bigint,
    name text,
    surname text,
    phone text not null,
    mail text not null,
    birthday date,

    primary key (id)
)