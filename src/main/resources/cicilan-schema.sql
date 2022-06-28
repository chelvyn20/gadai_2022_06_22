DROP TABLE IF EXISTS tx_cicilan;

CREATE TABLE tx_cicilan(
    no_transaksi VARCHAR(20) PRIMARY KEY NOT NULL,
    product_id  VARCHAR(20) NOT NULL,
    cust_id VARCHAR(10) NOT NULL,
    total_pinjaman NUMERIC(12,2),
    pokok NUMERIC(12,2),
    bunga NUMERIC(3,2),
    no_barang  INT4 NOT NULL,
    trx_date TIMESTAMP NOT NULL,
    tanggal_aktif TIMESTAMP,
    tanggal_jatuh_tempo TIMESTAMP,
    tanggal_bayar TIMESTAMP,
    actor_id INT4 NOT NULL,
    status_trans VARCHAR(1) NULL DEFAULT 'N'::VARCHAR
)WITH(
    OIDS = FALSE
);

SELECT * FROM tx_cicilan;