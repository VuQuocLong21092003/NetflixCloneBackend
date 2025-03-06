package com.example.webmovie.service;

import com.example.webmovie.dto.request.GenreRequest;
import com.example.webmovie.dto.response.GenreResponse;

public interface GenreService {
    GenreResponse addGenre(GenreRequest genreRequest);
}
