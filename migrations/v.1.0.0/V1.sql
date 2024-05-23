DO
'
DECLARE
    BEGIN
        IF NOT EXISTS (SELECT 1 FROM pg_type WHERE typname = ''measure'') THEN
            CREATE TYPE measure AS ENUM (
                ''KILOGRAMS'',
                ''GRAMS'',
                ''LITERS'',
                ''MILLILITERS'',
                ''PIECES'',
                ''PACKAGES'',
                ''BOXES'',
                ''BOTTLES'',
                ''CANS''
                );
        END IF;
    END
' LANGUAGE PLPGSQL;

DO
'
DECLARE
    BEGIN
        IF NOT EXISTS (SELECT 1 FROM pg_type WHERE typname = ''product_type'') THEN
            CREATE TYPE product_type AS ENUM
                (
                    ''MEAT_AND_MEAT_PRODUCTS'',
                    ''FISH_AND_SEAFOOD'',
                    ''EGGS'',
                    ''MILK_AND_DAIRY_PRODUCTS'',
                    ''BREAD_AND_BAKERY_PRODUCTS'',
                    ''CEREALS_AND_PASTA'',
                    ''LEGUMES'',
                    ''VEGETABLES_FRUITS_AND_BERRIES'',
                    ''NUTS_AND_MUSHROOMS'',
                    ''CONFECTIONERY'',
                    ''FATS_AND_OILS'',
                    ''BEVERAGES'');
        END IF;
    END
' LANGUAGE PLPGSQL;

create table if not exists supplier
(
    id bigint,
    name text not null,

    primary key (id)
);

create table if not exists type_list_of_supplier
(
    id bigint,
    supplier_id bigint not null,
    type product_type not null,

    primary key (id),
    foreign key (supplier_id) references supplier(id)
);

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

create table if not exists dish
(
    id bigint,
    name text not null,
    cost decimal not null,
    weight int not null,
    calories int not null,

    primary key (id)
);

create table if not exists dish_ingredients
(
    id bigint,
    product_id bigint not null,
    dish_id bigint not null,

    primary key (id),
    foreign key (product_id) references product(id),
    foreign key (dish_id) references dish(id)
);

create table if not exists table_data
(
    id bigint,
    seats int not null,
    is_veranda bool not null,
    is_around_window bool not null,

    primary key (id)
);

create table if not exists client
(
    id bigint,
    name text,
    surname text,
    phone text not null,
    mail text not null,
    birthday date,

    primary key (id)
);

create table if not exists order_data
(
    id bigint,
    time timestamp without time zone not null,
    client_id bigint not null,
    count int not null,

    primary key (id),
    foreign key (client_id) references client(id)
);

create table if not exists order_dishes
(
    id bigint,
    dish_id bigint not null,
    order_id bigint not null,

    primary key (id),
    foreign key (dish_id) references dish(id),
    foreign key (order_id) references order_data(id)
);

create table if not exists booking
(
    id bigint generated always as identity,
    start_time timestamp without time zone not null,
    end_time timestamp without time zone not null,
    client_id bigint not null,
    table_id bigint not null,

    primary key (id),
    foreign key (client_id) references client(id),
    foreign key (table_id) references table_data(id)
)