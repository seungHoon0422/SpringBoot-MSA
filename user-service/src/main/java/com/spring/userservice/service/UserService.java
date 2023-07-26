package com.spring.userservice.service;

import com.spring.userservice.dto.request.PatchUserRequest;
import com.spring.userservice.dto.request.saveUserRequest;
import com.spring.userservice.dto.response.getUserResponse;
import com.spring.userservice.entity.Favorite;
import com.spring.userservice.entity.User;
import com.spring.userservice.dto.response.saveResponse;
import com.spring.userservice.feign.PlaceFeignClient;
import com.spring.userservice.feign.response.PlaceResponse;
import com.spring.userservice.repository.FavoriteRepository;
import com.spring.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;
    private final PlaceFeignClient placeFeignClient;
    private final FavoriteRepository favoriteRepository;

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
        if (getUser.isEmpty()) return null;
        User user = getUser.get();
        return new getUserResponse(user.getId(), user.getName(), user.getNickname(), user.getCreatedDate());
    }


    public void patchUserInfo(PatchUserRequest request) {

    }


    public void saveUserFavorite(Long userId, Long placeId) {
        boolean isExist = favoriteRepository.existsByUserIdAndPlaceId(userId, placeId);
        if(isExist) {
            return;
        }
        User user = userRepository.findById(userId).orElseThrow(NullPointerException::new);

        favoriteRepository.save(Favorite.builder()
                                        .user(user)
                                        .placeId(placeId).build());
    }

    public List<PlaceResponse> getUserFavorite(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(NullPointerException::new);
        List<Favorite> favoriteList = user.getFavoriteList();
        log.info("favorite list size() : " + favoriteList.size());



        List<PlaceResponse> response = new ArrayList<>();
        for (Favorite favorite : favoriteList) {
            ResponseEntity<PlaceResponse> placeInfo = placeFeignClient.getPlaceInfo(favorite.getPlaceId());
            response.add(placeInfo.getBody());
        }
        log.info("response size() : " + response.size());
        return response;

    }


    public List<Long> getUserFavoriteList(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(NullPointerException::new);
        List<Long> response = new ArrayList<>();
        for (Favorite favorite : user.getFavoriteList()) {
            response.add(favorite.getPlaceId());
        }
        return response;

    }
}
