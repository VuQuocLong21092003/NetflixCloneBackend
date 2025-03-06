package com.example.webmovie.service.impl;

import com.example.webmovie.Model.User;
import com.example.webmovie.Repository.UserRepository;
import com.example.webmovie.dto.request.AuthRequest;
import com.example.webmovie.dto.request.IntrospectRequest;
import com.example.webmovie.dto.response.ApiResponse;
import com.example.webmovie.dto.response.AuthResponse;
import com.example.webmovie.dto.response.IntrospectResponse;
import com.example.webmovie.exception.AppException;
import com.example.webmovie.exception.ErrorCode;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.NonFinal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.security.SignedObject;

import java.text.ParseException;
import java.util.Date;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl {
    private final UserRepository userRepository;

    @NonFinal
    private static final String SIGN = "5020f057d0d31c44d2397a3265c89b86b95a1903160610e290786cfe36e43e7b";

    public AuthResponse authenticateUser(AuthRequest authRequest) {
        User user = userRepository.findByEmail(authRequest.getEmail()).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND));

        if (!user.getPasswordHash().equals(authRequest.getPasswordHash())){
            throw new AppException(ErrorCode.INVALID_CREDENTIALS);
        }

        var token = generateToken(user.getEmail());

        return AuthResponse.builder()
                .token(token)
                .authenticated(true)
                .build();
    }


    public IntrospectResponse introspectToken(IntrospectRequest request) throws JOSEException, ParseException
    {
        String token = request.getToken();

        JWSVerifier verifier = new MACVerifier(SIGN.getBytes());

        SignedJWT signedJWT = SignedJWT.parse(token);

        Date expirationTime = signedJWT.getJWTClaimsSet().getExpirationTime();

        var verified = signedJWT.verify(verifier);

        return IntrospectResponse.builder()
                .active(verified && expirationTime.after(new Date()))
                .build();

    }

    private String generateToken(String email) {
        JWSHeader jwsHeader = new JWSHeader(JWSAlgorithm.HS512);

        JWTClaimsSet jwtClaimsSet = new JWTClaimsSet.Builder()
                .subject(email)
                .issuer("webmovie")
                .issueTime(new Date())
                .expirationTime(new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000))
                .claim("email", email)
                .build();

        Payload payload = new Payload(jwtClaimsSet.toJSONObject());

        JWSObject jwsObject = new JWSObject(jwsHeader, payload);

        try {
            jwsObject.sign(new MACSigner(SIGN.getBytes()));
            return jwsObject.serialize();
        } catch (Exception e) {
            log.error("Error while generating token", e);
            throw new AppException(ErrorCode.TOKEN_GENERATION_FAILED);
        }
    }



}
