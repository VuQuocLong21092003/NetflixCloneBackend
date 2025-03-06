package com.example.webmovie.controller;

import com.example.webmovie.dto.request.AuthRequest;
import com.example.webmovie.dto.request.IntrospectRequest;
import com.example.webmovie.dto.response.ApiResponse;
import com.example.webmovie.dto.response.AuthResponse;
import com.example.webmovie.dto.response.IntrospectResponse;
import com.example.webmovie.service.impl.AuthenticationServiceImpl;
import com.nimbusds.jose.JOSEException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationServiceImpl authenticationService;

    @PostMapping("/login")
    public ApiResponse<AuthResponse> getAuthRequest(@RequestBody AuthRequest authRequest) {
        AuthResponse authResponse = authenticationService.authenticateUser(authRequest);

        return ApiResponse.<AuthResponse>builder()
                .status(HttpStatus.OK.value())
                .message("Login successfully")
                .data(authResponse)
                .build();
    }


    @PostMapping("/introspect")
    public ApiResponse<IntrospectResponse> getAuthRequest(@RequestBody IntrospectRequest introspectRequest)  throws ParseException, JOSEException {

        var introspectResponse = authenticationService.introspectToken(introspectRequest);

        return ApiResponse.<IntrospectResponse>builder()
                .status(HttpStatus.OK.value())
                .data(introspectResponse)
                .build();
    }

}
