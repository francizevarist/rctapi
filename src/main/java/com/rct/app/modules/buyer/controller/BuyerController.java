package com.rct.app.modules.buyer.controller;

import com.rct.app.commondto.ResponseDto;
import com.rct.app.modules.buyer.model.Tender;
import com.rct.app.modules.buyer.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("api/v1/buyer")
@RestController
public class BuyerController {
    private final BuyerService buyerService;

    @Autowired
    public BuyerController(BuyerService buyerService) {
        this.buyerService = buyerService;
    }

    @PostMapping("/give-tender")
    public ResponseEntity giveTender(@PathVariable UUID buyerId, @RequestBody Tender tender){
        return new ResponseEntity<>(new ResponseDto(buyerService.giveTender(buyerId,tender)), HttpStatus.OK);
    }

}
