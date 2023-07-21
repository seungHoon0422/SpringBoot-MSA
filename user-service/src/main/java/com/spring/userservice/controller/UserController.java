package com.spring.userservice.controller;

import com.spring.userservice.dto.request.saveRequest;
import com.spring.userservice.dto.response.saveResponse;
import com.spring.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.xml.validation.Validator;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user-service")
public class UserController {

    private final UserService userService;

    @GetMapping("/health-check")
    public String healthCheck() {
        System.out.println("GET health-check");
        return "OK";
    }

    @PostMapping("/user")
    public saveResponse save(@RequestBody saveRequest request) {
        return userService.save(request);
    }




}
