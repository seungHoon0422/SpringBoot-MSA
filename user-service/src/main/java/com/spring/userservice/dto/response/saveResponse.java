package com.spring.userservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class saveResponse {
    private Long id;
    private String name;
    private String password;
    private LocalDateTime createdDate;
}
