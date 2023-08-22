package com.example.backendarsii.service;

import com.example.backendarsii.dto.RegisterRequest;
import com.example.backendarsii.dto.UserDto;
import com.example.backendarsii.entity.User;

import java.util.List;

public interface UserService {
    List<UserDto> getAllMember();
    UserDto getMemberById(Long id);
    void updateMember(Long id, RegisterRequest request);
    UserDto getConnectedUser();
    void deleteMember(Long id);
    void enableMember(Long id);
}
