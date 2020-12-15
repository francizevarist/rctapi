package com.rct.app.modules.seller.dao;

import com.rct.app.commondto.ToggleState;
import com.rct.app.modules.authentication.model.User;
import com.rct.app.modules.seller.model.RequestTender;
import com.rct.app.modules.seller.model.Seller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SellerDao {

    List<RequestTender> selectAllTender();

    List<RequestTender> selectAllTenderByUser(UUID id);

    Optional<RequestTender> selectTenderById(UUID id);

    Boolean insertSellerDao(UUID id, UUID leaderId, User user, Seller seller);

    List<User> selectAllSeller();

    List<User> selectAllSellerByLeader(UUID id);

    List<User> selectAllSellerByPlatform(UUID id);

    Optional<User> selectSellerById(UUID id);

    Boolean deleteSellerById(UUID id);

    Boolean updateSellerById(UUID id, User user);

    Boolean activateOrDisableSeller(UUID id, ToggleState toggleState);

    Boolean requestTender(UUID id,UUID sellerId,RequestTender requestTender);

}
