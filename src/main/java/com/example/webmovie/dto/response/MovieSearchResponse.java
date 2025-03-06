package com.example.webmovie.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MovieSearchResponse {

    private String title;
    private String thumbnailUrl;

}
