package com.rct.app.modules.seller.dto;

import com.rct.app.modules.authentication.model.User;
import com.rct.app.modules.seller.model.Seller;

public class UserSellerDto {
    private  User user;
    private  Seller seller;

    public UserSellerDto() {}

    public UserSellerDto(User user, Seller seller) {
        this.user = user;
        this.seller = seller;
    }

    public User getUser() {
        return user;
    }

    public Seller getSeller() {
        return seller;
    }
}
