DROP TABLE IF EXISTS tx_denda_keterlambatan;


CREATE TABLE tx_denda_keterlambatan(
    denda_id VARCHAR (5) PRIMARY KEY NOT NULL,
    no_transaksi VARCHAR (20) NOT NULL,
    cicilan_ke INT4 NOT NULL,
    tgl_denda DATE NOT NULL,
    biaya_denda NUMERIC NOT NULL,
    tgl_pembayaran_denda DATE NULL,
    no_pembayaran NUMERIC NULL,
   
)WITH(
    OIDS = FALSE
);

SELECT * FROM tx_denda_keterlambatan;


