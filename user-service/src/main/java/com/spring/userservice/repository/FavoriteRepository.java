package com.spring.userservice.repository;


import com.spring.userservice.entity.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
    boolean existsByUserIdAndPlaceId(Long userId, Long placeId);

    List<Long> findByUserId(Long userId);
}

