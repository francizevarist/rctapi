package com.rct.app.modules.test;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("api/v1/test")
@RestController
public class TestController {

    @GetMapping
    public String testapp(){
        return "RCT APP is up-and-running";
    }
}
