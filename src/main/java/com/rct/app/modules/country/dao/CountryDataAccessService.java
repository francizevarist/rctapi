package com.rct.app.modules.country.dao;

import com.rct.app.modules.country.model.Country;
import com.rct.app.util.TimeManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository("country")
public class CountryDataAccessService implements CountryDao{
    Logger logger = LoggerFactory.getLogger(CountryDataAccessService.class);
    private  final JdbcTemplate jdbcTemplate;

    public CountryDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Country> getAllCountry() {
        final String sql = "SELECT id,country_name,code,dial_code,currency_name,currency_symbol,currency_code FROM country";
        List<Country> countries = jdbcTemplate.query(sql,(resultSet,i)->
        {
            return new Country(
                    UUID.fromString(resultSet.getString("id")),
                    resultSet.getString("country_name"),
                    resultSet.getString("code"),
                    resultSet.getString("dial_code"),
                    resultSet.getString("currency_name"),
                    resultSet.getString("currency_symbol"),
                    resultSet.getString("currency_code")
            );
        });
        logger.info("Fetching all Country query executed : Time : "+ TimeManager.timeStampToDateAndTime(TimeManager.currentTimeStamp()));
        return countries;
    }

    @Override
    public List<Country> getCountryByDialCode(String dialCode) {
        final String sql = "SELECT id,country_name,code,dial_code,currency_name,currency_symbol,currency_code FROM country  WHERE dial_code = '"+dialCode+"' ";
        List<Country> countries = jdbcTemplate.query(sql,(resultSet,i)->
        {
            return new Country(
                    UUID.fromString(resultSet.getString("id")),
                    resultSet.getString("country_name"),
                    resultSet.getString("code"),
                    resultSet.getString("dial_code"),
                    resultSet.getString("currency_name"),
                    resultSet.getString("currency_symbol"),
                    resultSet.getString("currency_code")
            );
        });
        logger.info("Fetching all Country query executed : Time : "+ TimeManager.timeStampToDateAndTime(TimeManager.currentTimeStamp()));
        return countries;
    }

    @Override
    public List<Country> getAllCountryByName(String name) {
        final String sql = "SELECT id,country_name,code,dial_code,currency_name,currency_symbol,currency_code FROM country  WHERE country_name iLIKE '%"+name+"%' ";
        List<Country> countries = jdbcTemplate.query(sql,(resultSet,i)->
        {
            return new Country(
                    UUID.fromString(resultSet.getString("id")),
                    resultSet.getString("country_name"),
                    resultSet.getString("code"),
                    resultSet.getString("dial_code"),
                    resultSet.getString("currency_name"),
                    resultSet.getString("currency_symbol"),
                    resultSet.getString("currency_code")
            );
        });
        logger.info("Fetching all Country query executed : Time : "+ TimeManager.timeStampToDateAndTime(TimeManager.currentTimeStamp()));
        return countries;
    }

}
