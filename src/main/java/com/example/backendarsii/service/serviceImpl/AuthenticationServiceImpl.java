package com.example.backendarsii.service.serviceImpl;

import com.example.backendarsii.dto.AuthenticationRequest;
import com.example.backendarsii.dto.AuthenticationResponse;
import com.example.backendarsii.dto.RegisterRequest;
import com.example.backendarsii.dto.enumData.Post;
import com.example.backendarsii.dto.enumData.Role;
import com.example.backendarsii.entity.User;
import com.example.backendarsii.repository.UserRepository;
import com.example.backendarsii.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    @Override
    public AuthenticationResponse register(RegisterRequest request) {

        if (userRepository.findByEmail(request.getEmail()).isPresent()|| userRepository.findByUserName(request.getUserName()).isPresent()){
            throw new RuntimeException("this email or userName is already exist");
        }

        var user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .userName(request.getUserName())
                .email(request.getEmail())
                .gender(request.getGender())
                .phoneNumber(request.getPhoneNumber())
                .region(request.getRegion())
                .job(request.getJob())
                .universityOrCompany(request.getUniversityOrCompany())
                .password(passwordEncoder.encode(request.getPassword()))
                .deleted(false)
                .role( Role.MEMBER)
                .post(Post.MEMBER)
                .office(request.getOffice())
                .build();
        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUserName(),
                        request.getPassword()
                )
        );
        var user = userRepository.findByUserName(request.getUserName())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
