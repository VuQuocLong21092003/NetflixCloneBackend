package com.example.webmovie.Repository;

import com.example.webmovie.Model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface GenreRepository extends JpaRepository<Genre, Long> {
    Optional<Genre> findByName(String name);

    List<Genre> findAllById(Long id);

    boolean existsByName(String name);


}
