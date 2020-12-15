package com.rct.app.modules.seller.service;

import com.rct.app.commondto.ToggleState;
import com.rct.app.modules.authentication.model.User;
import com.rct.app.modules.authentication.service.SessionService;
import com.rct.app.modules.seller.dao.SellerDao;
import com.rct.app.modules.seller.model.RequestTender;
import com.rct.app.modules.seller.model.Seller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SellerService {
    private final SellerDao sellerDao;
    private final SessionService sessionService;
    Logger logger = LoggerFactory.getLogger(SellerService.class);

    @Autowired
    public SellerService(@Qualifier("seller") SellerDao sellerDao, SessionService sessionService) {
        this.sellerDao = sellerDao;
        this.sessionService = sessionService;
    }

    public List<RequestTender> getAllTender(){
        return sellerDao.selectAllTender();
    }

    public List<RequestTender> getAllTenderByUser(UUID id){
        return sellerDao.selectAllTenderByUser(id);
    }

    public Optional<RequestTender> selectTenderById(UUID id){
        return sellerDao.selectTenderById(id);
    }

    public Boolean createSeller(String token, User user, Seller seller){
        UUID id = UUID.randomUUID();
        UUID leaderId = sessionService.getSessionBySecurityToken(token).get().getUserId();
        logger.error("leader id = "+leaderId+" user = "+user.getPhoneNumber()+" seller = "+seller.getFirstName());
        return sellerDao.insertSellerDao(id,leaderId,user,seller);
    }

    public List<User> getAllSeller(){
        return sellerDao.selectAllSeller();
    }

    public List<User> getAllSellerByLeader(UUID id){
        return sellerDao.selectAllSellerByLeader(id);
    }

    public Optional<User> selectSellerById(UUID id){
        return sellerDao.selectSellerById(id);
    }

    public Boolean deleteSellerById(UUID id){
        return sellerDao.deleteSellerById(id);
    }

    public Boolean updateSellerById(UUID id, User user){
        return sellerDao.updateSellerById(id,user);
    }

    public Boolean activateOrDisableSeller(UUID id, ToggleState toggleState){
        return sellerDao.activateOrDisableSeller(id,toggleState);
    }

    public Boolean requestTender(String token,RequestTender requestTender){
        UUID id = UUID.randomUUID();
        UUID sellerId = sessionService.getSessionBySecurityToken(token).get().getUserId();
        return sellerDao.requestTender(id,sellerId,requestTender);
    }

}
