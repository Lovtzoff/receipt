create table if not exists Product (
  id serial primary key,
  productName varchar(100) not null,
  price real not null
);

create table if not exists DiscountCard (
  id serial primary key,
  discount integer not null
);