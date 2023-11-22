package com.example.backendarsii.service;

import com.example.backendarsii.dto.requestDto.ContactRequest;
import com.example.backendarsii.dto.responseDto.ContactResponse;

import java.util.List;
import java.util.UUID;

public interface ContactService {

    void addContact (ContactRequest request);
    void updateContact(Long id , ContactRequest request);
    List<ContactResponse> getAllContactByUser(UUID userId);
    void deleteContact(Long id);

}
