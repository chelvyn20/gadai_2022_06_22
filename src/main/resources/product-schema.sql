DROP TABLE IF EXISTS ms_product;

CREATE TABLE ms_product(
    product_tipe VARCHAR,
    product_id VARCHAR(20) PRIMARY KEY NOT NULL,
    product_name VARCHAR(50) NOT NULL,
    product_desc VARCHAR(255) NULL,
    product_jangka_waktu INT4 NOT NULL,
    product_ltv NUMERIC(3,2) NOT NULL,
    product_biaya_admin_buka NUMERIC NOT NULL,
    product_biaya_admin_buka_tipe VARCHAR NOT NULL,
    product_biaya_admin_tutup NUMERIC NOT NULL,
    product_biaya_admin_tutup_tipe VARCHAR NOT NULL,
    product_biaya_peny NUMERIC(3,2) NOT NULL,
    product_biaya_peny_periode INT4 NOT NULL,
    product_biaya_denda NUMERIC(3,2) NOT NULL,
    product_biaya_denda_periode INT4 NOT NULL,
    created_date TIMESTAMP NOT NULL,
    creator_id INT4 NOT NULL,
    updated_date TIMESTAMP  NULL,
    updater_id INT4 NULL,
    deleted_date TIMESTAMP NULL,
    deleter_id INT4 NULL,
    product_status VARCHAR(1) NULL DEFAULT 'N'::VARCHAR
)WITH(
    OIDS = FALSE
);

SELECT * FROM ms_product;