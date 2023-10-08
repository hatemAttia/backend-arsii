package com.example.backendarsii.controller.adminController;

import com.example.backendarsii.dto.requestDto.CompetenceRequest;
import com.example.backendarsii.dto.requestDto.MediaRequest;
import com.example.backendarsii.dto.responseDto.CompetenceResponse;
import com.example.backendarsii.dto.responseDto.MediaResponse;
import com.example.backendarsii.service.MediaService;
import com.example.backendarsii.utils.Constants;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(Constants.APP_ROOT_ADMIN+"/media")
@Api(tags = "(Admin) Media Management ")
@CrossOrigin("*")
public class MediaController {

    private final MediaService mediaService;

    @GetMapping
    public ResponseEntity<List<MediaResponse>> getAllMedia() {
        return ResponseEntity.ok(mediaService.getAllMedia());
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<MediaResponse> getMediaById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(mediaService.getMediaById(id));
    }

    @PostMapping
    public ResponseEntity<String> addMedia(@RequestBody @Valid MediaRequest request) {
        mediaService.addMedia(request);
        return ResponseEntity.ok("save success !");
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<String> deleteMedia(@PathVariable(name = "id") Long id) {
        mediaService.deleteMedia(id);
        return ResponseEntity.ok("delete success !");
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<String> updateMedia(
            @PathVariable(name = "id") Long id,
            @RequestBody @Valid MediaRequest request) {

        mediaService.updateMedia(id, request);
        return ResponseEntity.ok("update success !!!");
    }
}