package com.rct.app.modules.price.controller;

import com.rct.app.commondto.ResponseDto;
import com.rct.app.commondto.ToggleState;
import com.rct.app.modules.price.model.PriceRate;
import com.rct.app.modules.price.service.PriceRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("api/v1/price-rate")
@RestController
public class PriceRateController {
    private final PriceRateService priceRateService;

    @Autowired
    public PriceRateController(PriceRateService priceRateService) {
        this.priceRateService = priceRateService;
    }

    @PostMapping
    public ResponseEntity insertPriceRate(PriceRate priceRate){
        return new ResponseEntity(new ResponseDto<>(priceRateService.addPriceRate(priceRate)), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity selectAllPriceRate(){
        return new ResponseEntity(new ResponseDto<>(priceRateService.getAllPriceRate()),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity selectPriceRateById(@PathVariable UUID id){
        return new ResponseEntity(new ResponseDto<>(priceRateService.deletePriceRateById(id)),HttpStatus.OK);
    }

    @GetMapping("/region/{region}")
    public ResponseEntity selectPriceRateByRegion(@PathVariable String region){
        return new ResponseEntity(new ResponseDto<>(priceRateService.getPriceRateByRegion(region)),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePriceRateById(@PathVariable UUID id){
        return new ResponseEntity(new ResponseDto<>(priceRateService.deletePriceRateById(id)),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity updatePriceRateById(@PathVariable UUID id, @RequestBody PriceRate user){
        return new ResponseEntity(new ResponseDto<>(priceRateService.updatePriceRateById(id,user)),HttpStatus.OK);
    }

    @PutMapping("/toggle/{id}")
    public ResponseEntity activateOrDisableUser(@PathVariable UUID id, @RequestBody ToggleState toggleState){
        return new ResponseEntity<>(new ResponseDto(priceRateService.activateOrDisableUser(id,toggleState)),HttpStatus.OK);
    }
}
