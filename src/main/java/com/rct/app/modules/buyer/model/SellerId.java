package com.rct.app.modules.buyer.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class SellerId {
    @JsonProperty("seller_id")
    private UUID sellerId;

    public SellerId() {}

    public SellerId(UUID sellerId) {
        this.sellerId = sellerId;
    }

    public UUID getSellerId() {
        return sellerId;
    }

    public void setSellerId(UUID sellerId) {
        this.sellerId = sellerId;
    }
}
