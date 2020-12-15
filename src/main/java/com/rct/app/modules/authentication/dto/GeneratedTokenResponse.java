package com.rct.app.modules.authentication.dto;

import java.util.UUID;

public class GeneratedTokenResponse {
    private String token;
    private UUID refreshToken;

    public GeneratedTokenResponse() {}

    public GeneratedTokenResponse(String token, UUID refreshToken) {
        this.token = token;
        this.refreshToken = refreshToken;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UUID getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(UUID refreshToken) {
        this.refreshToken = refreshToken;
    }
}
