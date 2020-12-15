CREATE TABLE rct_user
(
    id                 UUID NOT NULL PRIMARY KEY,
    dial_code          VARCHAR(10),
    phone_number       VARCHAR(20),
    user_name          VARCHAR(100),
    created_time       VARCHAR(100),
    updated_time       VARCHAR(100),
    deleted_time       VARCHAR(100),
    otp                VARCHAR(100),
    otp_expire_time    VARCHAR(100),
    active             INT
)