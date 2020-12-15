CREATE TABLE rct_quote
(
    id                        UUID NOT NULL PRIMARY KEY,
    tender_id                 UUID,
    supply_quantity           INT,
    supply_price              NUMERIC,
    supply_pickup_location    VARCHAR(100),
    supply_details            VARCHAR(100),
    created_time              VARCHAR(100),
    updated_time              VARCHAR(100),
    deleted_time              VARCHAR(100),
    active                    INT
)
