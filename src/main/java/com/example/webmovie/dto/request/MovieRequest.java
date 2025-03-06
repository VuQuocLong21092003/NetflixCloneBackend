package com.example.webmovie.dto.request;

import com.example.webmovie.Model.Genre;
import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MovieRequest implements Serializable {

    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Description is required")
    private String description;

    @NotNull(message = "Release year is required")
    @Min(value = 1888, message = "Release year must be after 1888") // Bộ phim đầu tiên ra mắt năm 1888
    private Integer releaseYear;

    @NotNull(message = "Duration is required")
    @Min(value = 1, message = "Duration must be at least 1 minute")
    private Integer duration;

    @NotNull(message = "Rating is required")
    @DecimalMin(value = "0.0", message = "Rating must be at least 0.0")
    @DecimalMax(value = "10.0", message = "Rating cannot exceed 10.0")
    private Double rating;

    private String thumbnailUrl;

    private String videoUrl;

    private List<String> genres;
}
