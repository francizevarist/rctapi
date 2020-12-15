package com.rct.app.modules.price.dao;

import com.rct.app.commondto.ToggleState;
import com.rct.app.modules.price.model.PriceRate;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PriceRateDao {
    Boolean insertPriceRate(UUID id, PriceRate priceRate);

    List<PriceRate> selectAllPriceRate();

    Optional<PriceRate> selectPriceRateById(UUID id);

    Optional<PriceRate> selectPriceRateByRegion(String region);

    Boolean deletePriceRateById(UUID id);

    Boolean updatePriceRateById(UUID id, PriceRate user);

    Boolean activateOrDisableUser(UUID id, ToggleState toggleState);
}
