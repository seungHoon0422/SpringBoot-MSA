package com.spring.placeservice.controller;

import com.spring.placeservice.dto.request.SavePlaceRequest;
import com.spring.placeservice.dto.response.PlaceResponse;
import com.spring.placeservice.service.PlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/place-service")
public class PlaceController {

    private final PlaceService placeService;


    @GetMapping("/health-check")
    public String healthCheck() {
        return "OK";
    }

    @PostMapping("/")
    public ResponseEntity<PlaceResponse> savePlace(@RequestBody SavePlaceRequest request) {
        PlaceResponse response = placeService.savePlace(request);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }


    @GetMapping("/{place_id}")
    public PlaceResponse getPlaceInfo(@PathVariable(name = "place_id") Long placeId) {
        PlaceResponse response = placeService.getPlaceInfo(placeId);
        return response;
//        return new ResponseEntity<>(response, HttpStatus.OK);

    }



}
