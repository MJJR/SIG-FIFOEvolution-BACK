drop table if exists addresses cascade;

create table addresses
(
    id             serial primary key,
    street_address varchar,
    city           varchar,
    state          varchar,
    zip            varchar
);

insert into addresses (street_address, city, state, zip)
values ('320 1st St N', 'Jacksonville Beach', 'FL', '32250'),
       ('661 W Lake St', 'Chicago', 'IL', '60661');
