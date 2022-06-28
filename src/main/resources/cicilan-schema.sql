DROP TABLE IF EXISTS tx_cicilan;

CREATE TABLE tx_cicilan(
    id VARCHAR(6) PRIMARY KEY NOT NULL,
    biaya_pokok NUMERIC(12,2) NOT NULL,
    bunga NUMERIC(10,2) NOT NULL,
    status_transaksi VARCHAR(20) NOT NULL,
    tanggal_aktif TIMESTAMP NOT NULL,
    tanggal_jatuh_tempo TIMESTAMP NOT NULL,
    tanggal_bayar TIMESTAMP NULL,
    actor_id INT4 NOT NULL DEFAULT 0::INT4,
    rec_status  VARCHAR(1) NOT NULL DEFAULT 'N'::VARCHAR,
    created_date TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_date TIMESTAMP NULL,
    deleted_date TIMESTAMP NULL,
    created_by INT4 NOT NULL DEFAULT 0::INT4,
    updated_by INT4 NULL,
    deleted_by INT4 NULL
) WITH (
    OIDS=FALSE
);

SELECT * FROM tx_cicilan; 