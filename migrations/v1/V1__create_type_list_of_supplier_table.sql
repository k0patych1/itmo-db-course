create table if not exists type_list_of_supplier
(
    id bigint,
    supplier_id bigint not null,
    type product_type not null,

    primary key (id),
    foreign key (supplier_id) references supplier(id)
)