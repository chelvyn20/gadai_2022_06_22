DROP TABLE IF EXISTS tx_cicilan;

CREATE TABLE tx_cicilan(
    no_transaksi 
    product_id 
    cust_id 
    no_barang
    trx_date TIMESTAMP NOT NULL,
    actor_id INT4 NOT NULL,
    status_trans VARCHAR(1) NULL DEFAULT 'N'::VARCHAR
)WITH(
    OIDS = FALSE
);

SELECT * FROM tx_cicilan;