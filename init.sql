-- public.products definition

-- Drop table

DROP TABLE if exists public.products;

CREATE TABLE public.products (
	id bigserial NOT NULL,
	description varchar(255) NULL,
	"name" varchar(255) NULL,
	price numeric(38, 2) NULL,
	CONSTRAINT products_pkey PRIMARY KEY (id)
);


-- public.users definition

-- Drop table

DROP TABLE if exists public.users;

CREATE TABLE public.users (
	id bigserial NOT NULL,
	email varchar(100) NOT NULL,
	full_name varchar(100) NOT NULL,
	"password" varchar(60) NOT NULL,
	username varchar(20) NOT NULL,
	CONSTRAINT users_pkey PRIMARY KEY (id)
);


-- public.orders definition

-- Drop table

DROP TABLE if exists public.orders;

CREATE TABLE public.orders (
	id bigserial NOT NULL,
	order_date timestamp(6) NULL,
	order_number int8 NULL,
	total_price numeric(38, 2) NULL,
	user_id int8 NULL,
	CONSTRAINT orders_pkey PRIMARY KEY (id),
	CONSTRAINT fk32ql8ubntj5uh44ph9659tiih FOREIGN KEY (user_id) REFERENCES public.users(id)
);


-- public.order_items definition

-- Drop table

DROP TABLE if exists public.order_items;

CREATE TABLE public.order_items (
	id bigserial NOT NULL,
	price numeric(38, 2) NULL,
	quantity int4 NOT NULL,
	order_id int8 NULL,
	product_id int8 NULL,
	CONSTRAINT order_items_pkey PRIMARY KEY (id),
	CONSTRAINT fkbioxgbv59vetrxe0ejfubep1w FOREIGN KEY (order_id) REFERENCES public.orders(id),
	CONSTRAINT fkocimc7dtr037rh4ls4l95nlfi FOREIGN KEY (product_id) REFERENCES public.products(id)
);

insert into users values (nextval('users_id_seq'::regclass), 'Usuario1', 'Usuario1', 'Usuario1', 'Usuario1');
insert into users values (nextval('users_id_seq'::regclass), 'Usuario2', 'Usuario2', 'Usuario2', 'Usuario2');

insert into products values (nextval('products_id_seq'::regclass), 'Computer', 'Desktop 32GB SSD', 200.00);
insert into products values (nextval('products_id_seq'::regclass), 'Apple', 'Iphone 15 256GB', 1000.00);

insert into orders values (nextval('orders_id_seq'::regclass), '2022-01-01 00:00:00', 1, 1200.00, 1);
insert into orders values (nextval('orders_id_seq'::regclass), '2022-01-02 00:00:00', 2, 200.00, 2);

insert into order_items values (nextval('order_items_id_seq'::regclass), 200.00, 1, 1, 1);
insert into order_items values (nextval('order_items_id_seq'::regclass), 1000.00, 1, 2, 2);
