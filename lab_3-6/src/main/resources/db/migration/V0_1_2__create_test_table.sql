create table test_table(
    id serial primary key,
    info text,
    code varchar(3),
    another_info json
);