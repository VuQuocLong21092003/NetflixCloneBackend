package com.example.webmovie.mapper;

import com.example.webmovie.Model.Movie;
import com.example.webmovie.dto.request.MovieRequest;
import com.example.webmovie.dto.response.MovieSearchResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MovieMapper {
    MovieSearchResponse toMovieSearchResponse(Movie movie);

    List<MovieSearchResponse> toMovieSearchResponse(List<Movie> movies);

    Movie toMovie(MovieRequest movieRequest);
}
