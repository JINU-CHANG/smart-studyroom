package com.iot.smartstudyroom.controller;

import com.iot.smartstudyroom.service.CheckService;
import com.iot.smartstudyroom.service.InvalidUsageCheckRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class CheckController {

    private final CheckService checkService;

    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }

    @PostMapping("/checkInvalidUsage")
    public String checkInvalidUsage(@RequestBody InvalidUsageCheckRequest request) {
        return checkService.checkInvalidUsage(request);
    }
}
