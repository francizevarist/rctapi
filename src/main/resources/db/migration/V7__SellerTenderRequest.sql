CREATE TABLE rct_seller_tender_request
(
    id                       UUID NOT NULL PRIMARY KEY,
    seller_id                UUID,
    quantity                 NUMERIC,
    selling_price            NUMERIC,
    is_graded                INT,
    grade                    INT,
    is_batch_certified       INT,
    pickup_location          VARCHAR(100),
    extra_details            VARCHAR(100),
    created_time             VARCHAR(100),
    updated_time             VARCHAR(100),
    deleted_time             VARCHAR(100),
    active                   INT,
    variety                  VARCHAR(100)
)