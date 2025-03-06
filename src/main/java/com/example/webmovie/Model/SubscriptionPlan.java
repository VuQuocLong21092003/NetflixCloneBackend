package com.example.webmovie.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "subscription_plans")
public class SubscriptionPlan extends BaseEntity<Long> {
    @Column(name = "plan_name", nullable = false)
    private String planName;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "duration_in_days", nullable = false)
    private Integer durationInDays;

    @Column(name = "description")
    private String description;
}