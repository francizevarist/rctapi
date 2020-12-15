package com.rct.app.modules.authentication.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class User {
    private UUID id;

    @JsonProperty("dial_code")
    private String dialCode;

    @JsonProperty("phone_number")
    private String phoneNumber;

    private String name;

    @JsonIgnore
    @JsonProperty("created_time")
    private String createdTime;

    @JsonIgnore
    @JsonProperty("updated_time")
    private String updatedTime;

    @JsonIgnore
    @JsonProperty("deleted_time")
    private String deletedTime;

    @JsonIgnore
    private Integer otp;

    private Integer active;

    public User() {}

    public User(UUID id, String dialCode, String phoneNumber, String name, String createdTime, String updatedTime, String deletedTime, Integer otp, Integer active) {
        this.id = id;
        this.dialCode = dialCode;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.createdTime = createdTime;
        this.updatedTime = updatedTime;
        this.deletedTime = deletedTime;
        this.otp = otp;
        this.active = active;
    }

    public User(UUID id, String dialCode, String phoneNumber, String name, Integer otp, Integer active) {
        this.id = id;
        this.dialCode = dialCode;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.otp = otp;
        this.active = active;
    }

    public User(UUID id, String dialCode, String phoneNumber, String name, Integer active) {
        this.id = id;
        this.dialCode = dialCode;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.active = active;
    }


    public User(String dialCode, String phoneNumber, String name) {
        this.dialCode = dialCode;
        this.phoneNumber = phoneNumber;
        this.name = name;
    }

    public User(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDialCode() {
        return dialCode;
    }

    public void setDialCode(String dialCode) {
        this.dialCode = dialCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonIgnore
    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    @JsonIgnore
    public String getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(String updatedTime) {
        this.updatedTime = updatedTime;
    }

    @JsonIgnore
    public String getDeletedTime() {
        return deletedTime;
    }

    public void setDeletedTime(String deletedTime) {
        this.deletedTime = deletedTime;
    }

    @JsonIgnore
    public Integer getOtp() {
        return otp;
    }

    public void setOtp(Integer otp) {
        this.otp = otp;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }
}
