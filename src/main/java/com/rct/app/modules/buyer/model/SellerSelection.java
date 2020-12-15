package com.rct.app.modules.buyer.model;

import java.util.List;

public class SellerSelection {

    private List<SellerId> ids;

    public SellerSelection() {}

    public SellerSelection(List<SellerId> ids) {
        this.ids = ids;
    }

    public List<SellerId> getIds() {
        return ids;
    }

    public void setIds(List<SellerId> ids) {
        this.ids = ids;
    }
}
