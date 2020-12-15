package com.rct.app.modules.seller.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class BuyerId {
    @JsonProperty("buyer_id")
    private UUID buyerId;

    public BuyerId() {}

    public UUID getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(UUID buyerId) {
        this.buyerId = buyerId;
    }
}
