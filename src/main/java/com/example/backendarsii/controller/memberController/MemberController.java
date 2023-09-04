package com.example.backendarsii.controller.memberController;

import com.example.backendarsii.dto.requestDto.PasswordChangeRequest;
import com.example.backendarsii.dto.requestDto.RegisterRequest;
import com.example.backendarsii.dto.requestDto.UpdateMemberRequest;
import com.example.backendarsii.dto.searchRequest.SearchMember;
import com.example.backendarsii.dto.responseDto.UserDto;
import com.example.backendarsii.service.UserService;
import com.example.backendarsii.utils.Constants;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(Constants.APP_ROOT_MEMBER)
@Api(tags = "(Member) User Management ")
public class MemberController {


    public final UserService userService;


    @GetMapping()
    public ResponseEntity<List<UserDto>> getAllMember(){
        return ResponseEntity.ok(userService.getAllMember());
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<UserDto> getMemberById(@PathVariable(name = "id")Long id){
        return ResponseEntity.ok(userService.getMemberById(id));
    }
    @GetMapping(value = "me")
    public ResponseEntity<UserDto> getMe(){
        return ResponseEntity.ok(userService.getConnectedUser());
    }

    @PostMapping(value = "/filter")
    public ResponseEntity<List<UserDto>> getAllMember(@RequestBody SearchMember request){
        return ResponseEntity.ok(userService.getMemberByFilter(request));
    }
    @PutMapping
    public ResponseEntity<String> updateMe(@RequestBody UpdateMemberRequest request){
        UserDto user = userService.getConnectedUser();
        userService.updateMember(user.getId(),request);
        return ResponseEntity.ok("update success!!");
    }

    @PutMapping(value = "/password")
    public ResponseEntity<String> changeMyPassword(@RequestBody PasswordChangeRequest request){
        UserDto user = userService.getConnectedUser();
        userService.changePassword(request,user.getId());
        return ResponseEntity.ok("Password changed successfully !!");
    }







}
