package com.rct.app.modules.platform.controller;

import com.rct.app.commondto.ResponseDto;
import com.rct.app.commondto.ToggleState;
import com.rct.app.modules.authentication.service.TokenAuth;
import com.rct.app.modules.platform.model.Platform;
import com.rct.app.modules.platform.service.PlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("api/v1/platform")
@RestController
public class PlatformController {
    private final PlatformService platformService;

    @Autowired
    public PlatformController(PlatformService platformService) {
        this.platformService = platformService;
    }

    @PostMapping
    public ResponseEntity insertPlatform(@RequestHeader("Authorization") String token, @RequestBody Platform platform){
        if (TokenAuth.isTokenValid(token)) {
            return new ResponseEntity(new ResponseDto<>(platformService.createPlatform(platform)), HttpStatus.OK);
        }else {
            return new ResponseEntity(new ResponseDto<>(TokenAuth.TOKEN_ERROR), HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping
    public ResponseEntity selectAllPlatform(@RequestHeader("Authorization") String token){
        if (TokenAuth.isTokenValid(token)) {
            return new ResponseEntity(new ResponseDto<>(platformService.getAllPlatform()),HttpStatus.OK);
        }else {
            return new ResponseEntity(new ResponseDto<>(TokenAuth.TOKEN_ERROR), HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/region/{region}")
    public ResponseEntity selectAllPlatformByRegion(@RequestHeader("Authorization") String token, @PathVariable String region){
        if (TokenAuth.isTokenValid(token)) {
            return new ResponseEntity(new ResponseDto<>(platformService.AllPlatformByRegion(region)),HttpStatus.OK);
        }else {
            return new ResponseEntity(new ResponseDto<>(TokenAuth.TOKEN_ERROR), HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/country-region/{countryId}/{region}")
    public ResponseEntity selectAllPlatformByCountryRegion(@RequestHeader("Authorization") String token, @PathVariable String countryDialCode, @RequestBody String region){
        if (TokenAuth.isTokenValid(token)) {
            return new ResponseEntity(new ResponseDto<>(platformService.selectAllPlatformByCountryRegion(countryDialCode,region)),HttpStatus.OK);
        }else {
            return new ResponseEntity(new ResponseDto<>(TokenAuth.TOKEN_ERROR), HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/country/{countryDialCode}")
    public ResponseEntity selectAllPlatformByCountry(@RequestHeader("Authorization") String token, @PathVariable String countryDialCode){
        if (TokenAuth.isTokenValid(token)) {
            return new ResponseEntity(new ResponseDto<>(platformService.selectAllPlatformByCountry(countryDialCode)),HttpStatus.OK);
        }else {
            return new ResponseEntity(new ResponseDto<>(TokenAuth.TOKEN_ERROR), HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity selectPlatformById(@RequestHeader("Authorization") String token, @PathVariable UUID id){
        if (TokenAuth.isTokenValid(token)) {
            return new ResponseEntity(new ResponseDto<>(platformService.selectPlatformById(id)),HttpStatus.OK);
        }else {
            return new ResponseEntity(new ResponseDto<>(TokenAuth.TOKEN_ERROR), HttpStatus.UNAUTHORIZED);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePlatform(@RequestHeader("Authorization") String token, @PathVariable UUID id){
        if (TokenAuth.isTokenValid(token)) {
            return new ResponseEntity(new ResponseDto<>(platformService.deletePlatform(id)),HttpStatus.OK);
        }else {
            return new ResponseEntity(new ResponseDto<>(TokenAuth.TOKEN_ERROR), HttpStatus.UNAUTHORIZED);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity updatePlatform(@RequestHeader("Authorization") String token, @PathVariable UUID id, @RequestBody Platform platform){
        if (TokenAuth.isTokenValid(token)) {
            return new ResponseEntity<>(new ResponseDto(platformService.updatePlatform(id,platform)),HttpStatus.OK);
        }else {
            return new ResponseEntity(new ResponseDto<>(TokenAuth.TOKEN_ERROR), HttpStatus.UNAUTHORIZED);
        }
    }

    @PutMapping("/toggle/{id}")
    public ResponseEntity activateOrDisablePlatform(@RequestHeader("Authorization") String token, @PathVariable UUID id, @RequestBody ToggleState toggleState){
        if (TokenAuth.isTokenValid(token)) {
            return new ResponseEntity<>(new ResponseDto(platformService.activateOrDisablePlatform(id,toggleState)),HttpStatus.OK);
        }else {
            return new ResponseEntity(new ResponseDto<>(TokenAuth.TOKEN_ERROR), HttpStatus.UNAUTHORIZED);
        }
    }

}
