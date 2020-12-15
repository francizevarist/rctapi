package com.rct.app.modules.authentication.controller;

import com.rct.app.commondto.JWebToken;
import com.rct.app.commondto.ResponseDto;
import com.rct.app.modules.authentication.dto.GeneratedTokenResponse;
import com.rct.app.modules.authentication.dto.RefreshTokenDto;
import com.rct.app.modules.authentication.dto.RefreshTokenResponse;
import com.rct.app.modules.authentication.model.Session;
import com.rct.app.modules.authentication.model.User;
import com.rct.app.modules.authentication.service.SessionService;
import com.rct.app.modules.authentication.service.TokenAuth;
import com.rct.app.modules.authentication.service.UserService;
import com.rct.app.util.Constants;
import com.rct.app.util.TimeManager;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Optional;
import java.util.UUID;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("api/v1/session")
@RestController
public class SessionController {
    Logger logger = LoggerFactory.getLogger(SessionController.class);
    private final SessionService sessionService;
    private final UserService userService;
    private static final int EXPIRY_SECONDS = Constants.Token.EXPIRE_TIME;

    @Autowired
    public SessionController(SessionService sessionService, UserService userService) {
        this.sessionService = sessionService;
        this.userService = userService;
    }

    @PostMapping("/generatetoken/{otp}")
    public ResponseEntity generateToken(@PathVariable String otp) {

        JSONObject jwtPayload = new JSONObject();
        jwtPayload.put("status", 0);
        JSONArray audArray = new JSONArray();
        audArray.put("user");
        jwtPayload.put("sub",String.valueOf(UUID.randomUUID()));
        jwtPayload.put("aud", audArray);
        LocalDateTime ldt = LocalDateTime.now().plusSeconds(EXPIRY_SECONDS);
        jwtPayload.put("exp", ldt.toEpochSecond(ZoneOffset.UTC)); //this needs to be configured
        String token = new JWebToken(jwtPayload).toString();

        /**
         * Authenticate user and Create Session
         */
        if (userService.isUserExist(otp)) {
            logger.error("user exist");
            Optional<User> userOptional = userService.getUserByOtp(otp);
            UUID userId = userOptional.get().getId();
            UUID refreshToken = UUID.randomUUID();
            sessionService.createSession(new Session(userId,token,refreshToken));
            return new ResponseEntity(new ResponseDto<>(new GeneratedTokenResponse(token,refreshToken)), HttpStatus.CREATED);
        }else {
            return new ResponseEntity(new ResponseDto<>("Failed To Authenticate"),HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("/authenticate")
    public ResponseEntity authenticateToken(@RequestHeader("Authorization") String token, @RequestBody  User user) {
        if (TokenAuth.isTokenValid(token)){
            return new ResponseEntity(new ResponseDto<>("data : "+user.getPhoneNumber()),HttpStatus.OK);
        }else {
            return new ResponseEntity(new ResponseDto<>("Auth Failed"),HttpStatus.OK);
        }
    }

    @PostMapping("/refreshtoken")
    public ResponseEntity refreshToken(@RequestBody RefreshTokenDto refreshTokenDto) {
        Optional<Session> optionalSession = sessionService.getSessionByRefreshToken(UUID.fromString(refreshTokenDto.getRefreshToken()));
        String sessionUserId = String.valueOf(optionalSession.get().getUserId());
        String expiredToken = optionalSession.get().getSecurityToken();
        JWebToken JexpToken = null;
        try {
            JexpToken = new JWebToken(expiredToken);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        if(JexpToken.isValid()){
            logger.error("Token Refresh Denied : {Security Token not Expired}  Time : "+ TimeManager.timeStampToDateAndTime(TimeManager.currentTimeStamp()));
            return new ResponseEntity(new ResponseDto<>(new RefreshTokenResponse(String.valueOf(Constants.Data.NO_VALUE),false)),HttpStatus.CREATED);
        }else{
            JSONObject jwtPayload = new JSONObject();
            jwtPayload.put("status", 0);

            JSONArray audArray = new JSONArray();
            audArray.put("user");
            jwtPayload.put("sub",refreshTokenDto.getRefreshToken());
            jwtPayload.put("aud", audArray);
            LocalDateTime ldt = LocalDateTime.now().plusSeconds(EXPIRY_SECONDS);
            jwtPayload.put("exp", ldt.toEpochSecond(ZoneOffset.UTC)); //this needs to be configured
            String token = new JWebToken(jwtPayload).toString();

            //refresh
            UUID newRefreshToken = UUID.randomUUID();
            sessionService.refreshSecurityToken(UUID.fromString(refreshTokenDto.getRefreshToken()),token,newRefreshToken);

            logger.info("Token Refreshed Successfuly : Time : "+ TimeManager.timeStampToDateAndTime(TimeManager.currentTimeStamp()));
            return new ResponseEntity(new ResponseDto<>(new GeneratedTokenResponse(token,newRefreshToken)),HttpStatus.CREATED);
        }
    }

    @PostMapping("/endsession")
    public ResponseEntity endSession(@RequestBody Session session) {
        return new ResponseEntity(new ResponseDto<>(""), HttpStatus.OK);
    }
}
