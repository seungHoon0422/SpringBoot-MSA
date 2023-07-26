package com.spring.placeservice.entity;


import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column
    private String sido;

    @Column
    private String gugun;
    @Column
    private String fullAddress;
    @Column
    private String detail;

    @Column
    private LocalDateTime createdDate;

    @Builder
    public Place(String name, String sido, String gugun, String fullAddress, String detail) {
        this.name = name;
        this.sido = sido;
        this.gugun = gugun;
        this.fullAddress = fullAddress;
        this.detail = detail;
        this.createdDate = LocalDateTime.now();
    }

}
