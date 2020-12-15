package com.rct.app.modules.country.controller;

import com.rct.app.commondto.ResponseDto;
import com.rct.app.modules.country.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("api/v1/country")
@RestController
public class CountryController {
    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public ResponseEntity getAllCountry(){
        return new ResponseEntity(new ResponseDto<>(countryService.getAllCountry()), HttpStatus.OK);
    }

    @GetMapping("/dialcode/{dialCode}")
    public ResponseEntity getCountryByDialCode(@PathVariable String dialCode){
        return new ResponseEntity(new ResponseDto<>(countryService.getCountryByDialCode(dialCode)),HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity getAllCountryByName(@PathVariable String name){
        return new ResponseEntity(new ResponseDto<>(countryService.getAllCountryByName(name)),HttpStatus.OK);
    }

}
