package com.ProjectFinalArhipovCalin.flyproject.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FlyRequest {

    //@Column(name = "departure", columnDefinition = "TEXT", updatable = true, nullable = false)
    private String departure;

  //  @Column(name = "landing", columnDefinition = "TEXT", updatable = true, nullable = false)
    private String landing;

  //  @Column(name = "dateOfDeparture", columnDefinition = "TEXT", updatable = true, nullable = false)
    private LocalDateTime dateOfDeparture;

   // @Column(name = "returnDate", columnDefinition = "TEXT", updatable = true, nullable = false)
    private LocalDateTime returnDate;

  //  @Column(name = "passengers", columnDefinition = "TEXT", updatable = true, nullable = false)
    private Integer passengers;


}
