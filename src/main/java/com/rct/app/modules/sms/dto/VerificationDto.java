package com.rct.app.modules.sms.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VerificationDto {
    @JsonProperty("dial_code")
    private final String dialCode;
    @JsonProperty("phone_number")
    private final String phoneNumber;

    public VerificationDto(String dialCode, String phoneNumber) {
        this.dialCode = dialCode;
        this.phoneNumber = phoneNumber;
    }

    public String getDialCode() {
        return dialCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
