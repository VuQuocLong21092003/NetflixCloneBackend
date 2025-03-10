package com.example.webmovie.service.impl;

import com.example.webmovie.Model.User;
import com.example.webmovie.Repository.UserRepository;
import com.example.webmovie.dto.request.UpdateUseRequest;
import com.example.webmovie.dto.request.UserRequest;
import com.example.webmovie.dto.response.PageResponse;
import com.example.webmovie.dto.response.UserResponse;
import com.example.webmovie.exception.AppException;
import com.example.webmovie.exception.ErrorCode;
import com.example.webmovie.mapper.UserMapper;
import com.example.webmovie.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public PageResponse<?> findByFullName(String fullName, int page, int size) {
        if (!userRepository.existsByFullName(fullName)) {
            throw new AppException(ErrorCode.USER_NOT_FOUND);
        }

        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "id"));

        Page<User> users = userRepository.findUsersByFullNameContaining(fullName, pageable);

        return converToPageResponse(users, pageable);
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
    public void update(Long id, UpdateUseRequest updateUseRequest) {
        User user = userRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND));

        user.setFullName(updateUseRequest.getFullName());
        user.setEmail(updateUseRequest.getEmail());
        user.setPasswordHash(updateUseRequest.getPasswordHash());
        user.setPhoneNumber(updateUseRequest.getPhoneNumber());
        user.setDateOfBirth(updateUseRequest.getDateOfBirth());
        userRepository.save(user);
    }

    @Override
    public PageResponse<?> findAll(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, sortBy));
        Page<User> users = userRepository.findAll(pageable);
        return converToPageResponse(users, pageable);
    }

    private PageResponse<?> converToPageResponse(Page<User> users, Pageable pageable) {
        List<UserResponse> userList = userMapper.toUserResponseList(users.getContent());
        return PageResponse.<List<UserResponse>>builder()
                .page(users.getNumber()) // Trang hiện tại
                .size(users.getSize()) // Số phần tử mỗi trang
                .total(users.getTotalElements()) // Tổng số phần tử
                .totalPages(users.getTotalPages()) // Tổng số trang
                .hasNext(users.hasNext()) // Có trang tiếp theo không?
                .hasPrevious(users.hasPrevious()) // Có trang trước không?
                .items(userList)
                .build();
    }
}
