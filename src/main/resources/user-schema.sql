DROP TABLE IF EXISTS ms_user;

CREATE TABLE ms_user(
    id SERIAL PRIMARY KEY NOT NULL,
    user_id VARCHAR(15) NOT NULL,
    user_name VARCHAR(50) NOT NULL,
    user_no_hp VARCHAR(20) NOT NULL,
    user_desc VARCHAR(50) NULL,
    user_txn_limit NUMERIC(12,2) NOT NULL,
    entry_date TIMESTAMP NOT NULL,
    created_input_detail VARCHAR(50) NOT NULL,
    updated_input_detail VARCHAR(50) NULL DEFAULT '-'::VARCHAR,
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

SELECT * FROM ms_user;