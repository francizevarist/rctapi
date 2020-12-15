CREATE TABLE rct_tender
(
    id                UUID NOT NULL PRIMARY KEY,
    buyer_id          UUID,
    quantity          NUMERIC,
    grade             INT,
    pickup_location   VARCHAR(100),
    variety           VARCHAR(100),
    created_time      VARCHAR(100),
    updated_time      VARCHAR(100),
    deleted_time      VARCHAR(100),
    active            INT
)


