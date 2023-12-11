package com.ProjectFinalArhipovCalin.flyproject.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity(name = "fly")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@EqualsAndHashCode
public class Fly {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;

    @Column(name = "departure", columnDefinition = "TEXT", updatable = true, nullable = false)
    private String departure;

    @Column(name = "landing", columnDefinition = "TEXT", updatable = true, nullable = false)
    private String landing;

    @Column(name = "dateOfDeparture", columnDefinition = "TEXT", updatable = true, nullable = false)
    private LocalDateTime dateOfDeparture;

    @Column(name = "returnDate", columnDefinition = "TEXT", updatable = true, nullable = false)
    private LocalDateTime returnDate;

    @Column(name = "passengers", columnDefinition = "TEXT", updatable = true, nullable = false)
    private Integer passengers;
}
