package com.example.webmovie.service;

import com.example.webmovie.dto.request.UpdateUseRequest;
import com.example.webmovie.dto.request.UserRequest;
import com.example.webmovie.dto.response.UserResponse;

import java.util.List;

public interface UserService {
    UserResponse findByFullName(String fullName);

    UserResponse save(UserRequest userRequest);

    List<UserResponse> findAll();

    void update(Long id, UpdateUseRequest updateUseRequest);
}
