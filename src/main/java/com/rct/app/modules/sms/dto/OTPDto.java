package com.rct.app.modules.sms.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OTPDto {
    @JsonProperty("verification_code")
    private final String vericatioCodes;

    public OTPDto(String vericatioCodes) {
        this.vericatioCodes = vericatioCodes;
    }

    public String getVericatioCodes() {
        return vericatioCodes;
    }
}
