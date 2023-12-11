package com.ProjectFinalArhipovCalin.flyproject.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FlyResponse {

    private Integer id;

    private String departure;

    private String landing;

    private LocalDateTime dateOfDeparture;

    private LocalDateTime returnDate;

    private Integer passengers;
}