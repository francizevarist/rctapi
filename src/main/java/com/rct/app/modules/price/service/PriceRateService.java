package com.rct.app.modules.price.service;

import com.rct.app.commondto.ToggleState;
import com.rct.app.modules.price.dao.PriceRateDao;
import com.rct.app.modules.price.model.PriceRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PriceRateService {
    private final PriceRateDao priceRateDao;

    @Autowired
    public PriceRateService(@Qualifier("pricerate") PriceRateDao priceRateDao) {
        this.priceRateDao = priceRateDao;
    }

    public Boolean addPriceRate(PriceRate priceRate){
        UUID id = UUID.randomUUID();
        return priceRateDao.insertPriceRate(id,priceRate);
    }

    public List<PriceRate> getAllPriceRate(){
        return priceRateDao.selectAllPriceRate();
    }

    public Optional<PriceRate> getPriceRateById(UUID id){
        return priceRateDao.selectPriceRateById(id);
    }

    public Optional<PriceRate>  getPriceRateByRegion(String region){
        return priceRateDao.selectPriceRateByRegion(region);
    }

    public Boolean deletePriceRateById(UUID id){
        return priceRateDao.deletePriceRateById(id);
    }

    public Boolean updatePriceRateById(UUID id, PriceRate priceRate){
        return priceRateDao.updatePriceRateById(id,priceRate);
    }

    public Boolean activateOrDisableUser(UUID id, ToggleState toggleState){
        return priceRateDao.activateOrDisableUser(id,toggleState);
    }
}
