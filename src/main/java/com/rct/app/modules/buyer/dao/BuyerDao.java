package com.rct.app.modules.buyer.dao;

import com.rct.app.commondto.ToggleState;
import com.rct.app.modules.buyer.model.Tender;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BuyerDao {

    Boolean giveTender(UUID id, UUID buyerId, Tender tender);

    List<Tender> selectAllTenderByUser(UUID id);

    Optional<Tender> selectTenderById(UUID id);

    Boolean deleteTenderById(UUID id);

    Boolean updateTenderById(UUID id, Tender user);

    Boolean activateOrDisableTender(UUID id, ToggleState toggleState);
}
