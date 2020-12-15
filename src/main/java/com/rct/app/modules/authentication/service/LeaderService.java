package com.rct.app.modules.authentication.service;

import com.rct.app.commondto.ToggleState;
import com.rct.app.modules.authentication.dao.LeaderDao;
import com.rct.app.modules.authentication.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class LeaderService {
    private final LeaderDao leaderDao;

    @Autowired
    public LeaderService(@Qualifier("leader") LeaderDao leaderDao) {
        this.leaderDao = leaderDao;
    }

    public Boolean createLeader(UUID platformId, User user){
        UUID id = UUID.randomUUID();
        return leaderDao.insertLeaderDao(id,platformId,user);
    }

    public List<User> getAllLeader(){
        return leaderDao.selectAllLeader();
    }

    public List<User> getAllLeaderByPlatform(UUID id){
        return leaderDao.selectAllLeaderByPlatform(id);
    }

    public Optional<User> getLeaderById(UUID id){
        return leaderDao.selectLeaderById(id);
    }

    public Boolean deleteLeaderById(UUID id){
        return leaderDao.deleteLeaderById(id);
    }

    public Boolean updateLeaderById(UUID id, User user){
        return leaderDao.updateLeaderById(id,user);
    }

    public Boolean activateOrDisableLeader(UUID id, ToggleState toggleState){
        return leaderDao.activateOrDisableLeader(id,toggleState);
    }
}
