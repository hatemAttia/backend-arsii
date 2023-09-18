package com.example.backendarsii.service;

import com.example.backendarsii.dto.requestDto.AuthenticationRequest;
import com.example.backendarsii.dto.requestDto.RegisterRequest;
import com.example.backendarsii.dto.responseDto.AuthenticationResponse;

public interface AuthenticationService {
    AuthenticationResponse register(RegisterRequest request);

    AuthenticationResponse authenticate(AuthenticationRequest request);
}
