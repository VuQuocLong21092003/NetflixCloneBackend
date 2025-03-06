package com.example.webmovie.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class GenreRequest {
    @NotBlank(message = "Name is required")
    private String name;


    private String description;
}
