DROP TABLE IF EXISTS TX_PEMBAYARAN_H;

CREATE TABLE TX_PEMBAYARAN_H(
    no_pembayaran VARCHAR(20) PRIMARY KEY NOT NULL,
    no_transaksi VARCHAR(15) NOT NULL,
    total_tagihan_cicilan NUMERIC(12,2) NOT NULL,
    total_tagihan_denda NUMERIC(12,2) NOT NULL,
    biaya_adm_tutup NUMERIC(12,2) NOT NULL,
    total_tagihan NUMERIC(12,2) NOT NULL,
    pembulatan NUMERIC(5,2) NOT NULL,
    jumlah_pembayaran NUMERIC(12,2) NOT NULL,
    metode_bayar VARCHAR(50) NOT NULL,
    created_date TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_date TIMESTAMP NULL,
    deleted_date TIMESTAMP NULL,
    created_by INT4 NOT NULL DEFAULT 0::INT4,
    updated_by INT4 NULL,
    deleted_by INT4 NULL
) WITH (
    OIDS=FALSE
);

SELECT * FROM TX_PEMBAYARAN_H; 