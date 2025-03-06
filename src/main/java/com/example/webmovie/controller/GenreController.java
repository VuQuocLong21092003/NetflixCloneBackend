package com.example.webmovie.controller;

import com.example.webmovie.dto.request.GenreRequest;
import com.example.webmovie.dto.response.ApiResponse;
import com.example.webmovie.dto.response.GenreResponse;
import com.example.webmovie.dto.response.MovieSearchResponse;
import com.example.webmovie.service.GenreService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/genre")
@Validated
@RequiredArgsConstructor  // Lombok tự động tạo constructor
@Slf4j
public class GenreController {

    private final GenreService genreService;

    @PostMapping("/add")
    public ApiResponse<GenreResponse> addGenre(@RequestBody @Valid GenreRequest genreRequest) {
        GenreResponse genreResponse = genreService.addGenre(genreRequest);
        return ApiResponse.<GenreResponse>builder()
                .status(HttpStatus.OK.value())
                .message("Add genre successfully")
                .data(genreResponse)
                .build();
    }
}
