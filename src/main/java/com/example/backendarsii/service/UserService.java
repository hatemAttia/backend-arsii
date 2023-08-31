package com.example.backendarsii.service;

import com.example.backendarsii.dto.requestDto.RegisterRequest;
import com.example.backendarsii.dto.searchRequest.SearchAdmin;
import com.example.backendarsii.dto.searchRequest.SearchMember;
import com.example.backendarsii.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> getAllMember();
    UserDto getMemberById(Long id);
    void updateMember(Long id, RegisterRequest request);
    UserDto getConnectedUser();
    void deleteMember(Long id);
    void enableMember(Long id);
    List<UserDto> getMemberByFilter(SearchMember serachUserDTO);
    List<UserDto> getAllUserByFilter(SearchAdmin searchAdmin);
}
