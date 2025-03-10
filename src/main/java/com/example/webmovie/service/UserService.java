package com.example.webmovie.service;

import com.example.webmovie.dto.request.UpdateUseRequest;
import com.example.webmovie.dto.request.UserRequest;
import com.example.webmovie.dto.response.PageResponse;
import com.example.webmovie.dto.response.UserResponse;

import java.util.List;

public interface UserService {
    PageResponse<?> findByFullName(String fullName, int page, int size);

    UserResponse save(UserRequest userRequest);

    void update(Long id, UpdateUseRequest updateUseRequest);

    PageResponse<?> findAll(int page, int size, String sortBy);
}
