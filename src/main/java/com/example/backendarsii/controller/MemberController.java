package com.example.backendarsii.controller;

import com.example.backendarsii.dto.requestDto.RegisterRequest;
import com.example.backendarsii.dto.searchRequest.SearchMember;
import com.example.backendarsii.dto.UserDto;
import com.example.backendarsii.service.UserService;
import com.example.backendarsii.utils.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(Constants.APP_ROOT+"/member")
public class MemberController {


    public final UserService userService;

    @GetMapping(value = "/allMember")
    public ResponseEntity<List<UserDto>> getAllMember(){
        return ResponseEntity.ok(userService.getAllMember());
    }

    @GetMapping(value = "/getMember/{id}")
    public ResponseEntity<UserDto> getMemberById(@PathVariable(name = "id")Long id){
        return ResponseEntity.ok(userService.getMemberById(id));
    }
    @GetMapping(value = "userConnected")
    public ResponseEntity<UserDto> getUserConnected(){
        return ResponseEntity.ok(userService.getConnectedUser());
    }

    @GetMapping(value = "/filter")
    public ResponseEntity<List<UserDto>> getAllMember(@RequestBody SearchMember request){
        return ResponseEntity.ok(userService.getMemberByFilter(request));
    }
    @PutMapping(value = "/update/{id}")
    public ResponseEntity<String> updateMember(@PathVariable(name = "id") Long id ,@RequestBody RegisterRequest request){
        userService.updateMember(id,request);
        return ResponseEntity.ok("update success!!");
    }







}
