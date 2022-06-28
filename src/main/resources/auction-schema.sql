DROP TABLE IF EXISTS ms_auction;

CREATE TABLE ms_auction(
    id SERIAL PRIMARY KEY NOT NULL,
    product_name VARCHAR(60) NOT NULL,
    product_condition VARCHAR(50) NULL,
    product_desc VARCHAR(255) NOT NULL,
    product_quantity INT4 NOT NULL,
    product_price NUMERIC(12,2) NOT NULL,
    actor_id INT4 NOT NULL DEFAULT 0::INT4,
    created_date TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_date TIMESTAMP NULL,
    deleted_date TIMESTAMP NULL,
    created_by INT4 NOT NULL DEFAULT 0::INT4,
    updated_by INT4 NULL,
    deleted_by INT4 NULL
) WITH (
    OIDS=FALSE
);

SELECT * FROM ms_auction; 