package com.example.webmovie.dto.response;

import lombok.*;

import java.io.Serializable;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GenreResponse implements Serializable {
    private String name;
    private String description;
}
