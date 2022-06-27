DROP TABLE IF EXISTS ms_auction;

CREATE TABLE ms_auction(
    id SERIAL PRIMARY KEY NOT NULL,
    product_name VARCHAR(60) NOT NULL,
    product_desc VARCHAR(255) NULL,
    product_quantity INT4 NOT NULL,
    product_price NUMERIC(12,2) NOT NULL,
    product_condition VARCHAR(50) NULL,
    total_nilai_taksiran NUMERIC(12,2) NOT NULL,
    product_ltv NUMERIC(3,2) NOT NULL,
    max_nilai_pinjaman NUMERIC(12,2) NOT NULL,
    biaya_admin_buka NUMERIC(3,2) NOT NULL,
    admin_fee_discount NUMERIC(3,2) NULL,
    total_pinjaman,
    transaction_date,
    transaction_due_date,
    biaya_jasa_penyimpanan,
    biaya_jasa_penyimpanan_periode,
    biaya_admin_tutup NUMERIC(3,2) NOT NULL,
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