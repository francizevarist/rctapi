package com.rct.app.modules.authentication.dao;

import com.rct.app.modules.authentication.model.Session;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SessionDao {
    int insertSession(UUID id, Session session);

    List<Session> selectAllSession();

    List<Session> selectAllSessionByUser(UUID id);

    Optional<Session> selectSessionById(UUID id);

    Optional<Session> selectSessionBySecurityToken(String securityToken);

    Optional<Session> selectSessionByRefreshToken(UUID refreshToken);

    UUID updateSecurityToken(UUID accessToken, String security_token,UUID newRefreshToken);

    UUID updateProfile(UUID id,UUID profileId);
}
