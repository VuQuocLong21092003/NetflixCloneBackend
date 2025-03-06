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
@Table(name = "genres")
public class Genre extends BaseEntity<Long> {
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "description")
    private String description;


}