package com.rct.app.modules.authentication.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Session {
    private UUID id;

    @JsonProperty("user_id")
    private UUID userId;

    @JsonProperty("created_time")
    private  Long createdTime;

    @JsonProperty("security_token")
    private  String securityToken;

    @JsonProperty("refresh_token")
    private  UUID refreshToken;


    public Session() {}

    public Session(UUID userId) {
        this.userId = userId;
    }

    public Session(UUID userId, String securityToken) {
        this.userId = userId;
        this.securityToken = securityToken;
    }

    public Session(UUID userId, String securityToken, UUID refreshToken) {
        this.userId = userId;
        this.securityToken = securityToken;
        this.refreshToken = refreshToken;
    }

    public Session(UUID id, UUID userId, String securityToken, UUID refreshToken) {
        this.id = id;
        this.userId = userId;
        this.securityToken = securityToken;
        this.refreshToken = refreshToken;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public Long getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Long createdTime) {
        this.createdTime = createdTime;
    }

    public String getSecurityToken() {
        return securityToken;
    }

    public void setSecurityToken(String securityToken) {
        this.securityToken = securityToken;
    }

    public UUID getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(UUID refreshToken) {
        this.refreshToken = refreshToken;
    }

}
