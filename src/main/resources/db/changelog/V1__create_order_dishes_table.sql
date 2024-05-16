create table if not exists order_dishes
(
    id bigint,
    dish_id bigint not null,
    order_id bigint not null,

    primary key (id),
    foreign key (dish_id) references dish(id),
    foreign key (order_id) references order_data(id)
)