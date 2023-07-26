package com.spring.placeservice.dto.response;

import com.spring.placeservice.entity.Place;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class PlaceResponse {

    private Long id;

    private String name;

    private String sido;

    private String gugun;
    private String fullAddress;
    private String detail;

    private LocalDateTime createdDate;

    public PlaceResponse (Place place) {
        this.id = place.getId();
        this.name = place.getName();
        this.sido = place.getSido();
        this.gugun = place.getGugun();
        this.fullAddress = place.getFullAddress();
        this.detail = place.getDetail();
        this.createdDate = place.getCreatedDate();
    }


}
