package com.example.webmovie.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "movies")
public class Movie extends BaseEntity<Long> {
    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "release_year")
    private Integer releaseYear;

    @Column(name = "duration")
    private Integer duration;  // Duration in minutes

    @Column(name = "rating")
    private Double rating;

    @Column(name = "thumbnail_url")
    private String thumbnailUrl;

    @Column(name = "video_url")
    private String videoUrl;

}