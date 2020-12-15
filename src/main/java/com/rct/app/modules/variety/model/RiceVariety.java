package com.rct.app.modules.variety.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;

public class RiceVariety {
    private UUID id;

    @JsonProperty("variety_name")
    private String varietyName;

    @JsonIgnore
    @JsonProperty("created_time")
    private String createdTime;

    @JsonIgnore
    @JsonProperty("updated_time")
    private String updatedTime;

    @JsonIgnore
    @JsonProperty("deleted_time")
    private String deletedTime;

    private Integer active;

    public RiceVariety() {}

    public RiceVariety(UUID id, String varietyName, String createdTime, String updatedTime, String deletedTime, Integer active) {
        this.id = id;
        this.varietyName = varietyName;
        this.createdTime = createdTime;
        this.updatedTime = updatedTime;
        this.deletedTime = deletedTime;
        this.active = active;
    }

    public RiceVariety(UUID id, String varietyName, Integer active) {
        this.id = id;
        this.varietyName = varietyName;
        this.active = active;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getVarietyName() {
        return varietyName;
    }

    public void setVarietyName(String varietyName) {
        this.varietyName = varietyName;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(String updatedTime) {
        this.updatedTime = updatedTime;
    }

    public String getDeletedTime() {
        return deletedTime;
    }

    public void setDeletedTime(String deletedTime) {
        this.deletedTime = deletedTime;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }
}
