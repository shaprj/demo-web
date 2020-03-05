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
insert into t_users(name, login, is_male, age, password_hash)
values ('Evgeniy', 'cooddy', 1, 12, '1234ABCD') on conflict do nothing;
insert into t_users(name, login, is_male, age, password_hash)
values ('Alla', 'plintuw', 0, 31, '3456BCDE') on conflict do nothing;
insert into t_users(name, login, is_male, age, password_hash)
values ('Alex', 'tolariod', 1, 42, '1324FCDA') on conflict do nothing;
insert into t_users(name, login, is_male, age, password_hash)
values ('Ustos', 'vaviloon', 1, 31, '7654ADCB') on conflict do nothing;
insert into t_users(name, login, is_male, age, password_hash)
values ('Forlan', 'pound1991', 1, 11, '5663DDFA') on conflict do nothing;
insert into t_users(name, login, is_male, age, password_hash)
values ('Borya', 'sweetyone', 1, 65, 'ABCD8765') on conflict do nothing;
insert into t_users(name, login, is_male, age, password_hash)
values ('Trofim', 'kugel1961', 1, 33, '1234ABCD') on conflict do nothing;
insert into t_users(name, login, is_male, age, password_hash)
values ('Eve', 'parusa', 0, 17, '3456BCDE') on conflict do nothing;
insert into t_users(name, login, is_male, age, password_hash)
values ('Tom', 'tidig', 1, 18, '1324FCDA') on conflict do nothing;
insert into t_users(name, login, is_male, age, password_hash)
values ('Bob', 'captainwood', 1, 34, '7654ADCB') on conflict do nothing;
insert into t_users(name, login, is_male, age, password_hash)
values ('Teddy', 'zazzoo', 1, 37, '5663DDFA') on conflict do nothing;
insert into t_users(name, login, is_male, age, password_hash)
values ('Abraham', 'roverdance', 1, 51, 'ABCD8765') on conflict do nothing;
insert into t_users(name, login, is_male, age, password_hash)
values ('Yuliya', 'turky', 0, 26, '1234ABCD') on conflict do nothing;
insert into t_users(name, login, is_male, age, password_hash)
values ('Volodya', 'thunderbird', 1, 21, '3456BCDE') on conflict do nothing;
insert into t_users(name, login, is_male, age, password_hash)
values ('Rex', 'attika', 1, 19, '1324FCDA') on conflict do nothing;
insert into t_users(name, login, is_male, age, password_hash)
values ('Buddy', 'koventgarden', 1, 14, '7654ADCB') on conflict do nothing;
insert into t_users(name, login, is_male, age, password_hash)
values ('Kelly', 'bublik', 0, 18, '5663DDFA') on conflict do nothing;
insert into t_users(name, login, is_male, age, password_hash)
values ('Monica', 'rotterdam', 0, 22, 'ABCD8765') on conflict do nothing;

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
values('VipNet CSP', 'CryptoProvider certified in Russia', (select id from h_product_types where code = 'SP'), 654.43) on conflict do nothing;
insert into t_products(name, description, product_type_id, price)
values('Kaspersky Internet Security', 'Advanced security & antivirus suite for your privacy & money – on PC, Mac & mobile', (select id from h_product_types where code = 'AVS'), 1234.22) on conflict do nothing;
insert into t_products(name, description, product_type_id, price)
values('Norton Antivirus', 'Security edition', (select id from h_product_types where code = 'AVS'), 555.44) on conflict do nothing;
insert into t_products(name, description, product_type_id, price)
values('Dr Web', 'Antivirus software', (select id from h_product_types where code = 'AVS'), 756.11) on conflict do nothing;
insert into t_products(name, description, product_type_id, price)
values('AstraLinux Special  Edition', 'Special-Purpose OS. Ensures the protection of confidential and top secret information', (select id from h_product_types where code = 'OS'), 543.87) on conflict do nothing;
insert into t_products(name, description, product_type_id, price)
values('Alt linux', 'Special-Purpose OS', (select id from h_product_types where code = 'OS'), 413.77) on conflict do nothing;
insert into t_products(name, description, product_type_id, price)
values('AstraLinux Common Edition', 'Common edition', (select id from h_product_types where code = 'OS'), 1.11) on conflict do nothing;
insert into t_products(name, description, product_type_id, price)
values('AstraLinux Special Edition', 'Special-Purpose OS. Ensures the protection of confidential and top secret information', (select id from h_product_types where code = 'OS'), 543.87) on conflict do nothing;
insert into t_products(name, description, product_type_id, price)
values('Office 365', 'Office packet', (select id from h_product_types where code = 'OP'), 234.23) on conflict do nothing;
insert into t_products(name, description, product_type_id, price)
values('MS Office 2018', 'Microsoft Office packet', (select id from h_product_types where code = 'OP'), 1234.23) on conflict do nothing;
insert into t_products(name, description, product_type_id, price)
values('MS Word 2018', 'Microsoft Office packet', (select id from h_product_types where code = 'OP'), 123.23) on conflict do nothing;
insert into t_products(name, description, product_type_id, price)
values('MS Excell 2018', 'Microsoft Office packet', (select id from h_product_types where code = 'OP'), 225.22) on conflict do nothing;
insert into t_products(name, description, product_type_id, price)
values('MS Power Point 2018', 'Microsoft Office packet', (select id from h_product_types where code = 'OP'), 210.21) on conflict do nothing;
insert into t_products(name, description, product_type_id, price)
values('MS Access 2018', 'Microsoft Office packet', (select id from h_product_types where code = 'OP'), 190.13) on conflict do nothing;