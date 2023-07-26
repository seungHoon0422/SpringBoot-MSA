package com.spring.userservice.controller;

import com.spring.userservice.dto.request.PatchUserRequest;
import com.spring.userservice.dto.request.saveUserRequest;
import com.spring.userservice.dto.response.saveResponse;
import com.spring.userservice.feign.response.PlaceResponse;
import com.spring.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


//    @PostMapping("/{user_id}/favorite/{place_id}")
//    public ResponseEntity<?> saveUserFavorite(@PathVariable(name = "user_id") Long userId, @PathVariable(name = "place_id") Long placeId) {
//        userService.saveUserFavorite(userId, placeId);
//        return new ResponseEntity<>(HttpStatus.CREATED);
//    }

    @GetMapping("/{user_id}/favorite")
    public ResponseEntity<List<PlaceResponse>> getUserFavorite(@PathVariable(name = "user_id") Long userId) {
        List<PlaceResponse> response = userService.getUserFavorite(userId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @GetMapping("/{user_id}/favorite/list")
    public ResponseEntity<List<Long>> getUserFavoriteList(@PathVariable(name = "user_id") Long userId) {
        List<Long> response = userService.getUserFavoriteList(userId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
