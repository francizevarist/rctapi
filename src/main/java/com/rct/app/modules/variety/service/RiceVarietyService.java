package com.rct.app.modules.variety.service;

import com.rct.app.commondto.ToggleState;
import com.rct.app.modules.variety.dao.RiceVarietyDao;
import com.rct.app.modules.variety.model.RiceVariety;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RiceVarietyService {
    private final RiceVarietyDao riceVarietyDao;

    @Autowired
    public RiceVarietyService(RiceVarietyDao riceVarietyDao) {
        this.riceVarietyDao = riceVarietyDao;
    }

    public Boolean addVariety(RiceVariety riceVariety){
        UUID id = UUID.randomUUID();
        return riceVarietyDao.insertVariety(id,riceVariety);
    }

    public List<RiceVariety> getAllVariety(){
        return riceVarietyDao.selectAllVariety();
    }

    public Optional<RiceVariety> selectVarietyById(UUID id){
        return riceVarietyDao.selectVarietyById(id);
    }

    public Boolean deleteVarietyById(UUID id){
        return riceVarietyDao.deleteVarietyById(id);
    }

    public Boolean updateVarietyById(UUID id, RiceVariety riceVariety){
        return riceVarietyDao.updateVarietyById(id,riceVariety);
    }

    public Boolean activateOrDisableVariety(UUID id, ToggleState toggleState){
        return riceVarietyDao.activateOrDisableVariety(id,toggleState);
    }
}
