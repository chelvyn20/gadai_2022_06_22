DROP TABLE IF EXISTS tx_transaksi_cicilan_tetap;

CREATE TABLE tx_transaksi_cicilan_tetap(
    id SERIAL PRIMARY KEY NOT NULL,
    product_id VARCHAR(30) NOT NULL,
    total_nilai_taksiran NUMERIC(12,2) NOT NULL,
    nilai_pencairan_pelanggan NUMERIC(12,2) NOT NULL,
    biaya_admin_buka NUMERIC(12,2) NULL,
    diskon_admin_buka NUMERIC(3,2) NOT NULL,
    total_nilai_pinjaman NUMERIC(12,2) NULL,
    tanggal_transaksi TIMESTAMP NOT NULL,
    tanggal_jatuh_tempo TIMESTAMP NOT NULL,
    biaya_jasa_penyimpanan NUMERIC(12,2) NULL,
    biaya_jasa_penyimpanan_periode INT4 NULL,
    biaya_admin_tutup NUMERIC(12,2) NULL,
    total_pengembalian NUMERIC (12,2) NULL,
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

SELECT * FROM tx_transaksi_cicilan_tetap; 