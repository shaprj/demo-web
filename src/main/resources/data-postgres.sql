insert into t_users(name, login, is_male, age, password_hash)
values ('Ivan', 'striker', 1, 25, '1234ABCD') on conflict do nothing;
insert into t_users(name, login, is_male, age, password_hash)
values ('Petr', 'goga', 1, 11, '3456BCDE') on conflict do nothing;
insert into t_users(name, login, is_male, age, password_hash)
values ('Helga', 'antverpen', 0, 18, '1324FCDA') on conflict do nothing;
insert into t_users(name, login, is_male, age, password_hash)
values ('Alupka', 'bubblegum', 0, 33, '7654ADCB') on conflict do nothing;
insert into t_users(name, login, is_male, age, password_hash)
values ('George', 'awesome1998', 1, 25, '5663DDFA') on conflict do nothing;
insert into t_users(name, login, is_male, age, password_hash)
values ('Kostya', 'poolkeeper', 1, 52, 'ABCD8765') on conflict do nothing;

insert into h_product_types(name, code)
values('IDE', 'IDE') on conflict do nothing;
insert into h_product_types(name, code)
values('Security Provider', 'SP') on conflict do nothing;
insert into h_product_types(name, code)
values('AntiVirus Software', 'AVS') on conflict do nothing;
insert into h_product_types(name, code)
values('OS', 'OS') on conflict do nothing;
insert into h_product_types(name, code)
values('Office packet', 'OP') on conflict do nothing;


insert into t_products(name, description, product_type_id, price)
values('Intelij IDEA', 'IDE for pleasant development of java projects', (select id from h_product_types where code = 'IDE'), 1234.22) on conflict do nothing;
insert into t_products(name, description, product_type_id, price)
values('PHPStorm', 'IDE for PHP projects development', (select id from h_product_types where code = 'IDE'), 567.34) on conflict do nothing;
insert into t_products(name, description, product_type_id, price)
values('ReShaper', 'IDE for .NET projects development', (select id from h_product_types where code = 'IDE'), 890.56) on conflict do nothing;
insert into t_products(name, description, product_type_id, price)
values('CryptoPro CSP', 'CryptoProvider certified in Russia', (select id from h_product_types where code = 'SP'), 987.12) on conflict do nothing;
insert into t_products(name, description, product_type_id, price)
values('Kaspersky Internet Security', 'Advanced security & antivirus suite for your privacy & money – on PC, Mac & mobile', (select id from h_product_types where code = 'AVS'), 1234.22) on conflict do nothing;
insert into t_products(name, description, product_type_id, price)
values('AstraLinux Special  Edition', 'Special-Purpose OS. Ensures the protection of confidential and top secret information', (select id from h_product_types where code = 'OS'), 543.87) on conflict do nothing;
insert into t_products(name, description, product_type_id, price)
values('Office 365', 'Office packet', (select id from h_product_types where code = 'OP'), 234.23) on conflict do nothing;