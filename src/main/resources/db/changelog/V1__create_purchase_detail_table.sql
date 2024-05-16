create table if not exists purchase_detail
(
    id bigint,
    product_id bigint not null,
    volume int not null,
    price decimal not null,
    measure measure not null,

    primary key (id),
    foreign key (product_id) references product(id)
);