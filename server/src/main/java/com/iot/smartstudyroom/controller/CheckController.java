package com.iot.smartstudyroom.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CheckController {

    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }
}
