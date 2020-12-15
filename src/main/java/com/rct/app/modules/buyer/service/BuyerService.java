package com.rct.app.modules.buyer.service;

import com.rct.app.modules.buyer.dao.BuyerDao;
import com.rct.app.modules.buyer.model.Tender;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BuyerService {
    private final BuyerDao buyerDao;

    public BuyerService(BuyerDao buyerDao) {
        this.buyerDao = buyerDao;
    }

    public Boolean giveTender(UUID buyerId, Tender tender){
        UUID id = UUID.randomUUID();
       return buyerDao.giveTender(id,buyerId,tender);
    }

}
