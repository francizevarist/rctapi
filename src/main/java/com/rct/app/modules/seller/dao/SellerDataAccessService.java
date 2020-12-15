package com.rct.app.modules.seller.dao;

import com.rct.app.commondto.ToggleState;
import com.rct.app.modules.authentication.dao.UserDataAccessService;
import com.rct.app.modules.authentication.model.User;
import com.rct.app.modules.seller.model.RequestTender;
import com.rct.app.modules.seller.model.Seller;
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

@Repository("seller")
public class SellerDataAccessService implements SellerDao{
    Logger logger = LoggerFactory.getLogger(UserDataAccessService.class);
    private  final JdbcTemplate jdbcTemplate;

    @Autowired
    public SellerDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<RequestTender> selectAllTender() {
        final String sql = "select rs.is AS id, quantity,selling_price,is_graded,is_batch_certified,pickup_location,extra_details,active,variety from rct_seller_tender_request \n" +
                "inner join rct_seller rs on tender.seller_id = rs.id ";
        List<RequestTender> requestTenders = jdbcTemplate.query(sql,(resultSet, i)->
        {
            return new RequestTender(
                    UUID.fromString(resultSet.getString("id")),
                    resultSet.getDouble("quantity"),
                    resultSet.getDouble("selling_price"),
                    resultSet.getInt("is_graded")==1 ? true:false,
                    resultSet.getInt("grade"),
                    resultSet.getInt("is_batch_certified")==1 ? true:false,
                    resultSet.getString("pickup_location"),
                    resultSet.getString("extra_details"),
                    resultSet.getInt("active"),
                    resultSet.getString("variety")
            );
        });

        logger.info("Fetching all platform rate query executed : Time : "+TimeManager.timeStampToDateAndTime(TimeManager.currentTimeStamp()));
        return requestTenders;
    }

    @Override
    public List<RequestTender> selectAllTenderByUser(UUID id) {
        final String sql = "select rs.is AS id, quantity,selling_price,is_graded,is_batch_certified,pickup_location,extra_details,active,variety from rct_seller_tender_request \n" +
                "inner join rct_seller rs on tender.seller_id = rs.id \n" +
                "WHERE rs.id='"+id+"'";
        List<RequestTender> requestTenders = jdbcTemplate.query(sql,(resultSet, i)->
        {
            return new RequestTender(
                    UUID.fromString(resultSet.getString("id")),
                    resultSet.getDouble("quantity"),
                    resultSet.getDouble("selling_price"),
                    resultSet.getInt("is_graded")==1 ? true:false,
                    resultSet.getInt("grade"),
                    resultSet.getInt("is_batch_certified")==1 ? true:false,
                    resultSet.getString("pickup_location"),
                    resultSet.getString("extra_details"),
                    resultSet.getInt("active"),
                    resultSet.getString("variety")
            );
        });

        logger.info("Fetching all platform rate query executed : Time : "+TimeManager.timeStampToDateAndTime(TimeManager.currentTimeStamp()));
        return requestTenders;
    }

    @Override
    public Optional<RequestTender> selectTenderById(UUID id) {
        final String sql = "select * from rct_seller_tender_request where id='"+id+"'";
        RequestTender requestTender =  jdbcTemplate.queryForObject(sql,
                new Object[]{id},
                (resultSet,i)->
                {
                    return new RequestTender(
                            UUID.fromString(resultSet.getString("id")),
                            resultSet.getDouble("quantity"),
                            resultSet.getDouble("selling_price"),
                            resultSet.getInt("is_graded")==1 ? true:false,
                            resultSet.getInt("grade"),
                            resultSet.getInt("is_batch_certified")==1 ? true:false,
                            resultSet.getString("pickup_location"),
                            resultSet.getString("extra_details"),
                            resultSet.getInt("active"),
                            resultSet.getString("variety")
                    );
                });

        logger.info("Session by id object query executed : Time : "+TimeManager.timeStampToDateAndTime(TimeManager.currentTimeStamp()));
        return Optional.ofNullable(requestTender);
    }

    @Override
    public Boolean insertSellerDao(UUID id, UUID leaderId, User user, Seller seller) {
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

        String sqlSeller = "" +
                "INSERT INTO rct_seller (" +
                " id, " +
                " leader_id, " +
                " user_id, " +
                " first_time, " +
                " last_name, " +
                " application_type, " +
                " address, " +
                " website, " +
                " grade, " +
                " experience, " +
                " tbs_certification_number, " +
                " certification_number, " +
                " variety_name, " +
                " created_time , " +
                " updated_time , " +
                " deleted_time , " +
                " active ) " +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        logger.info("Insert User query executed : Time : "+ TimeManager.timeStampToDateAndTime(TimeManager.currentTimeStamp()));
        jdbcTemplate.update(
                sqlSeller,
                id,
                leaderId,
                id,
                seller.getFirstName(),
                seller.getLastName(),
                seller.getApplicationType(),
                seller.getAddress(),
                seller.getWebsite(),
                seller.getGrade(),
                seller.getExperience(),
                seller.getTbsCertificationNumber(),
                seller.getCertificationNumber(),
                seller.getVarietyName(),
                TimeManager.currentTimeStamp(),
                Constants.DefaultTime.DEFAULT_TIME,
                Constants.DefaultTime.DEFAULT_TIME,
                Constants.Status.TRUE
        );
        return true;
    }

    @Override
    public List<User> selectAllSeller() {
        logger.info("Get all platform query executed : Time : "+ TimeManager.timeStampToDateAndTime(TimeManager.currentTimeStamp()));
        final String sql = "SELECT ru.id AS user_id, ru.dial_code AS dial_code, ru.dial_code AS dial_code, ru.phone_number AS phone_number, ru.user_name AS name, ru.active AS active  FROM rct_seller \n" +
                "    INNER JOIN  rct_user ru on rct_seller.user_id = ru.id ";
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
    public List<User> selectAllSellerByLeader(UUID id) {
        final String sql = "SELECT ru.id AS user_id, ru.dial_code AS dial_code, ru.dial_code AS dial_code, ru.phone_number AS phone_number, ru.name AS name, ru.active AS active  from rct_seller \n" +
                "inner join rct_leader l on rct_seller.user_id = l.user_id\n" +
                "inner join rct_user ru on rct_seller.user_id = ru.id\n" +
                "inner join rct_leader l2 on rct_seller.leader_id = l2.leader_id\n" +
                "where l2.leader_id = '"+id+"'";
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
    public List<User> selectAllSellerByPlatform(UUID id) {
        logger.info("Get all platform query executed : Time : "+ TimeManager.timeStampToDateAndTime(TimeManager.currentTimeStamp()));
        final String sql = "SELECT ru.id AS user_id, ru.dial_code AS dial_code, ru.dial_code AS dial_code, ru.phone_number AS phone_number, ru.user_name AS name, ru.active AS active  FROM rct_seller \n" +
                "    INNER JOIN  rct_user ru on rct_seller.user_id = ru.id " +
                "    INNER JOIN  rct_leader rl on rct_seller.user_id = rl.user_id " +
                "    INNER JOIN  rct_platform rp on rct_leader.platform_id = rp.id " +
                "    WHERE rp.id = '"+id+"'";
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
    public Optional<User> selectSellerById(UUID id) {
        final String sql = "SELECT ru.id AS user_id, ru.dial_code AS dial_code, ru.dial_code AS dial_code, ru.phone_number AS phone_number, ru.user_name AS name, ru.active AS active  FROM rct_seller  \n" +
                " INNER JOIN  rct_user ru on rct_seller.user_id = ru.id \n" +
                " WHERE rct_seller.id=?";
        User user =  jdbcTemplate.queryForObject(sql,
                new Object[]{id},
                (resultSet,i)->
                {
                    return new User(
                            UUID.fromString(resultSet.getString("user_id")),
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
    public Boolean deleteSellerById(UUID id) {
        try{
            final String sql = "UPDATE rct_seller SET deleted_time = ?  WHERE id = ? ";
            jdbcTemplate.update(sql,TimeManager.currentTimeStamp(),id);
            logger.info("Use update QUery Excuted Time : "+TimeManager.timeStampToDateAndTime(TimeManager.currentTimeStamp()));
            return true;
        }catch (Exception exception){
            return false;
        }
    }

    @Override
    public Boolean updateSellerById(UUID id, User user) {
        try{
            String expireTime = Long.toString(TimeManager.currentTimeStamp()+Constants.secToMillSec(Constants.OTP.EXPIRE_TIME));
            final String sql = "UPDATE rct_seller SET name = ?  WHERE id = ? ";
            jdbcTemplate.update(sql,user.getName(),id);
            logger.info("Use update QUery Excuted Time : "+TimeManager.timeStampToDateAndTime(TimeManager.currentTimeStamp()));
            return true;
        }catch (Exception exception){
            return false;
        }
    }

    @Override
    public Boolean activateOrDisableSeller(UUID id, ToggleState toggleState) {
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

    @Override
    public Boolean requestTender(UUID id,UUID sellerId, RequestTender requestTender) {
        logger.error("let see the size first   =  "+requestTender.getBuyerSelection().getIds().size());
        String sql = "" +
                "INSERT INTO rct_seller_tender_request (" +
                " id, " +
                " seller_id, " +
                " quantity, " +
                " selling_price, " +
                " is_graded, " +
                " grade , " +
                " is_batch_certified , " +
                " pickup_location , " +
                " extra_details , " +
                " created_time , " +
                " updated_time , " +
                " deleted_time , " +
                " active , " +
                " variety ) " +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        logger.info("Insert User query executed : Time : "+ TimeManager.timeStampToDateAndTime(TimeManager.currentTimeStamp()));
        jdbcTemplate.update(
                sql,
                id,
                sellerId,
                requestTender.getQuantity(),
                requestTender.getSellingPrice(),
                requestTender.getGraded()==true?1:0,
                requestTender.getGrade(),
                requestTender.getBatchCertified()==true?1:0,
                requestTender.getPickupLocation(),
                requestTender.getExtraDetails(),
                TimeManager.currentTimeStamp(),
                Constants.DefaultTime.DEFAULT_TIME,
                Constants.DefaultTime.DEFAULT_TIME,
                Constants.Status.TRUE,
                requestTender.getVariety()
        );

        for(int i=0; i<requestTender.getBuyerSelection().getIds().size();i++) {
            String sqlBuyersList = "" +
                    "INSERT INTO rct_selected_buyer_tender_request (" +
                    " buyer_id, " +
                    " request_id, " +
                    " created_time , " +
                    " updated_time , " +
                    " deleted_time , " +
                    " active ) " +
                    "VALUES (?,?,?,?,?,?)";
            logger.info("Insert User query executed : Time : " + TimeManager.timeStampToDateAndTime(TimeManager.currentTimeStamp()));
            jdbcTemplate.update(
                    sqlBuyersList,
                    requestTender.getBuyerSelection().getIds().get(i).getBuyerId(),
                    id,
                    TimeManager.currentTimeStamp(),
                    Constants.DefaultTime.DEFAULT_TIME,
                    Constants.DefaultTime.DEFAULT_TIME,
                    Constants.Status.TRUE
            );
        }
        return true;
    }
}
