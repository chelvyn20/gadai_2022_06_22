DROP TABLE IF EXISTS ms_customer;

CREATE TABLE ms_customer(
    cust_id VARCHAR(10) PRIMARY KEY NOT NULL,
    cust_name VARCHAR(30) NOT NULL,
    cust_ktp VARCHAR(16) NOT NULL UNIQUE,
    cust_hp VARCHAR(50) NULL UNIQUE,
    cust_jk VARCHAR(1) NOT NULL,
    cust_jenis_usaha_id VARCHAR (10) NOT NULL,
    cust_limit_txn NUMERIC(12,2) NOT NULL,
    created_date TIMESTAMP NOT NULL,
    creator_id INT4 NOT NULL,
    updated_date TIMESTAMP  NULL,
    updater_id INT4 NULL,
    deleted_date TIMESTAMP NULL,
    deleter_id INT4 NULL,
    cust_status VARCHAR(1) NULL DEFAULT 'N'::VARCHAR
)WITH(
    OIDS = FALSE
);

SELECT * FROM ms_customer;