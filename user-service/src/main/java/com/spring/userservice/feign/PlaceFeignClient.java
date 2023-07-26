package com.spring.userservice.feign;

import com.spring.userservice.feign.response.PlaceResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(
        name = "palce-service",
        url = "http://localhost:8000"
)
public interface PlaceFeignClient {
    @GetMapping("/place-service/{place_id}")
    ResponseEntity<PlaceResponse> getPlaceInfo(@PathVariable(name = "place_id") Long placeId);

    @GetMapping("/place-service/favorite/{palce_id}")
    PlaceResponse placeInfo(@PathVariable(name = "place_id") Long placeId);

}
