package com.spring.userservice.dto.request;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatchUserRequest {
    private String password;
    private String nickname;
}
