package com.example.backendarsii.service.serviceImpl;


import com.example.backendarsii.dto.requestDto.DocumentRequest;
import com.example.backendarsii.dto.responseDto.DocumentResponse;
import com.example.backendarsii.entity.Document;
import com.example.backendarsii.exception.NotFoundException;
import com.example.backendarsii.repository.DocumentRepository;
import com.example.backendarsii.service.DocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
//@Transactional
public class DocumentServiceImpl implements DocumentService {

    private final DocumentRepository documentRepository;

    @Override
    public void createDocument(DocumentRequest documentRequest) {
        Document document = Document.builder()
                .title(documentRequest.getTitle())
                .description(documentRequest.getDescription())
                .image(documentRequest.getImage())
                .URLDocument(documentRequest.getURLDocument())
                .typedoc(documentRequest.getTypedoc())
                .build();
        documentRepository.save(document);
    }
    @Override
    public void deleteDocument(Integer id) {
        documentRepository.deleteById(id);
    }
    @Override
    public List<DocumentResponse> getAllDocument() {
        List<Document> documents = documentRepository.findAllDocument();
        List<DocumentResponse> documentResponses = new ArrayList<>();
        for(Document document : documents) {
            DocumentResponse documentDto = DocumentResponse.makeDocument(document);
            documentResponses.add(documentDto);
        }
        return documentResponses;
    }
    @Override
    public DocumentResponse updateDocument(Integer id, DocumentRequest documentRequest) {
        Optional<Document> optionalDocument = documentRepository.findById(id);
        if (optionalDocument.isPresent()) {
            Document existingDocument = optionalDocument.get();
            existingDocument.setTitle(documentRequest.getTitle());
            existingDocument.setDescription(documentRequest.getDescription());
            existingDocument.setImage(documentRequest.getImage());
            existingDocument.setURLDocument(documentRequest.getURLDocument());
            existingDocument.setTypedoc(documentRequest.getTypedoc());
            documentRepository.save(existingDocument);
            return DocumentResponse.makeDocument(existingDocument);
        } else {
            throw new NotFoundException("Document with ID : " + id);
        }
    }
    }

