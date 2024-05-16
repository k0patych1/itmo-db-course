create table if not exists product
(
    id bigint,
    name text not null,
    type product_type not null,
    current_stock int,
    min_stock int,
    measure text,

    primary key (id)
);