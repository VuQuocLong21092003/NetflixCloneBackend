package com.example.webmovie.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {

    USER_EXISTED(400, "User existed", HttpStatus.BAD_REQUEST),
    USER_NOT_FOUND(404, "User not found", HttpStatus.NOT_FOUND),
    INVALID_CREDENTIALS(401, "Invalid credentials", HttpStatus.UNAUTHORIZED),
    MOVIE_NOT_FOUND(404, "Movie not found", HttpStatus.NOT_FOUND),
    MOVIE_EXISTED(400, "Movie existed", HttpStatus.BAD_REQUEST),
    GENRE_EXISTED(400, "Genre existed", HttpStatus.BAD_REQUEST),
    TOKEN_GENERATION_FAILED(500, "Failed to generate token", HttpStatus.INTERNAL_SERVER_ERROR);




    private final int code;
    private final String message;
    private final HttpStatus httpStatus;

    ErrorCode(int code, String message, HttpStatus httpStatus) {
        this.code = code;
        this.message = message;
        this.httpStatus = httpStatus;
    }

}
