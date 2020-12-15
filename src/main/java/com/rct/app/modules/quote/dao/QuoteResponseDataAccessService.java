package com.rct.app.modules.quote.dao;

import com.rct.app.commondto.ToggleState;
import com.rct.app.modules.buyer.dao.BuyerDaoDataAccessService;
import com.rct.app.modules.quote.model.Quote;
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

@Repository("quote")
public class QuoteResponseDataAccessService implements QuoteResponseDao {
    Logger logger = LoggerFactory.getLogger(BuyerDaoDataAccessService.class);
    private  final JdbcTemplate jdbcTemplate;

    @Autowired
    public QuoteResponseDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Boolean insertQuote(UUID id, Quote quote) {
        try {
            String sql = "" +
                    "INSERT INTO rct_quote (" +
                    " id, " +
                    " tender_id, " +
                    " supply_quantity, " +
                    " supply_price, " +
                    " supply_pickup_location, " +
                    " supply_details, " +
                    " created_time , " +
                    " updated_time , " +
                    " deleted_time , " +
                    " active ) " +
                    "VALUES (?,?,?,?,?,?,?)";
            logger.info("Insert variety query executed : Time : "+ TimeManager.timeStampToDateAndTime(TimeManager.currentTimeStamp()));
            jdbcTemplate.update(
                    sql,
                    id,
                    quote.getTenderId(),
                    quote.getSupplyQuantity(),
                    quote.getSupplyPrice(),
                    quote.getSupplyPickupLocation(),
                    quote.getSupplyDetails(),
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
    public List<Quote> selectAllQuote() {
        return null;
    }

    @Override
    public List<Quote> selectAllQuoteByUser(UUID id) {
        return null;
    }

    @Override
    public Optional<Quote> selectQuoteById(UUID id) {
        return Optional.empty();
    }

    @Override
    public Boolean deleteQuoteById(UUID id) {
        return null;
    }

    @Override
    public Boolean updateQuoteById(UUID id, Quote quote) {
        return null;
    }

    @Override
    public Boolean activateOrDisableQuote(UUID id, ToggleState toggleState) {
        return null;
    }
}
