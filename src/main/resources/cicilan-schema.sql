DROP TABLE IF EXISTS tx_cicilan;

CREATE TABLE tx_cicilan(
    no_transaksi VARCHAR(20) PRIMARY KEY NOT NULL,
    cicilan_ke  INT4 NOT NULL,
    total_pinjaman NUMERIC(12,2),
    tx_pokok NUMERIC(12,2),
    tx_bunga NUMERIC(3,2),
    trx_date TIMESTAMP NOT NULL DEFAULT NOW(),
    actor_id INT4 NOT NULL DEFAULT 0::INT4,
    tanggal_aktif DATE,
    tanggal_jatuh_tempo DATE,
    tanggal_bayar DATE,
    status_trans VARCHAR(1) NULL DEFAULT 'N'::VARCHAR
)WITH(
    OIDS = FALSE
);

SELECT * FROM tx_cicilan;