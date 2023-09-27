package com.example.backendarsii.controller.memberController;

import com.example.backendarsii.dto.requestDto.PasswordChangeRequest;
import com.example.backendarsii.dto.requestDto.UpdateMemberRequest;
import com.example.backendarsii.dto.responseDto.UserResponse;
import com.example.backendarsii.dto.searchRequest.SearchMember;
import com.example.backendarsii.service.UserService;
import com.example.backendarsii.utils.Constants;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.websocket.server.PathParam;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(Constants.APP_ROOT_MEMBER)
@Api(tags = "(Member) User Management ")
@CrossOrigin("*")
public class MemberController {


    public final UserService userService;


    @GetMapping()
    public ResponseEntity<List<UserResponse>> getAllMember() {
        return ResponseEntity.ok(userService.getAllMember());
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<UserResponse> getMemberById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(userService.getMemberById(id));
    }

    @GetMapping(value = "me")
    public ResponseEntity<UserResponse> getMe() {
        return ResponseEntity.ok(userService.getConnectedUser());
    }

    @PostMapping(value = "/filter")
    public ResponseEntity<List<UserResponse>> getAllMember(@RequestBody SearchMember request) {
        return ResponseEntity.ok(userService.getMemberByFilter(request));
    }

    @PutMapping
    public ResponseEntity<String> updateMe(@RequestBody UpdateMemberRequest request) {
        UserResponse user = userService.getConnectedUser();
        userService.updateMember(user.getId(), request);
        return ResponseEntity.ok("update success!!");
    }

    @PutMapping(value = "/password")
    public ResponseEntity<String> changeMyPassword(@RequestBody PasswordChangeRequest request) {
        UserResponse user = userService.getConnectedUser();
        userService.changePassword(request, user.getId());
        return ResponseEntity.ok("Password changed successfully !!");
    }

    @PostMapping(value = "uploadImage/{userId}")
    public ResponseEntity<String> storeImage(@PathParam("file") MultipartFile file,@PathVariable Long userId){
        userService.uploadImage(file,userId);
        return ResponseEntity.ok("upload success");
    }

    @GetMapping("img/{filename:.+}")
    public ResponseEntity<Resource> serveImage(@PathVariable String filename) {


        Resource resource = userService.serveImage(filename);
        return   ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, "image/jpeg") // Modify the content type as needed
                .body(resource);
    }
    @PostMapping(value = "uploadCV/{userId}")
    public ResponseEntity<String> storeCV(@PathParam("file") MultipartFile file,@PathVariable Long userId){
        userService.uploadCv(file,userId);
        return ResponseEntity.ok("upload success");
    }

    @GetMapping("CV/{filename:.+}")
    public ResponseEntity<Resource> serveCV(@PathVariable String filename) {

        Resource resource = userService.serveCv(filename);
        return   ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, "application/pdf") // Modify the content type as needed
                .body(resource);
    }



}
