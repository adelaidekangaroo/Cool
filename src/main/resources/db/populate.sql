TRUNCATE cool;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO cool (amount)
VALUES (10),
       (29),
       (50),
       (80);