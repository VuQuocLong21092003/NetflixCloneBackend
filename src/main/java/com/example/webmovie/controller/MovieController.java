package com.example.webmovie.controller;

import com.example.webmovie.dto.response.ApiResponse;
import com.example.webmovie.dto.response.MovieSearchResponse;
import com.example.webmovie.service.MovieService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movies")
@Validated
@RequiredArgsConstructor  // Lombok tự động tạo constructor
@Slf4j
public class MovieController {
    private final MovieService movieService;

    @GetMapping("/all")
    public ApiResponse<List<MovieSearchResponse>> allMovie() {
        List<MovieSearchResponse> movieSearchResponse = movieService.allMovie();
        return ApiResponse.<List<MovieSearchResponse>>builder()
                .status(HttpStatus.OK.value())
                .message("Get all movies successfully")
                .data(movieSearchResponse)
                .build();
    }


    @GetMapping("")
    public ApiResponse<MovieSearchResponse> findMovieByName(@RequestParam("title") String title) {
        MovieSearchResponse movieSearchResponse = movieService.findMovieByName(title);
        return ApiResponse.<MovieSearchResponse>builder()
                .status(HttpStatus.OK.value())
                .message("Get movie by name successfully")
                .data(movieSearchResponse)
                .build();
    }
}
