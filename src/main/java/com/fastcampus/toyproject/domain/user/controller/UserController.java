package com.fastcampus.toyproject.domain.user.controller;

import com.fastcampus.toyproject.common.dto.ResponseDTO;
import com.fastcampus.toyproject.config.security.jwt.UserPrincipal;
import com.fastcampus.toyproject.domain.trip.dto.TripDetailResponse;
import com.fastcampus.toyproject.domain.trip.dto.TripResponse;
import com.fastcampus.toyproject.domain.user.service.UserService;
import java.util.Collections;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/trip-list")
    public ResponseDTO<List<TripResponse>> getAllTrip(
        final UserPrincipal userPrincipal) {
        return userService.getAllTrip(userPrincipal.getUserId())
            .map(tripResponses -> ResponseDTO.ok("사용자 여행 검색 완료", tripResponses))
            .orElse(ResponseDTO.ok("검색된 여행이 없습니다.", Collections.emptyList()));
    }

    @GetMapping("/trip-detail/{tripId}")
    public ResponseDTO<TripDetailResponse> getDetailTrip(
        final UserPrincipal userPrincipal,
        @PathVariable final Long tripId) {
        return ResponseDTO.ok("사용자 상세 여행 검색 완료", userService.getDetailTrip(userPrincipal.getUserId(), tripId));
    }

    @GetMapping("/trip-like-list")
    public ResponseDTO<List<TripResponse>> getLikeTrip(
        final UserPrincipal userPrincipal
    ){
        return ResponseDTO.ok("사용자 좋아요 여행 검색 완료", userService.getLikeTrip(userPrincipal.getUserId()));
    }

}

