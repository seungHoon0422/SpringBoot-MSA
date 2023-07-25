package com.spring.userservice.entity;


import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column
    private String nickname;

    @Column(name = "password")
    @NotNull
    private String password;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private Type type;

    @Column
    private LocalDateTime createdDate;

    @Builder
    public User(String name, String nickname, String password) {
        this.name = name;
        this.nickname = nickname;
        this.password = password;
        this.type = Type.USER;
        this.createdDate = LocalDateTime.now();
    }


}
