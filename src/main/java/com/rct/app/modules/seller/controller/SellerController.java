package com.rct.app.modules.seller.controller;


import com.rct.app.commondto.ResponseDto;
import com.rct.app.commondto.ToggleState;
import com.rct.app.modules.authentication.model.User;
import com.rct.app.modules.seller.dto.UserSellerDto;
import com.rct.app.modules.seller.model.RequestTender;
import com.rct.app.modules.seller.service.SellerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("api/v1/seller")
@RestController
public class SellerController {
    private final SellerService sellerService;

    public SellerController(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    @GetMapping("/tender")
    public ResponseEntity selectAllTender(){
        return new ResponseEntity(new ResponseDto<>(sellerService.getAllTender()), HttpStatus.OK);
    }

    @GetMapping("tender/user/{id}")
    public ResponseEntity selectAllTenderByUser(@PathVariable UUID id){
        return new ResponseEntity(new ResponseDto<>(sellerService.getAllTenderByUser(id)),HttpStatus.OK);
    }

    @GetMapping("tender/{id}")
    public ResponseEntity selectTenderById(@PathVariable UUID id){
        return new ResponseEntity(new ResponseDto<>(sellerService.selectTenderById(id)),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity insertSeller(@RequestHeader("Authorization") String token, @RequestBody UserSellerDto userSellerDto){
        return new ResponseEntity(new ResponseDto<>(sellerService.createSeller(token,userSellerDto.getUser(),userSellerDto.getSeller())),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity selectAllSeller(){
        return new ResponseEntity(new ResponseDto<>(sellerService.getAllSeller()),HttpStatus.OK);
    }

    @GetMapping("/leader/{id}")
    public ResponseEntity selectAllSellerByLeader(@PathVariable UUID id){
        return new ResponseEntity(new ResponseDto<>(sellerService.getAllSellerByLeader(id)),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity selectSellerById(@PathVariable UUID id){
        return new ResponseEntity(new ResponseDto<>(sellerService.selectSellerById(id)),HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity deleteSellerById(@PathVariable UUID id){
        return new ResponseEntity(new ResponseDto<>(sellerService.deleteSellerById(id)),HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity updateSellerById(@PathVariable UUID id, @RequestBody User user){
        return new ResponseEntity(new ResponseDto<>(sellerService.updateSellerById(id,user)),HttpStatus.OK);
    }

    @PutMapping("toggle")
    public ResponseEntity activateOrDisableSeller(@PathVariable UUID id, @RequestBody ToggleState toggleState){
        return new ResponseEntity(new ResponseDto<>(sellerService.activateOrDisableSeller(id,toggleState)),HttpStatus.OK);
    }

    @PostMapping("/tender")
    public ResponseEntity requestTender(@RequestHeader("Authorization") String token, @RequestBody RequestTender requestTender){
        return new ResponseEntity(new ResponseDto<>(sellerService.requestTender(token,requestTender)),HttpStatus.OK);
    }

}
