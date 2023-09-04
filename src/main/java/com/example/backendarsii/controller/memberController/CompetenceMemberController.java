package com.example.backendarsii.controller.memberController;

import com.example.backendarsii.dto.responseDto.CompetenceResponse;
import com.example.backendarsii.service.CompetenceService;
import com.example.backendarsii.utils.Constants;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(Constants.APP_ROOT_MEMBER+"/competence")
@Api(tags = "(Member) Competence Management  ")
public class CompetenceMemberController {

    private final CompetenceService competenceService;

    @GetMapping
    public ResponseEntity<List<CompetenceResponse>> getAllCompetence() {
        return ResponseEntity.ok(competenceService.getAllCompetence());
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<CompetenceResponse> getCompetenceById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(competenceService.getCompetenceById(id));
    }

}
