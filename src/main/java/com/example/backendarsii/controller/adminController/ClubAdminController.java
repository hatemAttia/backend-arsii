package com.example.backendarsii.controller.adminController;


import com.example.backendarsii.dto.requestDto.ClubRequest;
import com.example.backendarsii.dto.responseDto.ClubResponse;
import com.example.backendarsii.service.ClubService;
import com.example.backendarsii.utils.Constants;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Collections;
import java.util.List;

@RestController
@Transactional
@RequestMapping(Constants.APP_ROOT_ADMIN + "/club")
@Api(tags = "(Admin) Club Management")
@CrossOrigin("*")
public class ClubAdminController {
    private final ClubService clubService;

    public ClubAdminController(ClubService clubService) {
        this.clubService = clubService;
    }
    @PostMapping
    public ResponseEntity<Object> createClub(@RequestBody @Valid ClubRequest clubRequest)
    {
        if (clubRequest != null) {
            clubService.createClub(clubRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body(
                    Collections.singletonMap("message", "club created successfully"));

        } else {
            return ResponseEntity.badRequest().body("Invalid club data");
        }}
    @GetMapping("")
    public ResponseEntity<List<ClubResponse>> getAllClub() {
        List<ClubResponse> clubs = clubService.getAllClub();
        return ResponseEntity.ok(clubs);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteClub(@PathVariable Integer id) {
        clubService.deleteClub(id);
        //return ResponseEntity.noContent().build();
        return ResponseEntity.status(HttpStatus.CREATED).body(
                Collections.singletonMap("message", "Delete successfully"));
    }
    @PutMapping("/{id}")
    public ResponseEntity<ClubResponse> updateClub(@PathVariable Integer id, @RequestBody ClubRequest clubRequest) {
        ClubResponse updatedClub = clubService.updateClub(id, clubRequest);
        return ResponseEntity.ok(updatedClub);
    }
    @GetMapping("/{clubId}")
    public ResponseEntity<ClubResponse> getClubById(@PathVariable Integer clubId) {
        ClubResponse club = clubService.getClubById(clubId);
        return ResponseEntity.ok(club);
    }
}
