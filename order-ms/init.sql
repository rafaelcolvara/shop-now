-- public.orders definition

-- Drop table

-- DROP TABLE public.orders;

CREATE TABLE public.orders (
	id bigserial NOT NULL,
	order_date timestamp(6) NULL,
	order_number int8 NULL,
	total_price numeric(38, 2) NULL,
	user_id int8 NULL,
	CONSTRAINT orders_pkey PRIMARY KEY (id)
);


-- public.product definition

-- Drop table

-- DROP TABLE public.product;

CREATE TABLE public.product (
	id bigserial NOT NULL,
	description varchar(255) NULL,
	"name" varchar(255) NULL,
	price numeric(38, 2) NULL,
	stock_quantity int4 NOT NULL,
	CONSTRAINT product_pkey PRIMARY KEY (id)
);


-- public.order_items definition

-- Drop table

-- DROP TABLE public.order_items;

CREATE TABLE public.order_items (
	id bigserial NOT NULL,
	price numeric(38, 2) NULL,
	quantity int4 NOT NULL,
	order_id int8 NULL,
	product_id int8 NULL,
	CONSTRAINT order_items_pkey PRIMARY KEY (id),
	CONSTRAINT fkbioxgbv59vetrxe0ejfubep1w FOREIGN KEY (order_id) REFERENCES public.orders(id),
	CONSTRAINT fklf6f9q956mt144wiv6p1yko16 FOREIGN KEY (product_id) REFERENCES public.product(id)
);


insert into product values (1, 'Computer', 'Desktop 32GB SSD', 200.00, 100);
insert into product values (2, 'Apple', 'Iphone 15 256GB', 1000.00, 500);
