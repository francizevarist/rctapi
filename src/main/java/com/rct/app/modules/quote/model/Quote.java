package com.rct.app.modules.quote.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Quote {
    private UUID id;

    @JsonProperty("tender_id")
    private UUID tenderId;

    @JsonProperty("supply_quantity")
    private Double supplyQuantity;

    @JsonProperty("supply_price")
    private Double supplyPrice;

    @JsonProperty("supply_pickup_location")
    private String supplyPickupLocation;

    @JsonProperty("supply_details")
    private String supplyDetails;

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

    public Quote(UUID id, UUID tenderId, Double supplyQuantity, Double supplyPrice, String supplyPickupLocation, String supplyDetails, String createdTime, String updatedTime, String deletedTime, Integer active) {
        this.id = id;
        this.tenderId = tenderId;
        this.supplyQuantity = supplyQuantity;
        this.supplyPrice = supplyPrice;
        this.supplyPickupLocation = supplyPickupLocation;
        this.supplyDetails = supplyDetails;
        this.createdTime = createdTime;
        this.updatedTime = updatedTime;
        this.deletedTime = deletedTime;
        this.active = active;
    }

    public Quote(UUID id, UUID tenderId, Double supplyQuantity, Double supplyPrice, String supplyPickupLocation, String supplyDetails, Integer active) {
        this.id = id;
        this.tenderId = tenderId;
        this.supplyQuantity = supplyQuantity;
        this.supplyPrice = supplyPrice;
        this.supplyPickupLocation = supplyPickupLocation;
        this.supplyDetails = supplyDetails;
        this.active = active;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getTenderId() {
        return tenderId;
    }

    public void setTenderId(UUID tenderId) {
        this.tenderId = tenderId;
    }

    public Double getSupplyQuantity() {
        return supplyQuantity;
    }

    public void setSupplyQuantity(Double supplyQuantity) {
        this.supplyQuantity = supplyQuantity;
    }

    public Double getSupplyPrice() {
        return supplyPrice;
    }

    public void setSupplyPrice(Double supplyPrice) {
        this.supplyPrice = supplyPrice;
    }

    public String getSupplyPickupLocation() {
        return supplyPickupLocation;
    }

    public void setSupplyPickupLocation(String supplyPickupLocation) {
        this.supplyPickupLocation = supplyPickupLocation;
    }

    public String getSupplyDetails() {
        return supplyDetails;
    }

    public void setSupplyDetails(String supplyDetails) {
        this.supplyDetails = supplyDetails;
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
