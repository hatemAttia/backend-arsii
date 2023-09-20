package com.example.backendarsii.controller.adminController;

import com.example.backendarsii.dto.requestDto.FormationRequest;
import com.example.backendarsii.dto.requestDto.UpdateFormationRequest;
import com.example.backendarsii.dto.responseDto.FormationResponse;
import com.example.backendarsii.service.FormationService;
import com.example.backendarsii.utils.Constants;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(Constants.APP_ROOT_ADMIN + "/formation")
@Api(tags = "(Admin) formation Management ")
@CrossOrigin("*")
public class FormationAdminController {

    private final FormationService formationService;

    @PostMapping
    public ResponseEntity<String> createFormation(@RequestBody @Valid FormationRequest formationRequest) {
        formationService.addFormation(formationRequest, true);
        return ResponseEntity.ok("save success !!");
    }

    @GetMapping
    public ResponseEntity<List<FormationResponse>> getAllFormation() {
        return ResponseEntity.ok(formationService.getAllFormation());
    }

    @GetMapping(value = "/suggest")
    public ResponseEntity<List<FormationResponse>> getAllSuggestFormation() {
        return ResponseEntity.ok(formationService.getAllSuggestFormation());
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<FormationResponse> getFormationById(@PathVariable Long id) {
        return ResponseEntity.ok(formationService.getFormationById(id));
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<String> updateFormation(@PathVariable Long id,
                                                  @RequestBody @Valid UpdateFormationRequest updateFormation) {

        formationService.updateFormation(id, updateFormation);
        return ResponseEntity.ok("update success");
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<String> deleteFormation(@PathVariable Long id) {

        formationService.deleteFormation(id);
        return ResponseEntity.ok("delete success");
    }
    @PostMapping(value = "uploadImage/{formationId}")
    public ResponseEntity<String> storeImage(@PathParam("file") MultipartFile file, @PathVariable Long formationId){
        formationService.uploadImage(file,formationId);
        return ResponseEntity.ok("upload success");
    }

    @GetMapping("img/{filename:.+}")
    public ResponseEntity<Resource> serveImage(@PathVariable String filename) {


        Resource resource = formationService.serveImage(filename);
        return   ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, "image/jpeg")
                .body(resource);
    }
}
