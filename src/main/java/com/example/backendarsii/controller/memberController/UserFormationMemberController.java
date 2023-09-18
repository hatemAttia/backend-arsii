package com.example.backendarsii.controller.memberController;

import com.example.backendarsii.dto.requestDto.UserFormationRequest;
import com.example.backendarsii.dto.responseDto.FormationUserResponse;
import com.example.backendarsii.dto.responseDto.UserFormationResponse;
import com.example.backendarsii.service.UserFormationService;
import com.example.backendarsii.utils.Constants;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(Constants.APP_ROOT_MEMBER + "/userFormation")
@Api(tags = "(Member) User's Formation management ")
@CrossOrigin("*")
public class UserFormationMemberController {

    private final UserFormationService userFormationService;

    @PostMapping
    public ResponseEntity<String> joinFormation(@RequestBody @Valid UserFormationRequest request) {
        userFormationService.joinFormation(request);
        return ResponseEntity.ok("join success !!!");
    }

    @GetMapping(value = "/users/{FormationId}")
    public ResponseEntity<List<UserFormationResponse>> getListOfUserByFormation(@PathVariable Long FormationId) {
        return ResponseEntity.ok(userFormationService.getListOfUserByFormation(FormationId));
    }

    @GetMapping(value = "/formations/{userId}")
    public ResponseEntity<List<FormationUserResponse>> getListOfFormationByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(userFormationService.getListOfFormationByUser(userId));
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<String> deleteUserFormation(@PathVariable Long id) {
        userFormationService.deleteUserFormation(id);
        return ResponseEntity.ok("delete success !!!");
    }

}