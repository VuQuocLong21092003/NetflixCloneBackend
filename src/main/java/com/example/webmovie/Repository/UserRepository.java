package com.example.webmovie.Repository;

import com.example.webmovie.Model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByFullName(String fullName);

    boolean existsByFullName(String fullName);

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);

    Page<User> findUsersByFullNameContaining(String fullName, Pageable pageable);

}
