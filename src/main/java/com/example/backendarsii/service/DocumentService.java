package com.example.backendarsii.service;

import com.example.backendarsii.dto.requestDto.DocumentRequest;
import com.example.backendarsii.dto.responseDto.DocumentResponse;

import java.util.List;
public interface DocumentService {
    void createDocument(DocumentRequest documentRequest);

    void deleteDocument(Integer id);

    List<DocumentResponse> getAllDocument();

    DocumentResponse updateDocument(Integer id, DocumentRequest documentRequest);
}
