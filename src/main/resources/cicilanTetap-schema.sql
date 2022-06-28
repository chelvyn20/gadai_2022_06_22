DROP TABLE IF EXISTS tx_transaksi_cicilan_tetap;

CREATE TABLE tx_transaksi_cicilan_tetap(
    total_nilai_taksiran NUMERIC(12,2),
    nilai_pencairan_pelanggan NUMERIC(12,2),
    diskon_adm_buka NUMERIC(3,2)
)WITH(
    OIDS = FALSE
);

SELECT * FROM tx_transaksi_cicilan_tetap;