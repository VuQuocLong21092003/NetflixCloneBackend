package com.example.webmovie.service.impl;

import com.example.webmovie.Model.Genre;
import com.example.webmovie.Model.Movie;
import com.example.webmovie.Repository.GenreRepository;
import com.example.webmovie.Repository.MovieGenreRepository;
import com.example.webmovie.Repository.MovieRepository;
import com.example.webmovie.dto.request.MovieRequest;
import com.example.webmovie.dto.response.MovieSearchResponse;
import com.example.webmovie.exception.AppException;
import com.example.webmovie.exception.ErrorCode;
import com.example.webmovie.mapper.MovieMapper;
import com.example.webmovie.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;
    private final MovieGenreRepository movieGenreRepository;

    @Override
    public List<MovieSearchResponse> allMovie() {
        List<Movie> movies = movieRepository.findAll();

        return movieMapper.toMovieSearchResponse(movies);
    }

    @Override
    public MovieSearchResponse findMovieByName(String title) {
        if (!movieRepository.existsByTitle(title)) {
            throw new AppException(ErrorCode.MOVIE_NOT_FOUND);
        }

        Movie movie = movieRepository.findAllByTitle(title);

        return movieMapper.toMovieSearchResponse(movie);
    }

    @Override
    public MovieSearchResponse createMovie(MovieRequest movieRequest) {
        if (movieRepository.existsByTitle(movieRequest.getTitle())) {
            throw new AppException(ErrorCode.MOVIE_EXISTED);
        }

//        List<String> genres = movieRequest.getGenres();
//
//        List<Set<Genre>> genreList = genreRepository.(genres);
        return null;

    }


}
