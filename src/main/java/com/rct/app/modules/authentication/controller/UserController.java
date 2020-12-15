package com.rct.app.modules.authentication.controller;

import com.rct.app.commondto.ResponseDto;
import com.rct.app.modules.authentication.dto.OTPDto;
import com.rct.app.modules.authentication.model.User;
import com.rct.app.modules.authentication.service.UserService;
import com.rct.app.modules.sms.gateway.CodeGenerator;
import com.rct.app.modules.sms.gateway.TwilioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("api/v1/user")
@RestController
public class UserController {
    Logger logger = LoggerFactory.getLogger(TwilioService.class);
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signin")
    public ResponseEntity signin(@RequestBody User user){
        if(userService.isUserExist(user)){
            return new ResponseEntity(new ResponseDto<>("Login Successfuly"), HttpStatus.OK);
        }else {
            if (userService.insertUser(user)) {
                return new ResponseEntity(new ResponseDto<>("Account Created"), HttpStatus.CREATED);
            } else
            {
                return new ResponseEntity(new ResponseDto<>("Failed To Do Anything"), HttpStatus.EXPECTATION_FAILED);
            }
        }

    }

    @PutMapping("/complete")
    public ResponseEntity completeProfile(@RequestBody User user){
        if(userService.updateUser(user)){
            return new ResponseEntity(new ResponseDto<>("Account Updated"), HttpStatus.OK);
        }else {
            return new ResponseEntity(new ResponseDto<>("Failed To Update Account"), HttpStatus.FAILED_DEPENDENCY);
        }
    }

    @PostMapping("/createotp")
    public ResponseEntity requestOTP(@RequestBody User user){
        String phoneNumber = user.getDialCode()+user.getPhoneNumber();
        String verificationCode = CodeGenerator.get();
        OTPDto otpDto = new OTPDto(verificationCode,user.getDialCode(),user.getPhoneNumber());
        userService.updateUserOtp(otpDto);
        TwilioService twilioService = new TwilioService();
        logger.error(verificationCode);
        twilioService.sendOTP(phoneNumber,"Verification code "+CodeGenerator.format(verificationCode));
        logger.warn(verificationCode+"  formated = "+CodeGenerator.format(verificationCode));
        return new ResponseEntity(new ResponseDto<>(userService.updateUserOtp(otpDto)), HttpStatus.CREATED);
    }

    @PostMapping("/verifyotp")
    public ResponseEntity verifyOTP(@RequestBody OTPDto otpDto){
        if(userService.verifyUser(otpDto)){
            return new ResponseEntity(new ResponseDto<>("Verified Successfuly"), HttpStatus.OK);
        }else {
            return new ResponseEntity(new ResponseDto<>("Failed To Verify"), HttpStatus.EXPECTATION_FAILED);
        }

    }

}
