package com.rct.app.modules.authentication.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RefreshTokenDto {
    @JsonProperty("refresh_token")
    private String refreshToken;
    public RefreshTokenDto() {}
    public RefreshTokenDto(String refreshToken) {
        this.refreshToken = refreshToken;
    }
    public String getRefreshToken() {
        return refreshToken;
    }
}
