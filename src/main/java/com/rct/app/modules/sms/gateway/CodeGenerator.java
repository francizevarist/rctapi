package com.rct.app.modules.sms.gateway;

import com.rct.app.util.Constants;
import com.rct.app.util.TimeManager;

import java.util.Random;

public class CodeGenerator {
    public static String get(){
        String code = Constants.Data.EMPTY_STRING;
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            int appendRandom = random.nextInt(10);
            code = code + appendRandom;
        }
        return code;
    }

    public static String format(String code){
        String characters
                = String.valueOf(code.charAt(0))+
                  String.valueOf(code.charAt(1))+
                  String.valueOf(code.charAt(2))+
                  String.valueOf('-')+
                  String.valueOf(code.charAt(3))+
                  String.valueOf(code.charAt(4))+
                  String.valueOf(code.charAt(5));
        return characters;
    }

    public static String getExpireTime(){
        return Long.toString(TimeManager.currentTimeStamp()+Constants.Twilio.CODE_LIFE_TIME);
    }

    public static Boolean isTokenExpire(Long currentTime, Long TokenTime){
        return currentTime>TokenTime ? true : false;
    }

    public static Boolean isCodeMatch(String providedCode, String generatedCode){
        return providedCode.equals(generatedCode)? true : false;
    }
}
