package com.rct.app.modules.platform.dao;

import com.rct.app.commondto.ToggleState;
import com.rct.app.modules.platform.model.Platform;
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

@Repository("platform")
public class PlatformDataAccessService implements PlatformDao{
    Logger logger = LoggerFactory.getLogger(PlatformDataAccessService.class);
    private  final JdbcTemplate jdbcTemplate;

    @Autowired
    public PlatformDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Boolean insertPlatform(UUID id,Platform platform) {
        String sql = "" +
                "INSERT INTO rct_platform (" +
                " id, " +
                " platform_name, " +
                " platform_country_dial_code, " +
                " platform_region, " +
                " created_time , " +
                " updated_time , " +
                " deleted_time , " +
                " active ) " +
                "VALUES (?,?,?,?,?,?,?,?)";
        logger.info("Insert price rate query executed : Time : "+ TimeManager.timeStampToDateAndTime(TimeManager.currentTimeStamp()));
        jdbcTemplate.update(
                sql,
                id,
                platform.getPlatformName(),
                platform.getPlatformCountryDialCode(),
                platform.getPlatformRegion(),
                TimeManager.currentTimeStamp(),
                Constants.DefaultTime.DEFAULT_TIME,
                Constants.DefaultTime.DEFAULT_TIME,
                Constants.Status.TRUE
        );
        return true;
    }

    @Override
    public List<Platform> selectAllPlatform() {
        logger.info("Get all platform query executed : Time : "+ TimeManager.timeStampToDateAndTime(TimeManager.currentTimeStamp()));
        final String sql = "SELECT id,platform_name,platform_country_dial_code,platform_region,active FROM rct_platform ";
        List<Platform> platforms = jdbcTemplate.query(sql,(resultSet, i)->
        {
            return new Platform(
                    UUID.fromString(resultSet.getString("id")),
                    resultSet.getString("platform_name"),
                    resultSet.getString("platform_country_dial_code"),
                    resultSet.getString("platform_region"),
                    resultSet.getInt("active")
            );
        });
        logger.info("Fetching all platform rate query executed : Time : "+TimeManager.timeStampToDateAndTime(TimeManager.currentTimeStamp()));
        return platforms;
    }

    @Override
    public List<Platform> selectAllPlatformByRegion(String region) {
        logger.info("Get all platform query executed : Time : "+ TimeManager.timeStampToDateAndTime(TimeManager.currentTimeStamp()));
        final String sql = "SELECT id,platform_name,platform_country_dial_code,platform_region,active FROM rct_platform WHERE platform_region='"+region+"'";
        List<Platform> platforms = jdbcTemplate.query(sql,(resultSet, i)->
        {
            return new Platform(
                    UUID.fromString(resultSet.getString("id")),
                    resultSet.getString("platform_name"),
                    resultSet.getString("platform_country_dial_code"),
                    resultSet.getString("platform_region"),
                    resultSet.getInt("active")
            );
        });
        logger.info("Fetching all platform rate query executed : Time : "+TimeManager.timeStampToDateAndTime(TimeManager.currentTimeStamp()));
        return platforms;
    }

    @Override
    public List<Platform> selectAllPlatformByCountryRegion(String countryDialCode, String region) {
        logger.info("Get all platform query executed : Time : "+ TimeManager.timeStampToDateAndTime(TimeManager.currentTimeStamp()));
        final String sql = "SELECT id,platform_name,platform_country_dial_code,platform_region,active FROM rct_platform WHERE platform_country_dial_code = '"+countryDialCode+"' AND  platform_region='"+region+"'";
        List<Platform> platforms = jdbcTemplate.query(sql,(resultSet, i)->
        {
            return new Platform(
                    UUID.fromString(resultSet.getString("id")),
                    resultSet.getString("platform_name"),
                    resultSet.getString("platform_country_dial_code"),
                    resultSet.getString("platform_region"),
                    resultSet.getInt("active")
            );
        });
        logger.info("Fetching all platform rate query executed : Time : "+TimeManager.timeStampToDateAndTime(TimeManager.currentTimeStamp()));
        return platforms;
    }

    @Override
    public List<Platform> selectAllPlatformByCountry(String countryDialCode) {
        logger.info("Get all platform query executed : Time : "+ TimeManager.timeStampToDateAndTime(TimeManager.currentTimeStamp()));
        final String sql = "SELECT id,platform_name,platform_country_dial_code,platform_region,active FROM rct_platform WHERE platform_country_dial_code = '"+countryDialCode+"'";
        List<Platform> platforms = jdbcTemplate.query(sql,(resultSet, i)->
        {
            return new Platform(
                    UUID.fromString(resultSet.getString("id")),
                    resultSet.getString("platform_name"),
                    resultSet.getString("platform_country_dial_code"),
                    resultSet.getString("platform_region"),
                    resultSet.getInt("active")
            );
        });
        logger.info("Fetching all platform rate query executed : Time : "+TimeManager.timeStampToDateAndTime(TimeManager.currentTimeStamp()));
        return platforms;
    }

    @Override
    public Optional<Platform> selectPlatformById(UUID id) {
        final String sql = "SELECT * FROM rct_platform WHERE  id = ?";
        Platform platform =  jdbcTemplate.queryForObject(sql,
                new Object[]{id},
                (resultSet,i)->
                {
                    return new Platform(
                            UUID.fromString(resultSet.getString("id")),
                            resultSet.getString("platform_name"),
                            resultSet.getString("platform_country_dial_code"),
                            resultSet.getString("platform_region"),
                            resultSet.getInt("active")
                    );
                });

        logger.info("Session by id object query executed : Time : "+TimeManager.timeStampToDateAndTime(TimeManager.currentTimeStamp()));
        return Optional.ofNullable(platform);
    }

    @Override
    public Boolean deletePlatform(UUID id) {
        try {
            String expireTime = Long.toString(TimeManager.currentTimeStamp()+Constants.secToMillSec(Constants.OTP.EXPIRE_TIME));
            final String sql = "UPDATE rct_platform SET deleted_time = ? WHERE id = ? ";
            jdbcTemplate.update(sql,TimeManager.currentTimeStamp());
            logger.info("Account deleted : "+" Time : "+TimeManager.timeStampToDateAndTime(TimeManager.currentTimeStamp()));
            return true;
        }catch (Exception exception){
            return false;
        }
    }

    @Override
    public Boolean updatePlatform(UUID id, Platform platform) {
        try {
            final String sql = "UPDATE rct_platform SET platform_name = ? ,platform_country_dial_code = ?, platform_region = ? , updated_time = ? WHERE id = ? ";
            jdbcTemplate.update(sql,platform.getPlatformName(), platform.getPlatformCountryDialCode(), platform.getPlatformRegion(), TimeManager.currentTimeStamp());
            logger.info("Account deleted : "+" Time : "+TimeManager.timeStampToDateAndTime(TimeManager.currentTimeStamp()));
            return true;
        }catch (Exception exception){
            return false;
        }
    }

    @Override
    public Boolean activateOrDisablePlatform(UUID id, ToggleState toggleState) {
        try {
            int status = toggleState.getToggle() == true ? Constants.Status.TRUE : Constants.Status.FALSE ;
            final String sql = "UPDATE rct_platform SET active = ? WHERE id = ?";
            jdbcTemplate.update(sql,status,id);
            logger.info("Price Rate Status query updated : "+id+" Time : "+TimeManager.timeStampToDateAndTime(TimeManager.currentTimeStamp()));
            return true;
        }catch (Exception exception){
            return false;
        }
    }
}
