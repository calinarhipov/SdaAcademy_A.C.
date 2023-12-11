package com.ProjectFinalArhipovCalin.flyproject.Service;
import com.ProjectFinalArhipovCalin.flyproject.models.entities.User;
import com.ProjectFinalArhipovCalin.flyproject.models.authentication.AuthenticationResponse;
import com.ProjectFinalArhipovCalin.flyproject.models.authentication.LoginRequest;
import com.ProjectFinalArhipovCalin.flyproject.models.authentication.RegisterRequest;
import com.ProjectFinalArhipovCalin.flyproject.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthenticationResponse login(LoginRequest loginRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
        );
        var user = usersRepository.findByEmail(loginRequest.getEmail()).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        var jwtToken = jwtService.generateToken(user);

        AuthenticationResponse authenticationResponse = new AuthenticationResponse();
        authenticationResponse.setToken(jwtToken);
        return authenticationResponse;
    }

    @Override
    public AuthenticationResponse register(RegisterRequest registerRequest) {
//           User user = new User();
//        user.setFirstName(registerRequest.getFirstName());
//        user.setLastName(registerRequest.getLastName());
//        user.setEmail(registerRequest.getEmail());
//        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));

        var user = User
                .builder()
                .lastName(registerRequest.getLastName())
                .firstName(registerRequest.getFirstName())
                .email(registerRequest.getEmail())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .build();

        usersRepository.save(user);

        var jwtToken = jwtService.generateToken(user);

        AuthenticationResponse authenticationResponse = new AuthenticationResponse();
        authenticationResponse.setToken(jwtToken);
        return authenticationResponse;
    }
}
