package com.example.backendarsii.controller.memberController;

import com.example.backendarsii.dto.requestDto.OpportunityRequest;
import com.example.backendarsii.dto.responseDto.OpportunityResponse;
import com.example.backendarsii.service.OpportunityService;
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
@RequestMapping(Constants.APP_ROOT_MEMBER + "/opportunity")
@Api(tags = "(Member) Opportunity Management ")
@CrossOrigin("*")
public class OpportunityMemberController {

    private final OpportunityService opportunityService;


    @GetMapping
    public ResponseEntity<List<OpportunityResponse>> getAllOpportunity (){
        return ResponseEntity.ok(opportunityService.getAllOpportunity());
    }
    @GetMapping(value = "{id}")
    public ResponseEntity<OpportunityResponse> getOpportunityById (@PathVariable Long id){

        return ResponseEntity.ok(opportunityService.getOpportunityById(id));
    }



}
