package com.example.webmovie.dto.request;

import com.example.webmovie.untils.Gender;
import com.example.webmovie.untils.Role;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserRequest implements Serializable {

    @NotBlank(message = "email must not blank")
    @Email(message = "email should be valid")
    private String email;

    @NotBlank(message = "password must not blank")
    @Size(min = 6, message = "password should have at least 6 characters")
    private String passwordHash;

    @NotBlank(message = "full name must not blank")
    private String fullName;

    @NotBlank(message = "phone number must not blank")
    @Size(min = 10, message = "phone number should have at least 10 characters")
    private String phoneNumber;

    @NotNull(message = "date of birth must not blank")
    private LocalDate dateOfBirth;

    @NotNull(message ="gender cannot be null")
    private Gender gender;

    @NotNull(message = "is email verified cannot be null")
    private boolean isEmailVerified;

    @NotNull(message = "role cannot be null")
    private Role role;

}
