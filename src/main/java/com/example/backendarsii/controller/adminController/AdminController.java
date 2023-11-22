package com.example.backendarsii.controller.adminController;

import com.example.backendarsii.dto.requestDto.PasswordChangeRequest;
import com.example.backendarsii.dto.requestDto.UpdateUserRequest;
import com.example.backendarsii.dto.responseDto.UserResponse;
import com.example.backendarsii.dto.searchRequest.SearchAdmin;
import com.example.backendarsii.exception.ExpiredTokenException;
import com.example.backendarsii.service.UserService;
import com.example.backendarsii.utils.FileStorageService;
import com.example.backendarsii.utils.Constants;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping(Constants.APP_ROOT_ADMIN)
@Api(tags = "(Admin) User Management ")
@CrossOrigin("*")
public class AdminController {

    public final UserService userService;

    private final FileStorageService fileStorageService;


    @PostMapping(value = "/filter")
    public ResponseEntity<Page<UserResponse>> getAllUserByFilter(@RequestBody SearchAdmin request,
                                                                 Pageable pageable) {
        Page<UserResponse> usersPage = userService.getAllUserByFilter(request, pageable);

        return ResponseEntity.ok(usersPage);
    }

    @PutMapping(value = "/enable/{id}")
    public ResponseEntity<Object> enableMember(@PathVariable(name = "id") UUID id) {
        userService.enableMember(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                Collections.singletonMap("message", "This Account enabled with success !!!!!"));
    }


    @DeleteMapping(value = "{id}")
    public ResponseEntity<Object> deleteMember(@PathVariable(name = "id") UUID id) {
        userService.deleteMember(id);

        return ResponseEntity.status(HttpStatus.CREATED).body(
                Collections.singletonMap("message", "this Account is deleted"));
    }

    @GetMapping(value = "me")
    public ResponseEntity<Object> getUserConnected() {
        try {
            return ResponseEntity.ok(userService.getConnectedUser());
        } catch (ExpiredTokenException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Token has expired");
        } catch (Exception e) {
            // Handle other exceptions
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
        }
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<Object> updateUser(@PathVariable(name = "id") UUID id, @RequestBody UpdateUserRequest request) {
        userService.updateUser(id, request);

        return ResponseEntity.status(HttpStatus.CREATED).body(
                Collections.singletonMap("message", "update success!!"));
    }

    @PutMapping
    public ResponseEntity<Object> updateMe(@RequestBody UpdateUserRequest request) {
        UserResponse user = userService.getConnectedUser();
        userService.updateUser(user.getId(), request);

        return ResponseEntity.status(HttpStatus.CREATED).body(
                Collections.singletonMap("message", "update success!!"));
    }

    @PutMapping(value = "/password")
    public ResponseEntity<Object> changeMyPassword(@RequestBody PasswordChangeRequest request) {
        UserResponse user = userService.getConnectedUser();
        userService.changePassword(request, user.getId());

        return ResponseEntity.status(HttpStatus.CREATED).body(
                Collections.singletonMap("message", "Password changed successfully !!"));

    }

    @PutMapping(value = "/password/{id}")
    public ResponseEntity<Object> changeUserPassword(@RequestBody PasswordChangeRequest request,
                                                     @PathVariable UUID id) {

        userService.changePassword(request, id);

        return ResponseEntity.status(HttpStatus.CREATED).body(
                Collections.singletonMap("message", "Password changed successfully !!"));
    }


}
