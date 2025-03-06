package com.example.webmovie.dto.response;

import lombok.*;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse implements Serializable {
    Long id;
    private String fullName;
}
