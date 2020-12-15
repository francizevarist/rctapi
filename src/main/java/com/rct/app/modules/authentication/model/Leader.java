package com.rct.app.modules.authentication.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Leader {
    private UUID id;

    @JsonProperty("platform_id")
    private UUID platformId;

    @JsonProperty("user_id")
    private UUID userId;

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

    public Leader(UUID id, UUID platformId, UUID userId, String createdTime, String updatedTime, String deletedTime, Integer active) {
        this.id = id;
        this.platformId = platformId;
        this.userId = userId;
        this.createdTime = createdTime;
        this.updatedTime = updatedTime;
        this.deletedTime = deletedTime;
        this.active = active;
    }

    public Leader(UUID id, UUID platformId, UUID userId, Integer active) {
        this.id = id;
        this.platformId = platformId;
        this.userId = userId;
        this.active = active;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getPlatformId() {
        return platformId;
    }

    public void setPlatformId(UUID platformId) {
        this.platformId = platformId;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
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
