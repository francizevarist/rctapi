package com.rct.app.modules.authentication.dao;

import com.rct.app.commondto.ToggleState;
import com.rct.app.modules.authentication.model.User;
import com.rct.app.modules.platform.dao.PlatformDataAccessService;
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

@Repository("leader")
public class LeaderDataAccessService implements LeaderDao{
    Logger logger = LoggerFactory.getLogger(PlatformDataAccessService.class);
    private  final JdbcTemplate jdbcTemplate;

    @Autowired
    public LeaderDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Boolean insertLeaderDao(UUID id, UUID platformId, User user) {
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
                user.getOtp(),
                Constants.Status.TRUE
        );

        String sqlLeader = "" +
                "INSERT INTO rct_leader (" +
                " id, " +
                " platform_id, " +
                " user_id, " +
                " created_time , " +
                " updated_time , " +
                " deleted_time , " +
                " active ) " +
                "VALUES (?,?,?,?,?,?,?)";
        logger.info("Insert User query executed : Time : "+ TimeManager.timeStampToDateAndTime(TimeManager.currentTimeStamp()));
        jdbcTemplate.update(
                sqlLeader,
                id,
                platformId,
                id,
                TimeManager.currentTimeStamp(),
                Constants.DefaultTime.DEFAULT_TIME,
                Constants.DefaultTime.DEFAULT_TIME,
                Constants.Status.TRUE
        );

        return true;
    }

    @Override
    public List<User> selectAllLeader() {
        logger.info("Get all platform query executed : Time : "+ TimeManager.timeStampToDateAndTime(TimeManager.currentTimeStamp()));
        final String sql = "SELECT ru.id AS user_id, ru.dial_code AS dial_code, ru.dial_code AS dial_code, ru.phone_number AS phone_number, ru.name AS name, ru.active AS active  FROM leader \n" +
                "    INNER JOIN  rct_platform p on p.id = rct_leader.platform_id \n" +
                "    INNER JOIN  rct_user ru on leader.user_id = ru.id";
        List<User> platforms = jdbcTemplate.query(sql,(resultSet, i)->
        {
            return new User(
                    UUID.fromString(resultSet.getString("user_id")),
                    resultSet.getString("dial_code"),
                    resultSet.getString("phone_number"),
                    resultSet.getString("name"),
                    resultSet.getInt("active")
            );
        });
        logger.info("Fetching all platform rate query executed : Time : "+TimeManager.timeStampToDateAndTime(TimeManager.currentTimeStamp()));
        return platforms;
    }

    @Override
    public List<User> selectAllLeaderByPlatform(UUID id) {
        final String sql = "SELECT ru.id AS user_id, ru.dial_code AS dial_code, ru.dial_code AS dial_code, ru.phone_number AS phone_number, ru.name AS name, ru.active AS active  FROM leader  +\n" +
                " INNER JOIN  rct_platform p on p.id = rct_leader.platform_id +\n" +
                " INNER JOIN  rct_user ru on leader.user_id = ru.id WHERE platform_id='"+id+"'";
        List<User> platforms = jdbcTemplate.query(sql,(resultSet, i)->
        {
            return new User(
                    UUID.fromString(resultSet.getString("user_id")),
                    resultSet.getString("dial_code"),
                    resultSet.getString("phone_number"),
                    resultSet.getString("name"),
                    resultSet.getInt("active")
            );
        });
        logger.info("Fetching all platform rate query executed : Time : "+TimeManager.timeStampToDateAndTime(TimeManager.currentTimeStamp()));
        return platforms;
    }

    @Override
    public Optional<User> selectLeaderById(UUID id) {
        final String sql = "SELECT ru.id AS user_id, ru.dial_code AS dial_code, ru.dial_code AS dial_code, ru.phone_number AS phone_number, ru.name AS name, ru.active AS active  FROM leader +\n" +
                "  INNER JOIN  rct_platform p on p.id = rct_leader.platform_id +\n" +
                "  INNER JOIN  rct_user ru on leader.user_id = ru.id WHERE rct_leader.id ='"+id+"'";;
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
    public Boolean deleteLeaderById(UUID id) {
        try{
            final String sql = "UPDATE rct_leader SET deleted_time = ?  WHERE id = ? ";
            jdbcTemplate.update(sql,TimeManager.currentTimeStamp(),id);
            logger.info("Use update QUery Excuted Time : "+TimeManager.timeStampToDateAndTime(TimeManager.currentTimeStamp()));
            return true;
        }catch (Exception exception){
            return false;
        }
    }

    @Override
    public Boolean updateLeaderById(UUID id, User user) {
        try{
            String expireTime = Long.toString(TimeManager.currentTimeStamp()+Constants.secToMillSec(Constants.OTP.EXPIRE_TIME));
            final String sql = "UPDATE rct_user SET name = ?  WHERE id = ? ";
            jdbcTemplate.update(sql,user.getName(),id);
            logger.info("Use update QUery Excuted Time : "+TimeManager.timeStampToDateAndTime(TimeManager.currentTimeStamp()));
            return true;
        }catch (Exception exception){
            return false;
        }
    }

    @Override
    public Boolean activateOrDisableLeader(UUID id, ToggleState toggleState) {
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
