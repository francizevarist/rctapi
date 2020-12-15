CREATE TABLE authentication
(
    id             UUID NOT NULL PRIMARY KEY,
    user_id        UUID,
    created_time   VARCHAR(100),
    security_token TEXT,
    refresh_token  UUID
)
