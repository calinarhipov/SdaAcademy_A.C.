package com.ProjectFinalArhipovCalin.flyproject.models.authentication;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//pt seteri //pentru geteri
@AllArgsConstructor
@Data
@NoArgsConstructor
public class LoginRequest {

    private String email;
    private String password;
}
