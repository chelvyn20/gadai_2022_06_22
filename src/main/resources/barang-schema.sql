DROP TABLE IF EXISTS tx_transaksi_barang;

CREATE TABLE tx_transaksi_barang(
    no_barang SERIAL PRIMARY KEY NOT NULL,
    nama__barang VARCHAR(30) NOT NULL UNIQUE,
    desc_barang VARCHAR(150) NOT NULL,
    jmlh_barang INT4 NOT NULL,
    harga_barang NUMERIC(10,2) NOT NULL,
    total_harga_barang NUMERIC(12,2),
    created_date TIMESTAMP NOT NULL,
    creator_id INT4 NOT NULL,
    updated_date TIMESTAMP  NULL,
    updater_id INT4 NULL,
    deleted_date TIMESTAMP NULL,
    deleter_id INT4 NULL,
    status_barang VARCHAR(1) NULL DEFAULT 'N'::VARCHAR
)WITH(
    OIDS = FALSE
);

SELECT * FROM tx_transaksi_barang;