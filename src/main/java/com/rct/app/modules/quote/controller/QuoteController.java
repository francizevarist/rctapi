package com.rct.app.modules.quote.controller;

import com.rct.app.commondto.ResponseDto;
import com.rct.app.commondto.ToggleState;
import com.rct.app.modules.quote.model.Quote;
import com.rct.app.modules.quote.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("api/v1/quote")
@RestController
public class QuoteController {
    private final QuoteService quoteService;

    @Autowired
    public QuoteController(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    @PutMapping
    public ResponseEntity insertQuote(@RequestBody Quote quote){
        return new ResponseEntity(new ResponseDto<>(quoteService.createQuote(quote)), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity selectAllQuote(){
        return new ResponseEntity(new ResponseDto<>(quoteService.getAllQuote()),HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity selectAllQuoteByUser(@PathVariable UUID id){
        return new ResponseEntity(new ResponseDto<>(quoteService.getAllQuoteByUser(id)),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity selectQuoteById(@PathVariable UUID id){
        return new ResponseEntity(new ResponseDto<>(quoteService.getQuoteById(id)),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteQuoteById(@PathVariable UUID id){
        return new ResponseEntity(new ResponseDto<>(quoteService.deleteQuoteById(id)),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateQuoteById(@PathVariable UUID id, @RequestBody Quote quote){
        return new ResponseEntity(new ResponseDto<>(quoteService.updateQuoteById(id,quote)),HttpStatus.OK);
    }

    @PutMapping("/toggle/{id}")
    public ResponseEntity activateOrDisableQuote(@PathVariable UUID id, @RequestBody ToggleState toggleState){
        return new ResponseEntity(new ResponseDto<>(quoteService.activateOrDisableQuote(id,toggleState)),HttpStatus.OK);
    }
}
