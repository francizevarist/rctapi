package com.rct.app.modules.seller.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class RequestTender {
    private UUID id;

    private Double quantity;

    @JsonProperty("selling_price")
    private Double sellingPrice;

    @JsonProperty("is_graded")
    private Boolean isGraded;

    private Integer grade;

    @JsonProperty("is_batch_certified")
    private Boolean isBatchCertified;

    @JsonProperty("pickup_location")
    private String pickupLocation;

    @JsonProperty("extra_details")
    private String extraDetails;

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

    @JsonProperty("buyer_sellection")
    private BuyerSelection buyerSelection;

    private String variety;

    public RequestTender() {}

    public RequestTender(UUID id, Double quantity, Double sellingPrice, Boolean isGraded, Integer grade, Boolean isBatchCertified, String pickupLocation, String extraDetails, String createdTime, String updatedTime, String deletedTime, Integer active, BuyerSelection buyerSelection, String variety) {
        this.id = id;
        this.quantity = quantity;
        this.sellingPrice = sellingPrice;
        this.isGraded = isGraded;
        this.grade = grade;
        this.isBatchCertified = isBatchCertified;
        this.pickupLocation = pickupLocation;
        this.extraDetails = extraDetails;
        this.createdTime = createdTime;
        this.updatedTime = updatedTime;
        this.deletedTime = deletedTime;
        this.active = active;
        this.buyerSelection = buyerSelection;
        this.variety = variety;
    }

    public RequestTender(UUID id, Double quantity, Double sellingPrice, Boolean isGraded, Integer grade, Boolean isBatchCertified, String pickupLocation, String extraDetails, Integer active, BuyerSelection buyerSelection, String variety) {
        this.id = id;
        this.quantity = quantity;
        this.sellingPrice = sellingPrice;
        this.isGraded = isGraded;
        this.grade = grade;
        this.isBatchCertified = isBatchCertified;
        this.pickupLocation = pickupLocation;
        this.extraDetails = extraDetails;
        this.active = active;
        this.buyerSelection = buyerSelection;
        this.variety = variety;
    }

    public RequestTender(UUID id, Double quantity, Double sellingPrice, Boolean isGraded, Integer grade, Boolean isBatchCertified, String pickupLocation, String extraDetails, Integer active, String variety) {
        this.id = id;
        this.quantity = quantity;
        this.sellingPrice = sellingPrice;
        this.isGraded = isGraded;
        this.grade = grade;
        this.isBatchCertified = isBatchCertified;
        this.pickupLocation = pickupLocation;
        this.extraDetails = extraDetails;
        this.active = active;
        this.variety = variety;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(Double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public Boolean getGraded() {
        return isGraded;
    }

    public void setGraded(Boolean graded) {
        isGraded = graded;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Boolean getBatchCertified() {
        return isBatchCertified;
    }

    public void setBatchCertified(Boolean batchCertified) {
        isBatchCertified = batchCertified;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public String getExtraDetails() {
        return extraDetails;
    }

    public void setExtraDetails(String extraDetails) {
        this.extraDetails = extraDetails;
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

    public BuyerSelection getBuyerSelection() {
        return buyerSelection;
    }

    public void setBuyerSelection(BuyerSelection buyerSelection) {
        this.buyerSelection = buyerSelection;
    }

    public String getVariety() {
        return variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }
}
