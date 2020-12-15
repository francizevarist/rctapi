package com.rct.app.modules.authentication.service;

import com.rct.app.modules.authentication.dao.SessionDao;
import com.rct.app.modules.authentication.model.Session;
import com.rct.app.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SessionService {
    private final SessionDao sessionDao;

    @Autowired
    public SessionService(@Qualifier("session") SessionDao sessionDao) {
        this.sessionDao = sessionDao;
    }

    public int createSession(Session session){
        UUID id = UUID.randomUUID();
        return sessionDao.insertSession(id,session);
    }

    public List<Session> getAllSession(){
        return sessionDao.selectAllSession();
    }

    public List<Session> getAllSessionByUser(UUID id){
        return sessionDao.selectAllSessionByUser(id);
    }

    public Optional<Session> getSessionById(UUID id){
        return sessionDao.selectSessionById(id);
    }

    public Optional<Session> getSessionBySecurityToken(String securityToken){
        return sessionDao.selectSessionBySecurityToken(Constants.Token.reformat(securityToken));
    }

    public Optional<Session> getSessionByRefreshToken(UUID refreshToken){
        return sessionDao.selectSessionByRefreshToken(refreshToken);
    }

    public UUID refreshSecurityToken(UUID accessToken, String security_token, UUID newRefreshToken){
        return sessionDao.updateSecurityToken(accessToken,security_token,newRefreshToken);
    }

    public UUID updateSessionProfile(UUID id,UUID profileId){
        return sessionDao.updateProfile(id,profileId);
    }



}
