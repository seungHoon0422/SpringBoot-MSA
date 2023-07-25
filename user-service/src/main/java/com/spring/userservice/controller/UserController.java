package com.spring.userservice.controller;

import com.spring.userservice.dto.request.PatchUserRequest;
import com.spring.userservice.dto.request.saveUserRequest;
import com.spring.userservice.dto.response.saveResponse;
import com.spring.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/")
    public saveResponse save(@RequestBody saveUserRequest request) {
        return userService.save(request);
    }


    @GetMapping("/{user_id}")
    public void getUserInfo(@PathVariable(name = "user_id") Long userId) {

    }

    @PatchMapping("/")
    public void patchUserInfo(@RequestBody PatchUserRequest request) {

    }


    @PostMapping("/{user_id}/favorite/{place_id}")
    public void getUserInfo(@PathVariable(name = "user_id") Long userId, @PathVariable(name = "place_id") Long placeId) {
    }

    @GetMapping("/{user_id}/favorite")
    public void getUserFavorite(@PathVariable(name = "user_id") Long userId) {
    }




}
