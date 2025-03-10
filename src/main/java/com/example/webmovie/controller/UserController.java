package com.example.webmovie.controller;

import com.example.webmovie.dto.request.UpdateUseRequest;
import com.example.webmovie.dto.request.UserRequest;
import com.example.webmovie.dto.response.ApiResponse;
import com.example.webmovie.dto.response.PageResponse;
import com.example.webmovie.dto.response.UserResponse;
import com.example.webmovie.exception.AppException;
import com.example.webmovie.exception.ErrorCode;
import com.example.webmovie.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@Validated
@RequiredArgsConstructor  // Lombok tự động tạo constructor
@Slf4j
public class UserController {
    private final UserService userService;

    @GetMapping()
    public ApiResponse<?> getUserByFullName(@RequestParam("fullName") String fullName,
                                                       @RequestParam(defaultValue = "0", required = false) int page,
                                                       @Min(5) @RequestParam(defaultValue = "20", required = false) int size) {

        PageResponse<?> userResponse = userService.findByFullName(fullName, page, size);

        return ApiResponse.<PageResponse<?>>builder()
                .status(HttpStatus.OK.value())
                .message("Get User by full name successfully")
                .data(userResponse)
                .build();
    }

    @PostMapping
    public ApiResponse<UserResponse> creationUser(@RequestBody @Valid UserRequest userRequest) {
        UserResponse userResponse = userService.save(userRequest);

        return ApiResponse.<UserResponse>builder()
                .status(HttpStatus.CREATED.value())
                .message("User created successfully")
                .data(userResponse)
                .build();
    }

    @GetMapping("/all")
    public ApiResponse<?> getAllUsers(@RequestParam(defaultValue = "0", required = false) int page,
                                                       @Min(5) @RequestParam(defaultValue = "20", required = false) int size,
                                                       @RequestParam String sortBy) {
        PageResponse<?> userResponses = userService.findAll(page, size, sortBy);


        return ApiResponse.<PageResponse<?>>builder()
                .status(HttpStatus.OK.value())
                .message("Get all users successfully")
                .data(userResponses)
                .build();

    }

    @PutMapping("/{id}")
    public ApiResponse updateUser(@PathVariable Long id,@Valid @RequestBody UpdateUseRequest updateUseRequest) {
        userService.update(id, updateUseRequest);

        return ApiResponse.builder()
                .status(HttpStatus.OK.value())
                .message("Update user successfully")
                .build();

    }


}
