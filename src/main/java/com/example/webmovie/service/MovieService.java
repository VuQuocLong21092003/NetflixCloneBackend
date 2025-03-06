package com.example.webmovie.service;

import com.example.webmovie.dto.request.MovieRequest;
import com.example.webmovie.dto.response.MovieSearchResponse;

import java.util.List;

public interface MovieService {
    List<MovieSearchResponse> allMovie();

    MovieSearchResponse findMovieByName(String title);

    MovieSearchResponse createMovie(MovieRequest movieRequest);
}
