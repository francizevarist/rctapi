package com.rct.app.modules.authentication.dao;

import com.rct.app.commondto.ToggleState;
import com.rct.app.modules.authentication.dto.OTPDto;
import com.rct.app.modules.authentication.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.rct.app.util.Constants;
import com.rct.app.util.TimeManager;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository("user")
public class UserDataAccessService implements UserDao{
    Logger logger = LoggerFactory.getLogger(UserDataAccessService.class);
    private  final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public Boolean insertUser(UUID id, User user) {
        try {
            String sql = "" +
                    "INSERT INTO rct_user (" +
                    " id, " +
                    " dial_code, " +
                    " phone_number, " +
                    " user_name, " +
                    " created_time , " +
                    " updated_time , " +
                    " deleted_time , " +
                    " otp , " +
                    " active ) " +
                    "VALUES (?,?,?,?,?,?,?,?,?)";
            logger.info("Insert User query executed : Time : "+ TimeManager.timeStampToDateAndTime(TimeManager.currentTimeStamp()));
            jdbcTemplate.update(
                    sql,
                    id,
                    user.getDialCode(),
                    user.getPhoneNumber(),
                    user.getName(),
                    TimeManager.currentTimeStamp(),
                    Constants.DefaultTime.DEFAULT_TIME,
                    Constants.DefaultTime.DEFAULT_TIME,
                    Constants.Data.NO_VALUE,
                    Constants.Status.TRUE
            );
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public List<User> selectAllUser() {
        return null;
    }

    @Override
    @Deprecated
    public Optional<User> selectUserById(UUID id) {
        final String sql = "SELECT * FROM rct_user WHERE  id = ?";
        User user =  jdbcTemplate.queryForObject(sql,
                new Object[]{id},
                (resultSet,i)->
                {
                    return new User(
                            UUID.fromString(resultSet.getString("id")),
                            resultSet.getString("dial_code"),
                            resultSet.getString("phone_number"),
                            resultSet.getString("name"),
                            resultSet.getInt("active")
                    );
                });

        logger.info("Session by id object query executed : Time : "+TimeManager.timeStampToDateAndTime(TimeManager.currentTimeStamp()));
        return Optional.ofNullable(user);
    }

    @Override
    public Optional<User> selectUserByPhoneNumber(String phoneNumber) {
        final String sql = "SELECT * FROM rct_user WHERE  phone_number = ?";
        User user =  jdbcTemplate.queryForObject(sql,
                new Object[]{phoneNumber},
                (resultSet,i)->
                {
                    return new User(
                            UUID.fromString(resultSet.getString("id")),
                            resultSet.getString("dial_code"),
                            resultSet.getString("phone_number"),
                            resultSet.getString("name"),
                            resultSet.getInt("active")
                    );
                });

        logger.info("Session by phone number Token object query executed : Time : "+TimeManager.timeStampToDateAndTime(TimeManager.currentTimeStamp()));
        return Optional.ofNullable(user);
    }

    @Override
    public Optional<User> selectUserByOtp(String otp) {
        final String sql = "SELECT * FROM rct_user WHERE otp = ?";
        User user =  jdbcTemplate.queryForObject(sql,
                new Object[]{otp},
                (resultSet,i)->
                {
                    return new User(
                            UUID.fromString(resultSet.getString("id")),
                            resultSet.getString("dial_code"),
                            resultSet.getString("phone_number"),
                            resultSet.getString("user_name"),
                            resultSet.getInt("active")
                    );
                });

        logger.info("Session by phone number Token object query executed : Time : "+TimeManager.timeStampToDateAndTime(TimeManager.currentTimeStamp()));
        return Optional.ofNullable(user);
    }

    @Override
    public Boolean deleteUserById(UUID id) {
        try {
            String expireTime = Long.toString(TimeManager.currentTimeStamp()+Constants.secToMillSec(Constants.OTP.EXPIRE_TIME));
            final String sql = "UPDATE rct_user SET deleted_time = ? WHERE id = ? ";
            jdbcTemplate.update(sql,TimeManager.currentTimeStamp());
            logger.info("Account deleted : "+" Time : "+TimeManager.timeStampToDateAndTime(TimeManager.currentTimeStamp()));
            return true;
        }catch (Exception exception){
            return false;
        }
    }

    @Override
    public Boolean updateUserById(UUID id, User user) {
        try{
            String expireTime = Long.toString(TimeManager.currentTimeStamp()+Constants.secToMillSec(Constants.OTP.EXPIRE_TIME));
            final String sql = "UPDATE rct_user SET user_name = ?  WHERE id = ? ";
            jdbcTemplate.update(sql,user.getName(),id);
            logger.info("Use update QUery Excuted Time : "+TimeManager.timeStampToDateAndTime(TimeManager.currentTimeStamp()));
            return true;
        }catch (Exception exception){
            return false;
        }
    }

    @Override
    public Boolean updateUser(User user) {
        try{
            final String sql = "UPDATE rct_user SET user_name = ?  WHERE dial_code = ? AND phone_number = ? ";
            jdbcTemplate.update(sql,user.getName(),user.getDialCode(),user.getPhoneNumber());
            logger.info("Use update QUery Excuted Time : "+TimeManager.timeStampToDateAndTime(TimeManager.currentTimeStamp()));
            return true;
        }catch (Exception exception){
            return false;
        }
    }

    @Override
    public Boolean updateUserOtp(OTPDto otpDto) {
        try{
            String expireTime = Long.toString(TimeManager.currentTimeStamp()+Constants.secToMillSec(Constants.OTP.EXPIRE_TIME));
            final String sql = "UPDATE rct_user SET otp = ?, otp_expire_time = ? WHERE dial_code = ? AND phone_number = ? ";
            jdbcTemplate.update(sql,otpDto.getOtpCodes(),expireTime,otpDto.getDialCode(),otpDto.getPhoneNumber());
            logger.info("OTP codes details query updated : "+otpDto.getDialCode()+otpDto.getPhoneNumber()+" Time : "+TimeManager.timeStampToDateAndTime(TimeManager.currentTimeStamp()));
            return true;
        }catch (Exception exception){
            return false;
        }
    }

    @Override
    public Boolean verifyUser(OTPDto otpDto) {
        logger.error(otpDto.getOtpCodes()+"   "+otpDto.getDialCode()+"   "+otpDto.getPhoneNumber());
        final String sqlValidation = "SELECT CASE WHEN EXISTS (\n" +
                "    SELECT * \n" +
                "    FROM rct_user \n" +
                "    WHERE otp = ? \n" +
                "    AND otp_expire_time >= '"+TimeManager.currentTimeStamp()+"' \n" +
                ") \n" +
                "THEN CAST(1 AS BIT)\n" +
                "ELSE CAST(0 AS BIT) END";

        int verification =  jdbcTemplate.queryForObject(sqlValidation,
                new Object[]{otpDto.getOtpCodes()},
                (resultSet,i)->
                {
                    return resultSet.getInt("case");
                });

        return verification==Constants.Status.TRUE ? true : false;
    }

    @Override
    public Boolean isProfileCompleted(User user) {
        try {
            final String sql = "SELECT * FROM rct_user WHERE  phone_number = ?";
            User userInfo =  jdbcTemplate.queryForObject(sql,
                    new Object[]{user.getPhoneNumber()},
                    (resultSet,i)->
                    {
                        return new User(
                                resultSet.getString("name")
                        );
                    });

            logger.info("User profile check-up object query executed : Time : "+TimeManager.timeStampToDateAndTime(TimeManager.currentTimeStamp()));
            if(Optional.ofNullable(user).get().getName().trim().equals(Constants.Data.EMPTY_STRING)){
                return false;
            }else {
                return true;
            }
        }catch (Exception exception){
            return false;
        }
    }

    @Override
    public Boolean isSeller(User user) {
        final String sqlValidation = "SELECT CASE WHEN EXISTS (\n" +
                "    SELECT * \n" +
                "    FROM rct_user \n" +
                "    WHERE phone_number = ? \n" +
                "    AND dial_code = '"+user.getDialCode()+"' \n" +
                ") \n" +
                "THEN CAST(1 AS BIT) \n" +
                "ELSE CAST(0 AS BIT) END";

        int existence =  jdbcTemplate.queryForObject(sqlValidation,
                new Object[]{user.getPhoneNumber()},
                (resultSet,i)->
                {
                    return resultSet.getInt("case");
                });
        return existence == Constants.Status.TRUE ? true : false ;
    }

    @Override
    public Boolean isUserExist(User user) {
        final String sqlValidation = "SELECT CASE WHEN EXISTS (\n" +
                "    SELECT * \n" +
                "    FROM rct_user \n" +
                "    WHERE phone_number = ? \n" +
                "    AND dial_code = '"+user.getDialCode()+"' \n" +
                ") \n" +
                "THEN CAST(1 AS BIT) \n" +
                "ELSE CAST(0 AS BIT) END";

        int existence =  jdbcTemplate.queryForObject(sqlValidation,
                new Object[]{user.getPhoneNumber()},
                (resultSet,i)->
                {
                    return resultSet.getInt("case");
                });
        return existence == Constants.Status.TRUE ? true : false ;
    }

    @Override
    public Boolean isUserExist(String otp) {
        final String sqlValidation = "SELECT CASE WHEN EXISTS (\n" +
                "    SELECT * \n" +
                "    FROM rct_user \n" +
                "    WHERE otp = ? \n" +
                ")\n" +
                "THEN CAST(1 AS BIT)\n" +
                "ELSE CAST(0 AS BIT) END";

        int existence =  jdbcTemplate.queryForObject(sqlValidation,
                new Object[]{otp},
                (resultSet,i)->
                {
                    return resultSet.getInt("case");
                });
        return existence == Constants.Status.TRUE ? true : false ;
    }

    @Override
    public Boolean activateOrDisableUser(UUID id, ToggleState toggleState) {
        try {
            int status = toggleState.getToggle() == true ? Constants.Status.TRUE : Constants.Status.FALSE ;
            final String sql = "UPDATE rct_user SET active = ? WHERE id = ?";
            jdbcTemplate.update(sql,status,id);
            logger.info("User Status query updated : "+id+" Time : "+TimeManager.timeStampToDateAndTime(TimeManager.currentTimeStamp()));
            return true;
        }catch (Exception exception){
            return false;
        }
    }
}
