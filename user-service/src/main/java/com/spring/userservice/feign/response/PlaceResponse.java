package com.spring.userservice.feign.response;

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

}