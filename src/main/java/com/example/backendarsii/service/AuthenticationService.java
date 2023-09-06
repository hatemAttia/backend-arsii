package com.example.backendarsii.service;

import com.example.backendarsii.dto.AuthenticationRequest;
import com.example.backendarsii.dto.AuthenticationResponse;
import com.example.backendarsii.dto.RegisterRequest;

public interface AuthenticationService {
    AuthenticationResponse register(RegisterRequest request);
    AuthenticationResponse authenticate(AuthenticationRequest request);
}