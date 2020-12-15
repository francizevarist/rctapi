package com.rct.app.modules.price.dao;

import com.rct.app.commondto.ToggleState;
import com.rct.app.modules.price.model.PriceRate;
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

@Repository("pricerate")
public class PriceRateDataAccessService implements PriceRateDao{
    Logger logger = LoggerFactory.getLogger(PriceRateDataAccessService.class);
    private  final JdbcTemplate jdbcTemplate;

    @Autowired
    public PriceRateDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Boolean insertPriceRate(UUID id, PriceRate priceRate) {
        try {
            String sql = "" +
                    "INSERT INTO price_rate (" +
                    " id, " +
                    " region, " +
                    " price_rate, " +
                    " created_time , " +
                    " updated_time , " +
                    " deleted_time , " +
                    " active ) " +
                    "VALUES (?,?,?,?,?,?,?)";
            logger.info("Insert price rate query executed : Time : "+ TimeManager.timeStampToDateAndTime(TimeManager.currentTimeStamp()));
            jdbcTemplate.update(
                    sql,
                    id,
                    priceRate.getRegion(),
                    priceRate.getPriceRate(),
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
    public List<PriceRate> selectAllPriceRate() {
        logger.info("Get all price rate query executed : Time : "+ TimeManager.timeStampToDateAndTime(TimeManager.currentTimeStamp()));
        final String sql = "SELECT id,region,price_rate,active FROM price_rate ";
        List<PriceRate> sessions = jdbcTemplate.query(sql,(resultSet,i)->
        {
            return new PriceRate(
                    UUID.fromString(resultSet.getString("id")),
                    resultSet.getString("region"),
                    resultSet.getDouble("price_rate"),
                    resultSet.getInt("active")
            );
        });
        logger.info("Fetching all price rate query executed : Time : "+TimeManager.timeStampToDateAndTime(TimeManager.currentTimeStamp()));
        return sessions;
    }

    @Override
    public Optional<PriceRate> selectPriceRateById(UUID id) {
        final String sql = "SELECT id,region,price_rate,active FROM price_rate WHERE  id = ?";
        PriceRate priceRate =  jdbcTemplate.queryForObject(sql,
                new Object[]{id},
                (resultSet,i)->
                {
                    return new PriceRate(
                            UUID.fromString(resultSet.getString("id")),
                            resultSet.getString("region"),
                            resultSet.getDouble("price_rate"),
                            resultSet.getInt("active")
                    );
                });
        logger.info("price rate by id object query executed : Time : "+TimeManager.timeStampToDateAndTime(TimeManager.currentTimeStamp()));
        return Optional.ofNullable(priceRate);
    }

    @Override
    public Optional<PriceRate> selectPriceRateByRegion(String region) {
        final String sql = "SELECT id,region,price_rate,active FROM price_rate WHERE  region = ?";
        PriceRate priceRate =  jdbcTemplate.queryForObject(sql,
                new Object[]{region},
                (resultSet,i)->
                {
                    return new PriceRate(
                            UUID.fromString(resultSet.getString("id")),
                            resultSet.getString("region"),
                            resultSet.getDouble("price_rate"),
                            resultSet.getInt("active")
                    );
                });
        logger.info("price rate by id object query executed : Time : "+TimeManager.timeStampToDateAndTime(TimeManager.currentTimeStamp()));
        return Optional.ofNullable(priceRate);
    }

    @Override
    public Boolean deletePriceRateById(UUID id) {
        try {
            String expireTime = Long.toString(TimeManager.currentTimeStamp()+Constants.secToMillSec(Constants.OTP.EXPIRE_TIME));
            final String sql = "UPDATE price_rate SET deleted_time = ? WHERE id = ? ";
            jdbcTemplate.update(sql,TimeManager.currentTimeStamp());
            logger.info("price rate deleted : "+" Time : "+TimeManager.timeStampToDateAndTime(TimeManager.currentTimeStamp()));
            return true;
        }catch (Exception exception){
            return false;
        }
    }

    @Override
    public Boolean updatePriceRateById(UUID id, PriceRate user) {
        try {
            final String sql = "UPDATE price_rate SET region =? , price_rate =?, updated_time =? WHERE id = ? ";
            jdbcTemplate.update(sql,user.getRegion(),user.getPriceRate(),TimeManager.currentTimeStamp(),id);
            logger.info("Price Rate updated : "+" Time : "+TimeManager.timeStampToDateAndTime(TimeManager.currentTimeStamp()));
            return true;
        }catch (Exception exception){
            return false;
        }
    }

    @Override
    public Boolean activateOrDisableUser(UUID id, ToggleState toggleState) {
        try {
            int status = toggleState.getToggle() == true ? Constants.Status.TRUE : Constants.Status.FALSE ;
            final String sql = "UPDATE price_rate SET active = ? WHERE id = ?";
            jdbcTemplate.update(sql,status,id);
            logger.info("Price Rate Status query updated : "+id+" Time : "+TimeManager.timeStampToDateAndTime(TimeManager.currentTimeStamp()));
            return true;
        }catch (Exception exception){
            return false;
        }
    }
}
