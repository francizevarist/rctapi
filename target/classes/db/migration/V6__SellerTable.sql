CREATE TABLE rct_seller
(
    id                       UUID NOT NULL PRIMARY KEY,
    leader_id                UUID,
    user_id                  UUID,
    first_time               VARCHAR(100),
    last_name                VARCHAR(100),
    application_type         VARCHAR(100),
    address                  VARCHAR(100),
    website                  VARCHAR(100),
    grade                    INT,
    experience               VARCHAR(100),
    tbs_certification_number VARCHAR(100),
    certification_number     VARCHAR(100),
    variety_name             VARCHAR(100),
    created_time             VARCHAR(100),
    updated_time             VARCHAR(100),
    deleted_time             VARCHAR(100),
    active                   INT
)
