CREATE SEQUENCE IF NOT EXISTS s_users_sequence
    START WITH 1
    INCREMENT BY 1
    MINVALUE 0
    NO MAXVALUE
    CACHE 1;

DROP TABLE IF EXISTS t_users cascade;

CREATE TABLE t_users(
id integer default nextval('s_users_sequence'::regclass) NOT NULL PRIMARY KEY,
name VARCHAR(255),
login VARCHAR(255),
is_male INTEGER,
age INTEGER,
password_hash VARCHAR(255));

CREATE SEQUENCE IF NOT EXISTS s_products_sequence
    START WITH 1
    INCREMENT BY 1
    MINVALUE 0
    NO MAXVALUE
    CACHE 1;

DROP TABLE IF EXISTS h_product_types cascade ;

CREATE TABLE h_product_types(
id integer default nextval('s_products_sequence'::regclass) NOT NULL PRIMARY KEY,
name VARCHAR(255),
code VARCHAR(255));

DROP TABLE IF EXISTS t_products cascade ;

CREATE TABLE t_products(
id integer default nextval('s_products_sequence'::regclass) NOT NULL PRIMARY KEY,
name VARCHAR(255),
description VARCHAR(1024),
product_type_id INTEGER REFERENCES h_product_types (id),
price DECIMAL(12,2));

CREATE SEQUENCE IF NOT EXISTS s_contracts_sequence
    START WITH 1
    INCREMENT BY 1
    MINVALUE 0
    NO MAXVALUE
    CACHE 1;

DROP TABLE IF EXISTS t_contracts;

CREATE TABLE t_contracts(
id integer default nextval('s_contracts_sequence'::regclass) NOT NULL PRIMARY KEY,
start_date_time timestamp,
end_date_time timestamp,
user_id INTEGER REFERENCES t_users (id),
product_id INTEGER REFERENCES t_products (id));

