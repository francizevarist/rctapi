package com.rct.app.modules.sms.gateway;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.rct.app.util.Constants;
import com.rct.app.util.TimeManager;

public class TwilioService implements Gateway{
    Logger logger = LoggerFactory.getLogger(TwilioService.class);

    public TwilioService() {}
    @Override
    public void sendOTP(String phoneNumber,String message) {
        Twilio.init(Constants.Twilio.ACCOUNT_SID,Constants.Twilio.AUTH_TOKEN);
        Message msg = Message.creator(new PhoneNumber(phoneNumber),
                new PhoneNumber(Constants.Twilio.SENDER_NUMBER),
                message).create();
        logger.info("OTP sent Successfuly  SID: "+msg.getAccountSid()+" Phone number :( "+phoneNumber+" ) TIME : "+ TimeManager.timeStampToDateAndTime(TimeManager.currentTimeStamp()));
    }
}
