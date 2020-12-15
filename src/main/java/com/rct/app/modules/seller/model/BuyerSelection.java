package com.rct.app.modules.seller.model;

import java.util.List;

public class BuyerSelection {
    private List<BuyerId> ids;

    public BuyerSelection() {}

    public List<BuyerId> getIds() {
        return ids;
    }

    public void setIds(List<BuyerId> ids) {
        this.ids = ids;
    }
}
