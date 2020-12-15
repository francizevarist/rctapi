package com.rct.app.modules.sms.gateway;

public interface Gateway {
    void sendOTP(String phoneNumber, String message);
}
