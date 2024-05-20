create table if not exists purchase
(
    id bigint,
    time time without time zone not null,
    supplier_id bigint not null,
    purchase_detail_id bigint not null,

    primary key (id),
    foreign key (supplier_id) references supplier(id),
    foreign key (purchase_detail_id) references purchase_detail(id)
);