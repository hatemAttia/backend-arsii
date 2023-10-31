package com.example.backendarsii.controller.memberController;

import com.example.backendarsii.dto.responseDto.ClubResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


import com.example.backendarsii.service.ClubService;
import com.example.backendarsii.utils.Constants;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
@Transactional
@RequestMapping(Constants.APP_ROOT_MEMBER + "/club")
@Api(tags = "(Admin) Club Management")
@CrossOrigin("*")
public class ClubMembreontroller {
    private final ClubService clubService;

    public ClubMembreontroller(ClubService clubService) {
        this.clubService = clubService;
    }

    @GetMapping("")
    public ResponseEntity<List<ClubResponse>> getAllClub() {
        List<ClubResponse> clubs = clubService.getAllClub();
        return ResponseEntity.ok(clubs);
    }
}
