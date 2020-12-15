package com.rct.app.modules.authentication.dao;

import com.rct.app.commondto.ToggleState;
import com.rct.app.modules.authentication.model.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface LeaderDao {
    Boolean insertLeaderDao(UUID id, UUID platformId, User user);

    List<User> selectAllLeader();

    List<User> selectAllLeaderByPlatform(UUID id);

    Optional<User> selectLeaderById(UUID id);

    Boolean deleteLeaderById(UUID id);

    Boolean updateLeaderById(UUID id, User user);

    Boolean activateOrDisableLeader(UUID id, ToggleState toggleState);
}
