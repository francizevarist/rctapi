package com.rct.app.modules.seller.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Seller {
    private UUID id;

    @JsonProperty("leader_id")
    private UUID leaderId;

    @JsonProperty("user_id")
    private UUID userId;

    @JsonProperty("first_time")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("application_type")
    private String applicationType;

    private String address;

    private String website;

    private Integer grade;

    private String experience;

    @JsonProperty("tbs_certification_number")
    private String tbsCertificationNumber;

    @JsonProperty("certification_number")
    private String certificationNumber;

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

    public Seller() {}

    public Seller(UUID id, UUID leaderId, UUID userId, String firstName, String lastName, String applicationType, String address, String website, Integer grade, String experience, String tbsCertificationNumber, String certificationNumber, String varietyName, String createdTime, String updatedTime, String deletedTime, Integer active) {
        this.id = id;
        this.leaderId = leaderId;
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.applicationType = applicationType;
        this.address = address;
        this.website = website;
        this.grade = grade;
        this.experience = experience;
        this.tbsCertificationNumber = tbsCertificationNumber;
        this.certificationNumber = certificationNumber;
        this.varietyName = varietyName;
        this.createdTime = createdTime;
        this.updatedTime = updatedTime;
        this.deletedTime = deletedTime;
        this.active = active;
    }

    public Seller(UUID id, UUID leaderId, UUID userId, String firstName, String lastName, String applicationType, String address, String website, Integer grade, String experience, String tbsCertificationNumber, String certificationNumber, String varietyName, Integer active) {
        this.id = id;
        this.leaderId = leaderId;
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.applicationType = applicationType;
        this.address = address;
        this.website = website;
        this.grade = grade;
        this.experience = experience;
        this.tbsCertificationNumber = tbsCertificationNumber;
        this.certificationNumber = certificationNumber;
        this.varietyName = varietyName;
        this.active = active;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getLeaderId() {
        return leaderId;
    }

    public void setLeaderId(UUID leaderId) {
        this.leaderId = leaderId;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getApplicationType() {
        return applicationType;
    }

    public void setApplicationType(String applicationType) {
        this.applicationType = applicationType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getTbsCertificationNumber() {
        return tbsCertificationNumber;
    }

    public void setTbsCertificationNumber(String tbsCertificationNumber) {
        this.tbsCertificationNumber = tbsCertificationNumber;
    }

    public String getCertificationNumber() {
        return certificationNumber;
    }

    public void setCertificationNumber(String certificationNumber) {
        this.certificationNumber = certificationNumber;
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
