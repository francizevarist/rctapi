package com.rct.app.modules.variety.dao;

import com.rct.app.commondto.ToggleState;
import com.rct.app.modules.variety.model.RiceVariety;
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

@Repository("variety")
public class RiceVarietyDataAccessService implements RiceVarietyDao{
    Logger logger = LoggerFactory.getLogger(RiceVarietyDataAccessService.class);
    private  final JdbcTemplate jdbcTemplate;

    @Autowired
    public RiceVarietyDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Boolean insertVariety(UUID id, RiceVariety riceVariety) {
        try {
            String sql = "" +
                    "INSERT INTO rct_variety (" +
                    " id, " +
                    " variety_name, " +
                    " created_time , " +
                    " updated_time , " +
                    " deleted_time , " +
                    " active ) " +
                    "VALUES (?,?,?,?,?,?,?)";
            logger.info("Insert variety query executed : Time : "+ TimeManager.timeStampToDateAndTime(TimeManager.currentTimeStamp()));
            jdbcTemplate.update(
                    sql,
                    id,
                    riceVariety.getVarietyName(),
                    TimeManager.currentTimeStamp(),
                    Constants.DefaultTime.DEFAULT_TIME,
                    Constants.DefaultTime.DEFAULT_TIME,
                    Constants.Status.TRUE
            );
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public List<RiceVariety> selectAllVariety() {
        logger.info("Get all varieties query executed : Time : "+ TimeManager.timeStampToDateAndTime(TimeManager.currentTimeStamp()));
        final String sql = "SELECT id,variety_name,active FROM rct_variety ";
        List<RiceVariety> varieties = jdbcTemplate.query(sql,(resultSet, i)->
        {
            return new RiceVariety(
                    UUID.fromString(resultSet.getString("id")),
                    resultSet.getString("variety_name"),
                    resultSet.getInt("active")
            );
        });
        logger.info("Fetching all varieties query executed : Time : "+TimeManager.timeStampToDateAndTime(TimeManager.currentTimeStamp()));
        return varieties;
    }

    @Override
    public Optional<RiceVariety> selectVarietyById(UUID id) {
        final String sql = "SELECT id,variety_name,active FROM rct_variety WHERE  id = ?";
        RiceVariety variety =  jdbcTemplate.queryForObject(sql,
                new Object[]{id},
                (resultSet,i)->
                {
                    return new RiceVariety(
                            UUID.fromString(resultSet.getString("id")),
                            resultSet.getString("variety_name"),
                            resultSet.getInt("active")
                    );
                });
        logger.info("Get variety query executed : Time : "+TimeManager.timeStampToDateAndTime(TimeManager.currentTimeStamp()));
        return Optional.ofNullable(variety);
    }

    @Override
    public Boolean deleteVarietyById(UUID id) {
        try {
            String expireTime = Long.toString(TimeManager.currentTimeStamp()+Constants.secToMillSec(Constants.OTP.EXPIRE_TIME));
            final String sql = "UPDATE rct_variety SET deleted_time = ? WHERE id = ? ";
            jdbcTemplate.update(sql,TimeManager.currentTimeStamp());
            logger.info("Variety deleted : "+" Time : "+TimeManager.timeStampToDateAndTime(TimeManager.currentTimeStamp()));
            return true;
        }catch (Exception exception){
            return false;
        }
    }

    @Override
    public Boolean updateVarietyById(UUID id, RiceVariety riceVariety) {
        try {
            final String sql = "UPDATE rct_variety SET variety_name =? , updated_time =? WHERE id = ? ";
            jdbcTemplate.update(sql,riceVariety.getVarietyName(),TimeManager.currentTimeStamp(),id);
            logger.info("Price Rate updated : "+" Time : "+TimeManager.timeStampToDateAndTime(TimeManager.currentTimeStamp()));
            return true;
        }catch (Exception exception){
            return false;
        }
    }

    @Override
    public Boolean activateOrDisableVariety(UUID id, ToggleState toggleState) {
        try {
            int status = toggleState.getToggle() == true ? Constants.Status.TRUE : Constants.Status.FALSE ;
            final String sql = "UPDATE rct_variety SET active = ? WHERE id = ?";
            jdbcTemplate.update(sql,status,id);
            logger.info("Variety Status query updated : "+id+" Time : "+TimeManager.timeStampToDateAndTime(TimeManager.currentTimeStamp()));
            return true;
        }catch (Exception exception){
            return false;
        }
    }
}
