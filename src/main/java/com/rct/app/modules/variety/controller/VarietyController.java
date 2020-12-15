package com.rct.app.modules.variety.controller;

import com.rct.app.commondto.ResponseDto;
import com.rct.app.commondto.ToggleState;
import com.rct.app.modules.variety.model.RiceVariety;
import com.rct.app.modules.variety.service.RiceVarietyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("api/v1/variety")
@RestController
public class VarietyController {
    private final RiceVarietyService riceVarietyService;

    @Autowired
    public VarietyController(RiceVarietyService riceVarietyService) {
        this.riceVarietyService = riceVarietyService;
    }

    @PostMapping
    public ResponseEntity insertVariety(@RequestBody RiceVariety riceVariety){
        return new ResponseEntity(new ResponseDto<>(riceVarietyService.addVariety(riceVariety)), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity  selectAllVariety(){
        return new ResponseEntity(new ResponseDto<>(riceVarietyService.getAllVariety()),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity selectVarietyById(@PathVariable UUID id){
        return new ResponseEntity(new ResponseDto<>(riceVarietyService.selectVarietyById(id)),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteVarietyById(@PathVariable UUID id){
        return new ResponseEntity(new ResponseDto<>(riceVarietyService.deleteVarietyById(id)),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateVarietyById(@PathVariable UUID id, @RequestBody RiceVariety riceVariety){
        return new ResponseEntity(new ResponseDto<>(riceVarietyService.updateVarietyById(id,riceVariety)),HttpStatus.OK);
    }

    @PutMapping("/toggle/{id}")
    public ResponseEntity activateOrDisableVariety(@PathVariable UUID id, @RequestBody ToggleState toggleState){
        return new ResponseEntity(new ResponseDto<>(riceVarietyService.activateOrDisableVariety(id,toggleState)),HttpStatus.OK);
    }
}
