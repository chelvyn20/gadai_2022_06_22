DROP TABLE IF EXISTS TX_PEMBAYARAN_H;

CREATE TABLE TX_PEMBAYARAN_H(
    no_pembayaran VARCHAR(20) PRIMARY KEY NOT NULL,
    no_transaksi VARCHAR(15) NOT NULL,
    total_tagihan_cicilan NUMERIC(12,2) NOT NULL,
    total_tagihan_denda NUMERIC(12,2) NOT NULL,
    biaya_adm_tutup NUMERIC(12,2) NOT NULL,
    total_tagihan NUMERIC(12,2) NOT NULL,
    pembulatan NUMERIC(10,2) NOT NULL,
    jumlah_pembayaran NUMERIC(12,2) NOT NULL,
    metode_bayar VARCHAR(50) NOT NULL
) WITH (
    OIDS=FALSE
);

SELECT * FROM TX_PEMBAYARAN_H; 