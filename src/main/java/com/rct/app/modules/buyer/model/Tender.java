package com.rct.app.modules.buyer.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Tender {
    private UUID id;

    @JsonProperty("buyer_id")
    private UUID buyerId;

    private Double quantity;

    private Integer grade;

    @JsonProperty("pickup_location")
    private String pickupLocation;

    private String variety;

    private Integer active;

    @JsonProperty("seller_selection")
    private SellerSelection sellerSelection;

    @JsonProperty("created_time")
    private String createdTime;

    public Tender(UUID id, UUID buyerId, Double quantity, Integer grade, String pickupLocation, String variety, Integer active, SellerSelection sellerSelection) {
        this.id = id;
        this.buyerId = buyerId;
        this.quantity = quantity;
        this.grade = grade;
        this.pickupLocation = pickupLocation;
        this.variety = variety;
        this.active = active;
        this.sellerSelection = sellerSelection;
    }

    public Tender(UUID id, Double quantity, Integer grade, String pickupLocation, String variety, String createdTime) {
        this.id = id;
        this.quantity = quantity;
        this.grade = grade;
        this.pickupLocation = pickupLocation;
        this.variety = variety;
        this.createdTime = createdTime;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(UUID buyerId) {
        this.buyerId = buyerId;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public String getVariety() {
        return variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public SellerSelection getSellerSelection() {
        return sellerSelection;
    }

    public void setSellerSelection(SellerSelection sellerSelection) {
        this.sellerSelection = sellerSelection;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }
}
