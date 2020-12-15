package com.rct.app.modules.authentication.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OTPDto {
    @JsonProperty("otpcode")
    private String otpCodes;

    @JsonProperty("dial_code")
    private  String dialCode;

    @JsonProperty("phone_number")
    private  String phoneNumber;

    public OTPDto() {}

    public OTPDto(String otpCodes, String dialCode, String phoneNumber) {
        this.otpCodes = otpCodes;
        this.dialCode = dialCode;
        this.phoneNumber = phoneNumber;
    }

    public OTPDto(String dialCode, String phoneNumber) {
        this.dialCode = dialCode;
        this.phoneNumber = phoneNumber;
    }

    public String getOtpCodes() {
        return otpCodes;
    }

    public void setOtpCodes(String otpCodes) {
        this.otpCodes = otpCodes;
    }

    public String getDialCode() {
        return dialCode;
    }

    public void setDialCode(String dialCode) {
        this.dialCode = dialCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
