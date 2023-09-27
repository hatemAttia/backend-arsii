package com.example.backendarsii.controller.adminController;


import com.example.backendarsii.dto.requestDto.DocumentRequest;
import com.example.backendarsii.dto.responseDto.DocumentResponse;
import com.example.backendarsii.service.DocumentService;
import com.example.backendarsii.utils.Constants;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RequiredArgsConstructor
@RestController
@RequestMapping(Constants.APP_ROOT_ADMIN + "/document")
@Api(tags = "(Admin) Document Management")
@CrossOrigin("*")
public class DocumentController {

    private final DocumentService documentService;

    @PostMapping
    public ResponseEntity<String> createDocument(@RequestBody @Valid DocumentRequest documentRequest) {
        if (documentRequest != null) {
            documentService.createDocument(documentRequest);
            return ResponseEntity.ok("Document created successfully");
        } else {
            return ResponseEntity.badRequest().body("Invalid Document data");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteDocument(@PathVariable Integer id) {
        documentService.deleteDocument(id);
        return ResponseEntity.ok("Delete successfully");
    }

    @GetMapping("/alldocument")
    public ResponseEntity<List<DocumentResponse>> getAllDocument() {
        List<DocumentResponse> documents = documentService.getAllDocument();
        return ResponseEntity.ok(documents);
    }
      @PutMapping("/update/{id}")
    public ResponseEntity<DocumentResponse> updateDocument(@PathVariable Integer id, @RequestBody DocumentRequest documentRequest) {
          DocumentResponse updatedDocument = documentService.updateDocument(id, documentRequest);
        return ResponseEntity.ok(updatedDocument);
    }
}
