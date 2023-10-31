package com.example.backendarsii.controller.memberController;

import com.example.backendarsii.dto.requestDto.CompetenceRequest;
import com.example.backendarsii.dto.requestDto.MediaRequest;
import com.example.backendarsii.dto.responseDto.CompetenceResponse;
import com.example.backendarsii.dto.responseDto.MediaResponse;
import com.example.backendarsii.service.MediaService;
import com.example.backendarsii.utils.Constants;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(Constants.APP_ROOT_MEMBER+"/media")
@Api(tags = "(Admin) Media Management ")
@CrossOrigin("*")
public class MediaMemberController {
    private final MediaService mediaService;

    @GetMapping
    public ResponseEntity<List<MediaResponse>> getAllMedia() {
        return ResponseEntity.ok(mediaService.getAllMedia());
    }

}
