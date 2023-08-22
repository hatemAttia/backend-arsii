package com.example.backendarsii.controller;

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






}
