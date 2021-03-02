DROP TABLE IF EXISTS cool;
DROP SEQUENCE IF EXISTS global_seq;
CREATE SEQUENCE global_seq START 100000;

CREATE TABLE cool
(
    id     INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    amount INTEGER NOT NULL,
    CONSTRAINT unique_cool_amount UNIQUE (amount)
)