package com.example.webmovie.Repository;

import com.example.webmovie.Model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    Movie findAllByTitle(String title);

    boolean existsByTitle(String title);


}
