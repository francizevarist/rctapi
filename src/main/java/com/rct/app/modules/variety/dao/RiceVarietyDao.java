package com.rct.app.modules.variety.dao;

import com.rct.app.commondto.ToggleState;
import com.rct.app.modules.variety.model.RiceVariety;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RiceVarietyDao {
    Boolean insertVariety(UUID id, RiceVariety riceVariety);

    List<RiceVariety> selectAllVariety();

    Optional<RiceVariety> selectVarietyById(UUID id);

    Boolean deleteVarietyById(UUID id);

    Boolean updateVarietyById(UUID id, RiceVariety riceVariety);

    Boolean activateOrDisableVariety(UUID id, ToggleState toggleState);
}
