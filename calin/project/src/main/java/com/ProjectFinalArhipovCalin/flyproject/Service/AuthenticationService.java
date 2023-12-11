package com.ProjectFinalArhipovCalin.flyproject.Service;

import com.ProjectFinalArhipovCalin.flyproject.models.authentication.AuthenticationResponse;
import com.ProjectFinalArhipovCalin.flyproject.models.authentication.LoginRequest;
import com.ProjectFinalArhipovCalin.flyproject.models.authentication.RegisterRequest;

public interface AuthenticationService {
    AuthenticationResponse login(LoginRequest loginRequest);

    AuthenticationResponse register(RegisterRequest registerRequest);
}
