package com.spring.userservice.dto.request;

import lombok.Getter;

@Getter
public class saveUserRequest {
    private String name;
    private String password;
    private String nickname;
}
