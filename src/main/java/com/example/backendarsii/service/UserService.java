package com.example.backendarsii.service;

import com.example.backendarsii.dto.requestDto.PasswordChangeRequest;
import com.example.backendarsii.dto.requestDto.UpdateMemberRequest;
import com.example.backendarsii.dto.requestDto.UpdateUserRequest;
import com.example.backendarsii.dto.searchRequest.SearchAdmin;
import com.example.backendarsii.dto.searchRequest.SearchMember;
import com.example.backendarsii.dto.responseDto.UserDto;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserService {
    List<UserDto> getAllMember();
    UserDto getMemberById(Long id);
    void updateMember(Long id, UpdateMemberRequest request);
    void updateUser(Long id, UpdateUserRequest request);

    UserDto getConnectedUser();
    void deleteMember(Long id);
    void enableMember(Long id);
    List<UserDto> getMemberByFilter(SearchMember serachUserDTO);
    List<UserDto> getAllUserByFilter(SearchAdmin searchAdmin);
    void changePassword(PasswordChangeRequest passwordChangeRequest,Long id);
}
