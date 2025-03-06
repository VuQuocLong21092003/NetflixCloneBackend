package com.example.webmovie.service.impl;

import com.example.webmovie.Model.User;
import com.example.webmovie.Repository.UserRepository;
import com.example.webmovie.dto.request.UpdateUseRequest;
import com.example.webmovie.dto.request.UserRequest;
import com.example.webmovie.dto.response.UserResponse;
import com.example.webmovie.exception.AppException;
import com.example.webmovie.exception.ErrorCode;
import com.example.webmovie.mapper.UserMapper;
import com.example.webmovie.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserResponse findByFullName(String fullName) {
        if (!userRepository.existsByFullName(fullName)) {
            throw new AppException(ErrorCode.USER_NOT_FOUND);
        }
        User user = userRepository.findByFullName(fullName).orElseThrow();
        return userMapper.toUserReponse(user);
    }

    @Override
    public UserResponse save(UserRequest userRequest) {
        if (userRepository.existsByEmail(userRequest.getEmail())) {
            throw new AppException(ErrorCode.USER_EXISTED);
        }
        User user = userMapper.toUser(userRequest);
        userRepository.save(user);
        return userMapper.toUserReponse(user);
    }

    @Override
    public List<UserResponse> findAll() {
        List<User> users = userRepository.findAll();

        return userMapper.toUserResponseList(users);
    }

    @Override
    public void update(Long id, UpdateUseRequest updateUseRequest) {
        User user = userRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND));

        user.setFullName(updateUseRequest.getFullName());
        user.setEmail(updateUseRequest.getEmail());
        user.setPasswordHash(updateUseRequest.getPasswordHash());
        user.setPhoneNumber(updateUseRequest.getPhoneNumber());
        user.setDateOfBirth(updateUseRequest.getDateOfBirth());
        userRepository.save(user);
    }


}
