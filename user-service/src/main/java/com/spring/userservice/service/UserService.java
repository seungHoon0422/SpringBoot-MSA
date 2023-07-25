package com.spring.userservice.service;

import com.spring.userservice.dto.request.saveUserRequest;
import com.spring.userservice.dto.response.getUserResponse;
import com.spring.userservice.entity.User;
import com.spring.userservice.dto.response.saveResponse;
import com.spring.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public saveResponse save(saveUserRequest request) {
        User saveUser = userRepository.save(
                    User.builder()
                        .name(request.getName())
                        .nickname(request.getNickname())
                        .password(request.getPassword()).build());

        saveResponse response = new saveResponse(saveUser.getId(), saveUser.getName(),
                                                saveUser.getPassword(), saveUser.getCreatedDate());
        return response;
    }

    public getUserResponse getUserInfo(Long userId) {
        Optional<User> getUser = userRepository.findById(userId);


    }







}
