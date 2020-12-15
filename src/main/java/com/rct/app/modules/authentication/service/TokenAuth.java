package com.rct.app.modules.authentication.service;

import com.rct.app.commondto.JWebToken;
import com.rct.app.util.Constants;

import java.security.NoSuchAlgorithmException;

public class TokenAuth {
    public static Boolean isTokenValid(String token){
        JWebToken incomingToken = null;
        try {
            incomingToken = new JWebToken(Constants.Token.reformat(token));
            if(incomingToken.isValid()){
                return true;
            }else {
                return false;
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return false;
        }
    }
    public static String TOKEN_ERROR = "Token Error :Header Bombarded with  Expired or Invalid Token";
}
