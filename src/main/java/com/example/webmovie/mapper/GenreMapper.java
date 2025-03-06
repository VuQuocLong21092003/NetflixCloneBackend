package com.example.webmovie.mapper;

import com.example.webmovie.Model.Genre;
import com.example.webmovie.dto.request.GenreRequest;
import com.example.webmovie.dto.response.GenreResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface GenreMapper {
    Genre toGenre(GenreRequest genreRequest);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    GenreResponse toGenreResponse(Genre genre);
}
