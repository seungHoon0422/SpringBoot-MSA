package com.spring.placeservice.dto.request;

import lombok.Getter;

@Getter
public class SavePlaceRequest {

    private String name;
    private String sido;
    private String gugun;
    private String fullAddress;
    private String detail;

}
