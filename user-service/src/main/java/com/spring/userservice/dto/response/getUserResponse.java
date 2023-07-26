package com.spring.userservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class getUserResponse {

    private Long id;
    private String name;
    private String nickname;
    private LocalDateTime createdDate;

}
