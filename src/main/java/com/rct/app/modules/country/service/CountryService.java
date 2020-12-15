package com.rct.app.modules.country.service;
import com.rct.app.modules.country.dao.CountryDao;
import com.rct.app.modules.country.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {
    private final CountryDao countryDao;

    @Autowired
    public CountryService(@Qualifier("country") CountryDao countryDao) {
        this.countryDao = countryDao;
    }

    public List<Country> getAllCountry(){
        return countryDao.getAllCountry();
    }
    public List<Country> getCountryByDialCode(String dialCode){
        return countryDao.getCountryByDialCode(dialCode);
    }
    public List<Country> getAllCountryByName(String name){
        return countryDao.getAllCountryByName(name);
    }
}
