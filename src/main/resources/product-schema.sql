DROP TABLE IF EXISTS ms_product;

CREATE TABLE ms_product(
    id SERIAL PRIMARY KEY NOT NULL,
    product_type VARCHAR(50) NULL,
    product_id VARCHAR(30) NOT NULL,
    product_name VARCHAR(60) NOT NULL,
    product_desc VARCHAR(255) NULL,
    product_ltv NUMERIC(3,2) NOT NULL,
    product_biaya_admin_buka_tipe VARCHAR(6) NOT NULL,
    product_biaya_admin_tutup_tipe VARCHAR(6) NOT NULL,
    product_biaya_admin_buka NUMERIC(3,2) NOT NULL,
    product_biaya_admin_tutup NUMERIC(3,2) NOT NULL,
    product_biaya_jasa_peny NUMERIC(3,2) NOT NULL,
    product_biaya_jasa_peny_periode INT4 NOT NULL,
    product_biaya_denda NUMERIC(3,2) NOT NULL,
    product_biaya_denda_periode INT4 NOT NULL,
    product_jangka_waktu INT4 NOT NULL,
    rec_status VARCHAR(1) NOT NULL DEFAULT 'N'::VARCHAR,
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

SELECT * FROM ms_product; 