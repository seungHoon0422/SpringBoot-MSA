package com.spring.userservice.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Favorite {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @Column
    private Long placeId;

    @Builder
    public Favorite(User user, Long placeId) {
        this.user = user;
        this.placeId = placeId;
    }

}
