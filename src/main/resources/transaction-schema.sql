DROP TABLE IF EXISTS tx_transaction;

CREATE TABLE tx_transaction(
    id SERIAL PRIMARY KEY NOT NULL,
    cust_id VARCHAR(10) PRIMARY KEY NOT NULL,
    cust_name VARCHAR(30) NOT NULL,
    cust_ktp VARCHAR(16) NOT NULL UNIQUE,
    cust_hp VARCHAR(50) NULL UNIQUE,
    product_id VARCHAR(30) NOT NULL,
    product_name VARCHAR(60) NOT NULL,

    trx_date_begin TIMESTAMP NOT NULL,
    trx_date_end TIMESTAMP NOT NULL,
    trx_status VARCHAR(50) NOT NULL,
    nilai_pencairan_pelanggan NUMERIC(12,2) NOT NULL,
    diskon_admin_buka NUMERIC(3,2) NOT NULL,
    tanggal_jatuh_tempo TIMESTAMP NOT NULL,
    diskon_admin_pembuka,
    total_nilai_taksiran,

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

SELECT * FROM tx_transaction; 