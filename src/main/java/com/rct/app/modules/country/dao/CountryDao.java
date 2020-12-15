package com.rct.app.modules.country.dao;

import com.rct.app.modules.country.model.Country;

import java.util.List;

public interface CountryDao {
    List<Country> getAllCountry();
    List<Country> getCountryByDialCode(String dialCode);
    List<Country> getAllCountryByName(String name);
}
