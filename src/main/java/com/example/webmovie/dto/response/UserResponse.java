package com.example.webmovie.dto.response;

import com.example.webmovie.untils.Gender;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@Builder
public class UserResponse implements Serializable {
    Long id;
    private String fullName;
    private LocalDate dateOfBirth;
    private Gender gender;

}
