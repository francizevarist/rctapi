package com.rct.app.modules.platform.service;

import com.rct.app.commondto.ToggleState;
import com.rct.app.modules.platform.dao.PlatformDao;
import com.rct.app.modules.platform.model.Platform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PlatformService {
    private final PlatformDao platformDao;

    @Autowired
    public PlatformService(PlatformDao platformDao) {
        this.platformDao = platformDao;
    }

    public Boolean createPlatform(Platform platform){
        UUID id = UUID.randomUUID();
        return platformDao.insertPlatform(id,platform);
    }

    public List<Platform> getAllPlatform(){
        return platformDao.selectAllPlatform();
    }

    public List<Platform> AllPlatformByRegion(String region){
        return platformDao.selectAllPlatformByRegion(region);
    }

    public List<Platform> selectAllPlatformByCountryRegion(String countryDialCode,String region){
        return platformDao.selectAllPlatformByCountryRegion(countryDialCode,region);
    }

    public List<Platform> selectAllPlatformByCountry(String countryDIalCode){
        return platformDao.selectAllPlatformByCountry(countryDIalCode);
    }

    public Optional<Platform> selectPlatformById(UUID id){
        return platformDao.selectPlatformById(id);
    }

    public Boolean deletePlatform(UUID id){
        return platformDao.deletePlatform(id);
    }

    public Boolean updatePlatform(UUID id, Platform platform){
        return platformDao.updatePlatform(id,platform);
    }

    public Boolean activateOrDisablePlatform(UUID id, ToggleState toggleState){
        return platformDao.activateOrDisablePlatform(id,toggleState);
    }
}
