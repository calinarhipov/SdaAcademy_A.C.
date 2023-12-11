package com.ProjectFinalArhipovCalin.flyproject.controllers;

import com.ProjectFinalArhipovCalin.flyproject.Service.AuthenticationService;
import com.ProjectFinalArhipovCalin.flyproject.models.authentication.AuthenticationResponse;
import com.ProjectFinalArhipovCalin.flyproject.models.authentication.LoginRequest;
import com.ProjectFinalArhipovCalin.flyproject.models.authentication.RegisterRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin("http://localhost:4200/ ")//pentru ca controlerul sa fie apelata de adresa respectiva
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }
    @PostMapping("/login")// cu post trimit date catre server
    public ResponseEntity<AuthenticationResponse> login(@RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(authenticationService.login(loginRequest));
    }
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest registerRequest) {
        return ResponseEntity.ok(authenticationService.register(registerRequest));
    }
}
