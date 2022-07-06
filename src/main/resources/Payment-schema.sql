DROP TABLE IF EXISTS tx_pembayaran_h;


CREATE TABLE tx_pembayaran_h(
    no_pembayaran VARCHAR (20) PRIMARY KEY NOT NULL,
    no_transaksi VARCHAR (20) NOT NULL,
    total_tagihan_cicilan NUMERIC NOT NULL,
    total_tagihan_denda NUMERIC NULL,
    biaya_adm_tutup NUMERIC NULL,
    total_tagihan NUMERIC NOT NULL,
    pembulatan NUMERIC NOT NULL,
    jumlah_pembayaran NUMERIC NOT NULL,
    metode_bayar VARCHAR(10) NOT NULL
   
)WITH(
    OIDS = FALSE
);

SELECT * FROM tx_pembayaran_h;


