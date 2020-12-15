CREATE TABLE rct_leader
(
    id                    UUID NOT NULL PRIMARY KEY,
    platform_id           UUID,
    user_id               UUID,
    created_time          VARCHAR(100),
    updated_time          VARCHAR(100),
    deleted_time          VARCHAR(100),
    active                INT
)
