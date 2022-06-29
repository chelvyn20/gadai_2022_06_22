DROP TABLE IF EXISTS tx_transaksi_cicilan_tetap;

CREATE TABLE tx_transaksi_cicilan_tetap(
    no_transaksi VARCHAR(20) PRIMARY KEY NOT NULL,
    total_nilai_taksiran NUMERIC(12,2),
    nilai_pencairan_pelanggan NUMERIC(12,2) NOT NULL,
    diskon_adm_buka NUMERIC(3,2),
    tx_ltv NUMERIC(3,2),
    max_nilai_pinjam NUMERIC,
    biaya_adm_buka NUMERIC,
    biaya_adm_buka_akhir NUMERIC,
    total_nilai_pinjaman NUMERIC,
    tanggal_tx DATE,
    tanggal_jatuh_tempo DATE,
    biaya_jasa_penyimpanan NUMERIC,
    biaya_jasa_peny_periode NUMERIC,
    total_biaya_jasa_peny NUMERIC,
    biaya_adm_tutup NUMERIC,
    total_pengembalian NUMERIC,
    customer_id VARCHAR(10) NOT NULL UNIQUE,
    product_id VARCHAR(10) NOT NULL UNIQUE,
    created_date TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT NOW(),
    actor_id INT4 NOT NULL DEFAULT 0::INT4,
)WITH(
    OIDS = FALSE
);

SELECT * FROM tx_transaksi_cicilan_tetap;