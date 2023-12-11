package com.ProjectFinalArhipovCalin.flyproject.models;
//sunt modele care ne ajuta sa comunicam cu controller, user
//mdelele sunt niste intermediare intre controller si entitatea noatra

import com.ProjectFinalArhipovCalin.flyproject.models.entities.Fly;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserResponse {

    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private List<Fly> flights;

}
