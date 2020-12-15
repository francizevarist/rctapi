package com.rct.app.modules.authentication.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Auth {
    @JsonIgnore
    @JsonProperty("token")
    private final String token;

    public Auth(String token) {
        this.token = token;
    }

    @JsonProperty
    public String getToken() {
        return token;
    }
}
