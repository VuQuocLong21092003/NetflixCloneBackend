package com.example.webmovie.Model;


import com.example.webmovie.untils.Gender;
import com.example.webmovie.untils.Role;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User  extends BaseEntity<Long> {


    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password_hash", nullable = false)
    private String passwordHash;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;

    @Column(name = "is_email_verified", nullable = false)
    private boolean isEmailVerified;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private Role role;




}
