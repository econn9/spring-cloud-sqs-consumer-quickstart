package com.consumer.controller;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import java.util.Date;

@RestController
public class HealthController {

    @GetMapping("/health")
    public @ResponseBody ResponseEntity<String> healthCheck() {
        return new ResponseEntity<String>("Up and Running, Boss...\n" + currentTime(), HttpStatus.OK);
    }

    private String currentTime() {
        return new Date().toGMTString();
    }
}
