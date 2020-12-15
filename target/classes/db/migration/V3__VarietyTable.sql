CREATE TABLE rct_variety
(
    id                    UUID NOT NULL PRIMARY KEY,
    variety_name          VARCHAR(10),
    created_time          VARCHAR(100),
    updated_time          VARCHAR(100),
    deleted_time          VARCHAR(100),
    active                INT
)
