package com.iot.smartstudyroom.controller;

import com.iot.smartstudyroom.service.MemberService;
import com.iot.smartstudyroom.service.dto.LoginRequest;
import com.iot.smartstudyroom.service.dto.ReserveRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MemberController {

    private final MemberService reserveService;
    private final MemberService memberService;

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        return memberService.login(request);
    }

    @PostMapping("/reserve")
    public void reserve(@RequestBody ReserveRequest request) {
        reserveService.reserve(request);
    }
}
