create table if not exists dish_ingredients
(
    id bigint,
    product_id bigint not null,
    dish_id bigint not null,

    primary key (id),
    foreign key (product_id) references product(id),
    foreign key (dish_id) references dish(id)
)