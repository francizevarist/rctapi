package com.rct.app.modules.authentication.dao;

import com.rct.app.modules.authentication.model.Session;
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

@Repository("session")
public class SessionDataAccessService implements SessionDao{
    Logger logger = LoggerFactory.getLogger(SessionDataAccessService.class);
    private  final JdbcTemplate jdbcTemplate;

    @Autowired
    public SessionDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Deprecated
    public int insertSession(UUID id, Session session) {
        try {
            //check if user active : blocked
            final String sqlValidation = "SELECT CASE WHEN EXISTS (\n" +
                    "    SELECT *\n" +
                    "    FROM  rct_user \n" +
                    "    WHERE active = '"+ Constants.Status.TRUE+"' \n" +
                    "    AND id = ? \n" +
                    ")\n" +
                    "THEN CAST(1 AS BIT)\n" +
                    "ELSE CAST(0 AS BIT) END";

            int sessionStatus =  jdbcTemplate.queryForObject(sqlValidation,
                    new Object[]{session.getUserId()},
                    (resultSet,i)->
                    {
                        return resultSet.getInt("case");
                    });

            logger.error("stats "+sessionStatus);

            if(sessionStatus==Constants.Status.TRUE){
                 String sqlSession = "" +
                        " INSERT INTO authentication (" +
                        " id, " +
                        " user_id, " +
                        " created_time, " +
                        " security_token, " +
                        " refresh_token ) " +
                        " VALUES (?,?,?,?,?) ";

                jdbcTemplate.update(
                        sqlSession,
                        id,
                        session.getUserId(),
                        TimeManager.currentTimeStamp(),
                        session.getSecurityToken(),
                        session.getRefreshToken()
                );
                return 1;
            }else {
                logger.error("user status error");
                return 0;
            }
        }catch (Exception exception){
            logger.error("Exceptional error :"+exception.getMessage());
            return 0;
        }

    }

    @Override
    public List<Session> selectAllSession() {
        logger.info("Get all session query executed : Time : "+ TimeManager.timeStampToDateAndTime(TimeManager.currentTimeStamp()));
        final String sql = "SELECT id,user_id,created_time,security_token FROM authentication ";
        List<Session> sessions = jdbcTemplate.query(sql,(resultSet,i)->
        {
            return new Session(
                    UUID.fromString(resultSet.getString("user_id"))
            );
        });
        logger.info("Fetching all Session query executed : Time : "+TimeManager.timeStampToDateAndTime(TimeManager.currentTimeStamp()));
        return sessions;
    }

    @Override
    public List<Session> selectAllSessionByUser(UUID id) {
        logger.info("Get all session By User query executed : Time : "+ TimeManager.timeStampToDateAndTime(TimeManager.currentTimeStamp()));
        final String sql = "SELECT id,user_id,created_time,security_token FROM authentication WHERE user_id='"+id+"'";
        List<Session> sessions = jdbcTemplate.query(sql,(resultSet,i)->
        {
            return new Session(
                    UUID.fromString(resultSet.getString("user_id"))
            );
        });
        logger.info("Fetching all Session By User query executed : Time : "+TimeManager.timeStampToDateAndTime(TimeManager.currentTimeStamp()));
        return sessions;
    }

    @Override
    public Optional<Session> selectSessionById(UUID id) {
        logger.info("Select session by Id query executed : Time : "+ TimeManager.timeStampToDateAndTime(TimeManager.currentTimeStamp()));
        final String sql = "SELECT id,user_id,created_time,security_token FROM authentication WHERE  id = ?";
        Session session =  jdbcTemplate.queryForObject(sql,
                new Object[]{id},
                (resultSet,i)->
                {
                    return new Session(
                            UUID.fromString(resultSet.getString("user_id"))
                    );
                });
        logger.info("Account object query executed : "+id+" Time : "+TimeManager.timeStampToDateAndTime(TimeManager.currentTimeStamp()));
        return Optional.ofNullable(session);
    }

    @Override
    @Deprecated
    public Optional<Session> selectSessionBySecurityToken(String securityToken) {
        logger.info("Select "+securityToken+" session by  security token query executed : Time : "+ TimeManager.timeStampToDateAndTime(TimeManager.currentTimeStamp()));
        final String sql = "SELECT user_id FROM authentication WHERE  security_token = ?";
        Session session =  jdbcTemplate.queryForObject(sql,
                new Object[]{securityToken},
                (resultSet,i)->
                {
                    return new Session(
                            UUID.fromString(resultSet.getString("user_id"))
                    );
                });

        logger.info("Session by seccurity Token object query executed : Time : "+TimeManager.timeStampToDateAndTime(TimeManager.currentTimeStamp()));
        return Optional.ofNullable(session);
    }

    @Override
    public Optional<Session> selectSessionByRefreshToken(UUID refreshToken) {
        logger.info("Select session by  security token query executed : Time : "+ TimeManager.timeStampToDateAndTime(TimeManager.currentTimeStamp()));
        final String sql = "SELECT id,user_id,created_time,refresh_token,security_token FROM authentication WHERE  refresh_token = ?";
        Session session =  jdbcTemplate.queryForObject(sql,
                new Object[]{refreshToken},
                (resultSet,i)->
                {
                    return new Session(
                            UUID.fromString(resultSet.getString("user_id")),
                            resultSet.getString("security_token")
                    );
                });
        logger.info("Session by seccurity Token object query executed : Time : "+TimeManager.timeStampToDateAndTime(TimeManager.currentTimeStamp()));
        return Optional.ofNullable(session);
    }

    @Override
    public UUID updateSecurityToken(UUID refreshToken, String security_token, UUID newRefreshToken) {
        logger.info("Update session Security Token query executed : Time : "+ TimeManager.timeStampToDateAndTime(TimeManager.currentTimeStamp()));

        final String sql_update_security_token = "UPDATE authentication SET security_token = ? WHERE refresh_token = ?";
        jdbcTemplate.update(sql_update_security_token,security_token,refreshToken);

        final String sql_update_refresh_token = "UPDATE authentication SET refresh_token = ? WHERE refresh_token = ?";
        jdbcTemplate.update(sql_update_refresh_token,newRefreshToken,refreshToken);

        logger.info("Security token query updated : Time : "+TimeManager.timeStampToDateAndTime(TimeManager.currentTimeStamp()));
        return UUID.randomUUID();
    }

    @Override
    public UUID updateProfile(UUID id, UUID profileId) {
        final String sql_update_session_profile = "UPDATE authentication SET profile_id = ? WHERE id = ?";
        jdbcTemplate.update(sql_update_session_profile,profileId,id);
        return id;
    }
}
