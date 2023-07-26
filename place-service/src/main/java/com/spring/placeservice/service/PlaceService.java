package com.spring.placeservice.service;

import com.spring.placeservice.dto.request.SavePlaceRequest;
import com.spring.placeservice.dto.response.PlaceResponse;
import com.spring.placeservice.entity.Place;
import com.spring.placeservice.repository.PlaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlaceService {

    private final PlaceRepository placeRepository;

    public PlaceResponse savePlace(SavePlaceRequest request) {
        Place place = Place.builder()
                .name(request.getName())
                .sido(request.getSido())
                .gugun(request.getGugun())
                .fullAddress(request.getFullAddress())
                .detail(request.getDetail())
                .build();
        Place savedPlace = placeRepository.save(place);
        return new PlaceResponse(savedPlace);
    }

    public PlaceResponse getPlaceInfo(Long placeId) {

        Place place = placeRepository.findById(placeId).orElseThrow();
        return new PlaceResponse(place);
    }
}
