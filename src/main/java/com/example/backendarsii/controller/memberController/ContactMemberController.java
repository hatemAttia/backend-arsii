package com.example.backendarsii.controller.memberController;

import com.example.backendarsii.dto.requestDto.ContactRequest;
import com.example.backendarsii.dto.responseDto.ContactResponse;
import com.example.backendarsii.service.ContactService;
import com.example.backendarsii.utils.Constants;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(Constants.APP_ROOT_MEMBER + "/contact")
@Api(tags = "(Member) Contact Management ")
@CrossOrigin("*")
public class ContactMemberController {

    private final ContactService contactService;

    @PostMapping
    public ResponseEntity<String> addContact (@RequestBody @Valid ContactRequest request){

        contactService.addContact(request);
        return ResponseEntity.ok("save success !!");
    }
    @PutMapping(value = "{id}")
    public ResponseEntity<String> updateContact (@PathVariable Long id,@RequestBody ContactRequest request){

        contactService.updateContact(id,request);
        return ResponseEntity.ok("update success !!");

    }
    @GetMapping("{userId}")
    public ResponseEntity<List<ContactResponse>> getAllContactByUser (@PathVariable Long userId){

        return ResponseEntity.ok(contactService.getAllContactByUser(userId));

    }
    @DeleteMapping(value = "{id}")
    public ResponseEntity<String> deleteContact (@PathVariable Long id){

        contactService.deleteContact(id);
        return ResponseEntity.ok("delete success !!");
    }

}
