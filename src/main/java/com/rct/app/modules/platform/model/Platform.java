package com.rct.app.modules.platform.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Platform {
    private UUID id;

    @JsonProperty("platform_name")
    private String platformName;

    @JsonProperty("platform_country_dial_code")
    private String platformCountryDialCode;

    @JsonProperty("platform_region")
    private String platformRegion;

    private Integer active;

    public Platform() {}

    public Platform(UUID id, String platformName, String platformCountryDialCode, String platformRegion, Integer active) {
        this.id = id;
        this.platformName = platformName;
        this.platformCountryDialCode = platformCountryDialCode;
        this.platformRegion = platformRegion;
        this.active = active;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public String getPlatformCountryDialCode() {
        return platformCountryDialCode;
    }

    public void setPlatformCountryDialCode(String platformCountryDialCode) {
        this.platformCountryDialCode = platformCountryDialCode;
    }

    public String getPlatformRegion() {
        return platformRegion;
    }

    public void setPlatformRegion(String platformRegion) {
        this.platformRegion = platformRegion;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }
}
