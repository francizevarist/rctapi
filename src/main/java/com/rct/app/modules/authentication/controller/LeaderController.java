package com.rct.app.modules.authentication.controller;

import com.rct.app.commondto.ResponseDto;
import com.rct.app.commondto.ToggleState;
import com.rct.app.modules.authentication.model.User;
import com.rct.app.modules.authentication.service.LeaderService;
import com.rct.app.modules.authentication.service.TokenAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("api/v1/leader")
@RestController
public class LeaderController {
    private final LeaderService leaderService;

    @Autowired
    public LeaderController(LeaderService leaderService) {
        this.leaderService = leaderService;
    }

    @PostMapping("/{platformid}")
    public ResponseEntity createLeader(@RequestHeader("Authorization") String token, @PathVariable UUID platformid, @RequestBody User user){
        if (TokenAuth.isTokenValid(token)) {
            return new ResponseEntity(new ResponseDto<>(leaderService.createLeader(platformid, user)), HttpStatus.OK);
        }else {
            return new ResponseEntity(new ResponseDto<>(TokenAuth.TOKEN_ERROR), HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping
    public ResponseEntity getAllLeader(@RequestHeader("Authorization") String token){
        if (TokenAuth.isTokenValid(token)) {
            return new ResponseEntity(new ResponseDto<>(leaderService.getAllLeader()),HttpStatus.OK);
        }else {
            return new ResponseEntity(new ResponseDto<>(TokenAuth.TOKEN_ERROR), HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/platform/{id}")
    public ResponseEntity getAllLeaderByPlatform(@RequestHeader("Authorization") String token, @PathVariable UUID id){
        if (TokenAuth.isTokenValid(token)) {
            return new ResponseEntity(new ResponseDto<>(leaderService.getAllLeaderByPlatform(id)),HttpStatus.OK);
        }else {
            return new ResponseEntity(new ResponseDto<>(TokenAuth.TOKEN_ERROR), HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getLeader(@RequestHeader("Authorization") String token, @PathVariable UUID id){
        if (TokenAuth.isTokenValid(token)) {
            return new ResponseEntity(new ResponseDto<>(leaderService.getLeaderById(id)),HttpStatus.OK);
        }else {
            return new ResponseEntity(new ResponseDto<>(TokenAuth.TOKEN_ERROR), HttpStatus.UNAUTHORIZED);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteLeader(@RequestHeader("Authorization") String token, @PathVariable UUID id){
        if (TokenAuth.isTokenValid(token)) {
            return new ResponseEntity(new ResponseDto<>(leaderService.deleteLeaderById(id)),HttpStatus.OK);
        }else {
            return new ResponseEntity(new ResponseDto<>(TokenAuth.TOKEN_ERROR), HttpStatus.UNAUTHORIZED);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity updateLeader(@RequestHeader("Authorization") String token, @PathVariable UUID id, @RequestBody User user){
        if (TokenAuth.isTokenValid(token)) {
            return new ResponseEntity(new ResponseDto<>(leaderService.updateLeaderById(id,user)),HttpStatus.OK);
        }else {
            return new ResponseEntity(new ResponseDto<>(TokenAuth.TOKEN_ERROR), HttpStatus.UNAUTHORIZED);
        }
    }

    @PutMapping("/toggle/{id}")
    public ResponseEntity activateOrDisableLeader(@RequestHeader("Authorization") String token, @PathVariable UUID id, @RequestBody ToggleState toggleState){
        if (TokenAuth.isTokenValid(token)) {
            return new ResponseEntity(new ResponseDto<>(leaderService.activateOrDisableLeader(id,toggleState)),HttpStatus.OK);
        }else {
            return new ResponseEntity(new ResponseDto<>(TokenAuth.TOKEN_ERROR), HttpStatus.UNAUTHORIZED);
        }
    }
}
