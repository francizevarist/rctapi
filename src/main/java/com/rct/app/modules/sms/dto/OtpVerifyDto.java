package com.rct.app.modules.sms.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OtpVerifyDto {

    @JsonProperty("dial_code")
    private  String dialCode;

    @JsonProperty("phone_number")
    private  String phoneNumber;

    @JsonProperty("otpcode")
    private  String otpcode;

    public OtpVerifyDto() {}

    public OtpVerifyDto(String dialCode, String phoneNumber, String otpcode) {
        this.dialCode = dialCode;
        this.phoneNumber = phoneNumber;
        this.otpcode = otpcode;
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

    public String getOtpcode() {
        return otpcode;
    }

    public void setOtpcode(String otpcode) {
        this.otpcode = otpcode;
    }

}
