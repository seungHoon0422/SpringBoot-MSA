package com.spring.userservice.service;

import com.spring.userservice.dto.request.saveRequest;
import com.spring.userservice.entity.User;
import com.spring.userservice.dto.response.saveResponse;
import com.spring.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public saveResponse save(saveRequest request) {
        User saveUser = userRepository.save(
                    User.builder()
                        .name(request.getName())
                        .password(request.getPassword()).build());
        saveResponse response = new saveResponse(saveUser.getId(), saveUser.getName(),
                                                saveUser.getPassword(), saveUser.getCreatedDate());
        return response;
    }







}
