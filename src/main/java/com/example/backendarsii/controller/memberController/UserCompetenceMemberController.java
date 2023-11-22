package com.example.backendarsii.controller.memberController;

import com.example.backendarsii.dto.requestDto.UserCompetenceRequest;
import com.example.backendarsii.dto.responseDto.UserCompetenceResponse;
import com.example.backendarsii.dto.responseDto.UserResponse;
import com.example.backendarsii.service.UserCompetenceService;
import com.example.backendarsii.service.UserService;
import com.example.backendarsii.utils.Constants;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping(Constants.APP_ROOT_MEMBER + "/userCompetence")
@Api(tags = "(Member) User's Competence Management ")
@CrossOrigin("*")
public class UserCompetenceMemberController {

    private final UserCompetenceService userCompetenceService;
    private final UserService userService;

    @PostMapping()
    public ResponseEntity<Object> addUserCompetence(@RequestBody @Valid UserCompetenceRequest request) {
        userCompetenceService.addUserCompetence(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(
                Collections.singletonMap("message", "save success !!"));
    }

    @GetMapping(value = "users/{id}")
    public ResponseEntity<List<UserResponse>> getAllUserByCompetence(@PathVariable Long id) {
        return ResponseEntity.ok(userCompetenceService.getAllUserByCompetence(id));
    }

    @GetMapping(value = "competences")
    public ResponseEntity<List<UserCompetenceResponse>> getAllCompetencesByMe() {
        UserResponse userDto = userService.getConnectedUser();
        return ResponseEntity.ok(userCompetenceService.getAllCompetenceByUser(userDto.getId()));
    }

    @GetMapping(value = "competences/{id}")
    public ResponseEntity<List<UserCompetenceResponse>> getAllCompetencesByUser(@PathVariable UUID id) {

        return ResponseEntity.ok(userCompetenceService.getAllCompetenceByUser(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<Object> updateUserCompetence(
            @PathVariable Long id,
            @RequestBody @Valid UserCompetenceRequest request
    ) {
        userCompetenceService.updateUserCompetence(id, request);

        return ResponseEntity.status(HttpStatus.CREATED).body(
                Collections.singletonMap("message", "update success !!"));
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Object> deleteUserCompetence(@PathVariable Long id) {
        userCompetenceService.deleteUserCompetence(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                Collections.singletonMap("message", "delete success !!!"));
    }


}
