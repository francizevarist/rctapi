package com.rct.app.modules.authentication.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RefreshTokenResponse {
    @JsonProperty("new_token")
    private String newToken;
    @JsonProperty("token_status")
    private Boolean tokenStatus;

    public RefreshTokenResponse() {}

    public RefreshTokenResponse(String newToken, Boolean tokenStatus) {
        this.newToken = newToken;
        this.tokenStatus = tokenStatus;
    }

    public String getNewToken() {
        return newToken;
    }

    public Boolean getTokenStatus() {
        return tokenStatus;
    }
}
