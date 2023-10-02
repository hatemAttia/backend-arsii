package com.example.backendarsii.service;

import com.example.backendarsii.dto.requestDto.PasswordChangeRequest;
import com.example.backendarsii.dto.requestDto.UpdateMemberRequest;
import com.example.backendarsii.dto.requestDto.UpdateUserRequest;
import com.example.backendarsii.dto.responseDto.UserResponse;
import com.example.backendarsii.dto.searchRequest.SearchAdmin;
import com.example.backendarsii.dto.searchRequest.SearchMember;
import com.example.backendarsii.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;

import javax.transaction.Transactional;
import java.util.List;

public interface UserService {
    List<UserResponse> getAllMember();

    UserResponse getMemberById(Long id);

    void updateMember(Long id, UpdateMemberRequest request);

    void updateUser(Long id, UpdateUserRequest request);

    UserResponse getConnectedUser();

    void deleteMember(Long id);

    void enableMember(Long id);





    Page<UserResponse> getAllUserByFilter(SearchAdmin searchAdmin, Pageable pageable);

    void changePassword(PasswordChangeRequest passwordChangeRequest, Long id);

     void forgotPassword(String username) ;


     void resetPasswordWithOTP(String username, String otp, String newPassword) ;




}
