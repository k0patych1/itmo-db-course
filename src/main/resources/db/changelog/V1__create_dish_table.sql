create table if not exists dish
(
    id bigint,
    name text not null,
    cost decimal not null,
    weight int not null,
    calories int not null,

    primary key (id)
)