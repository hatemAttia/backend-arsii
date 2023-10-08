package com.example.backendarsii.controller.adminController;

import com.example.backendarsii.config.UtilsConfiguration;
import com.example.backendarsii.dto.requestDto.PasswordChangeRequest;
import com.example.backendarsii.dto.requestDto.UpdateUserRequest;
import com.example.backendarsii.dto.responseDto.UploadFileDetails;
import com.example.backendarsii.dto.responseDto.UserResponse;
import com.example.backendarsii.dto.searchRequest.SearchAdmin;
import com.example.backendarsii.service.UserService;
import com.example.backendarsii.utils.FileStorageService;
import com.example.backendarsii.utils.Constants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.websocket.server.PathParam;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

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
    public ResponseEntity<Object> enableMember(@PathVariable(name = "id") Long id) {
        userService.enableMember(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                Collections.singletonMap("message", "This Account enabled with success !!!!!"));
    }


    @DeleteMapping(value = "{id}")
    public ResponseEntity<Object> deleteMember(@PathVariable(name = "id") Long id) {
        userService.deleteMember(id);

        return ResponseEntity.status(HttpStatus.CREATED).body(
                Collections.singletonMap("message", "this Account is deleted"));
    }

    @GetMapping(value = "me")
    public ResponseEntity<UserResponse> getUserConnected() {

        return ResponseEntity.ok(userService.getConnectedUser());
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<Object> updateUser(@PathVariable(name = "id") Long id, @RequestBody UpdateUserRequest request) {
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
                                                     @PathVariable Long id) {

        userService.changePassword(request, id);

        return ResponseEntity.status(HttpStatus.CREATED).body(
                Collections.singletonMap("message", "Password changed successfully !!"));
    }







}
