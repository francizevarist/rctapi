package com.rct.app.modules.platform.dao;

import com.rct.app.commondto.ToggleState;
import com.rct.app.modules.platform.model.Platform;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PlatformDao {
    Boolean insertPlatform(UUID id,Platform platform);

    List<Platform> selectAllPlatform();

    List<Platform> selectAllPlatformByRegion(String region);

    List<Platform> selectAllPlatformByCountryRegion(String countryDialCode,String region);

    List<Platform> selectAllPlatformByCountry(String countryDialCode);

    Optional<Platform> selectPlatformById(UUID id);

    Boolean deletePlatform(UUID id);

    Boolean updatePlatform(UUID id, Platform platform);

    Boolean activateOrDisablePlatform(UUID id, ToggleState toggleState);
}
