package com.example.webmovie.service.impl;

import com.example.webmovie.Model.Genre;
import com.example.webmovie.Repository.GenreRepository;
import com.example.webmovie.dto.request.GenreRequest;
import com.example.webmovie.dto.response.GenreResponse;
import com.example.webmovie.exception.AppException;
import com.example.webmovie.exception.ErrorCode;
import com.example.webmovie.mapper.GenreMapper;
import com.example.webmovie.service.GenreService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class GenreServiceImpl implements GenreService {
    private final GenreRepository genreRepository;
    private final GenreMapper genreMapper;

    @Override
    public GenreResponse addGenre(GenreRequest genreRequest) {
        if (genreRepository.existsByName(genreRequest.getName())) {
            throw new AppException(ErrorCode.GENRE_EXISTED);
        }
        Genre genre = genreMapper.toGenre(genreRequest);
        genre = genreRepository.save(genre); // Đảm bảo lấy dữ liệu sau khi lưu

        return genreMapper.toGenreResponse(genre);
    }
}
