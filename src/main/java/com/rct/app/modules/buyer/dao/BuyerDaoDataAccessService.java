package com.rct.app.modules.buyer.dao;

import com.rct.app.commondto.ToggleState;
import com.rct.app.modules.buyer.model.Tender;
import com.rct.app.util.Constants;
import com.rct.app.util.TimeManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("buyer")
public class BuyerDaoDataAccessService implements BuyerDao{
    Logger logger = LoggerFactory.getLogger(BuyerDaoDataAccessService.class);
    private  final JdbcTemplate jdbcTemplate;

    @Autowired
    public BuyerDaoDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Boolean giveTender(UUID id, UUID buyerId, Tender tender) {
        try {
            String sql = "" +
                    "INSERT INTO rct_tender (" +
                    " id, " +
                    " buyer_id, " +
                    " quantity, " +
                    " grade, " +
                    " pickup_location, " +
                    " variety , " +
                    " created_time , " +
                    " updated_time , " +
                    " deleted_time , " +
                    " active , " +
                    " variety ) " +
                    "VALUES (?,?,?,?,?,?,?,?,?)";
            logger.info("Insert User query executed : Time : "+ TimeManager.timeStampToDateAndTime(TimeManager.currentTimeStamp()));
            jdbcTemplate.update(
                    sql,
                    id,
                    buyerId,
                    tender.getBuyerId(),
                    tender.getQuantity(),
                    tender.getGrade(),
                    tender.getPickupLocation(),
                    tender.getVariety(),
                    TimeManager.currentTimeStamp(),
                    Constants.DefaultTime.DEFAULT_TIME,
                    Constants.DefaultTime.DEFAULT_TIME,
                    Constants.Status.TRUE
            );

            for(int i=0; i<tender.getSellerSelection().getIds().size();i++) {
                String sqlBuyersList = "" +
                        "INSERT INTO rct_selected_seller (" +
                        " seller_id, " +
                        " tender_id, " +
                        " created_time , " +
                        " updated_time , " +
                        " deleted_time , " +
                        " active ) " +
                        "VALUES (?,?,?,?,?,?)";
                logger.info("Insert User query executed : Time : " + TimeManager.timeStampToDateAndTime(TimeManager.currentTimeStamp()));
                jdbcTemplate.update(
                        sqlBuyersList,
                        tender.getSellerSelection().getIds().get(i).getSellerId(),
                        id,
                        TimeManager.currentTimeStamp(),
                        Constants.DefaultTime.DEFAULT_TIME,
                        Constants.DefaultTime.DEFAULT_TIME,
                        Constants.Status.TRUE
                );
            }

            return true;
        }catch (Exception exception){
            return false;
        }
    }

    @Override
    public List<Tender> selectAllTenderByUser(UUID id) {
        final String sql = "SELECT * FROM rct_tender  WHERE buyer_id = '"+id+"' ";
        List<Tender> tenderList = jdbcTemplate.query(sql,(resultSet, i)->
        {
            return new Tender(
                    UUID.fromString(resultSet.getString("id")),
                    resultSet.getDouble("quntity"),
                    resultSet.getInt("grade"),
                    resultSet.getString("pickup_location"),
                    resultSet.getString("variety"),
                    TimeManager.timeStampToDateAndTime(Long.parseLong(resultSet.getString("created_time")))
            );
        });
        logger.info("Fetching all Country query executed : Time : "+ TimeManager.timeStampToDateAndTime(TimeManager.currentTimeStamp()));
        return tenderList;
    }

    @Override
    public Optional<Tender> selectTenderById(UUID id) {
        return Optional.empty();
    }

    @Override
    public Boolean deleteTenderById(UUID id) {
        return null;
    }

    @Override
    public Boolean updateTenderById(UUID id, Tender tender) {
        return null;
    }

    @Override
    public Boolean activateOrDisableTender(UUID id, ToggleState toggleState) {
        return null;
    }
}
