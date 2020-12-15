package com.rct.app.modules.country.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;
public class Country {
    private UUID id;
    @JsonProperty("country_name")
    private String countryName;
    private String code;
    @JsonProperty("dial_code")
    private String dialCode;
    @JsonProperty("currency_name")
    private String currencyName;
    @JsonProperty("currency_symbol")
    private String currencySymbol;
    @JsonProperty("currency_code")
    private String currencyCode;

    public Country() {}

    public Country(UUID id, String countryName, String code, String dialCode, String currencyName, String currencySymbol, String currencyCode) {
        this.id = id;
        this.countryName = countryName;
        this.code = code;
        this.dialCode = dialCode;
        this.currencyName = currencyName;
        this.currencySymbol = currencySymbol;
        this.currencyCode = currencyCode;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDialCode() {
        return dialCode;
    }

    public void setDialCode(String dialCode) {
        this.dialCode = dialCode;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public String getCurrencySymbol() {
        return currencySymbol;
    }

    public void setCurrencySymbol(String currencySymbol) {
        this.currencySymbol = currencySymbol;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }
}
