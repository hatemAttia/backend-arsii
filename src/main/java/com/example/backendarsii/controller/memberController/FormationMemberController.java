package com.example.backendarsii.controller.memberController;

import com.example.backendarsii.dto.requestDto.FormationRequest;
import com.example.backendarsii.dto.responseDto.FormationResponse;
import com.example.backendarsii.service.FormationService;
import com.example.backendarsii.utils.Constants;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(Constants.APP_ROOT_MEMBER + "/formation")
@Api(tags = "(Member) formation Management ")
@CrossOrigin("*")
public class FormationMemberController {

    private final FormationService formationService;

    @PostMapping
    public ResponseEntity<String> suggestFormation(@RequestBody @Valid FormationRequest formationRequest) {
        formationService.addFormation(formationRequest, false);
        return ResponseEntity.ok("save success !!");
    }

    @GetMapping
    public ResponseEntity<List<FormationResponse>> getAllFormation() {
        return ResponseEntity.ok(formationService.getAllFormation());
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<FormationResponse> getFormationById(@PathVariable Long id) {
        return ResponseEntity.ok(formationService.getFormationById(id));
    }
}
