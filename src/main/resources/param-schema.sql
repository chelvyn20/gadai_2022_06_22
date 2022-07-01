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

INSERT INTO ms_param(param_key, param_value)
VALUES('CRON_10_Seconds', '*/10 * * * * ?');

UPDATE tx_denda_keterlambatan
SET param_value ='0/5 * * * * ?'
WHERE param_key = 'CRON_10_Seconds';



