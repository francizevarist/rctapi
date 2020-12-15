package com.rct.app.modules.authentication.service;

import com.rct.app.modules.authentication.dao.UserDao;
import com.rct.app.modules.authentication.dto.OTPDto;
import com.rct.app.modules.authentication.model.User;
import com.rct.app.commondto.ToggleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    private final UserDao userDao;

    @Autowired
    public UserService(@Qualifier("user") UserDao userDao) {
        this.userDao = userDao;
    }

    public Boolean insertUser(User user){
        UUID id = UUID.randomUUID();
        return (userDao.insertUser(id,user));

    }

    public List<User> getAllUser(){
       return userDao.selectAllUser();
    }

    public Optional<User> getUserById(UUID id){
        return userDao.selectUserById(id);
    }

    public Optional<User> getUserByPhoneNumber(String phoneNumber){
        return userDao.selectUserByPhoneNumber(phoneNumber);
    }

    public Optional<User> getUserByOtp(String otp){
        return userDao.selectUserByOtp(otp);
    }

    public Boolean deleteUserById(UUID id){
        return userDao.deleteUserById(id);
    }

    public Boolean updateUserById(UUID id, User user){
        return userDao.updateUserById(id,user);
    }

    public Boolean updateUser(User user){
        return userDao.updateUser(user);
    }

    public Boolean updateUserOtp(OTPDto otpDto){
        return userDao.updateUserOtp(otpDto);
    }

    public Boolean verifyUser(OTPDto otpDto){
        return userDao.verifyUser(otpDto);
    }

    public Boolean isProfileCompleted(User user){
        return userDao.isProfileCompleted(user);
    }

    public Boolean isUserExist(User user){
        return userDao.isUserExist(user);
    }

    public Boolean isUserExist(String otp){
        return userDao.isUserExist(otp);
    }

    public Boolean activateOrDisableUser(UUID id, ToggleState toggleState){
        return userDao.activateOrDisableUser(id,toggleState);
    }
}
