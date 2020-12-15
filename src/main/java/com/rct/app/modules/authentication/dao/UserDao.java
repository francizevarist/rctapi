package com.rct.app.modules.authentication.dao;

import com.rct.app.modules.authentication.dto.OTPDto;
import com.rct.app.modules.authentication.model.User;
import com.rct.app.commondto.ToggleState;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserDao {
    Boolean insertUser(UUID id, User user);

    List<User> selectAllUser();

    Optional<User> selectUserById(UUID id);

    Optional<User> selectUserByPhoneNumber(String phoneNumber);

    Optional<User> selectUserByOtp(String otp);

    Boolean deleteUserById(UUID id);

    Boolean updateUserById(UUID id, User user);

    Boolean updateUser(User user);

    Boolean updateUserOtp(OTPDto otpDto);

    Boolean verifyUser(OTPDto otpDto);

    Boolean isProfileCompleted(User user);

    Boolean isSeller(User user);

    Boolean isUserExist(User user);

    Boolean isUserExist(String otp);

    Boolean activateOrDisableUser(UUID id, ToggleState toggleState);
}
