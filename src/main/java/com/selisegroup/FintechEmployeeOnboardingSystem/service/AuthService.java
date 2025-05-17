package com.selisegroup.FintechEmployeeOnboardingSystem.service;

import com.selisegroup.FintechEmployeeOnboardingSystem.dto.AuthRequest;
import com.selisegroup.FintechEmployeeOnboardingSystem.dto.AuthResponse;
import com.selisegroup.FintechEmployeeOnboardingSystem.model.User;
import com.selisegroup.FintechEmployeeOnboardingSystem.repository.UserRepository;
import com.selisegroup.FintechEmployeeOnboardingSystem.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    // These will be automatically injected by Spring
    // thanks to @RequiredArgsConstructor
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;

    public AuthResponse authenticate(AuthRequest authRequest) {
        // Authenticate the user credentials
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authRequest.getUsername(),
                        authRequest.getPassword()
                )
        );

        // Find the user in database
        User user = userRepository.findByUsername(authRequest.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found with username: " + authRequest.getUsername()));

        // Generate JWT token
        String token = jwtTokenProvider.generateToken(authentication);

        // Return the authentication response
        return new AuthResponse(
                token,
                user.getUsername(),
                user.getRole().name()
        );
    }
}