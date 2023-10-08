package com.example.backendarsii.service.serviceImpl;

import com.example.backendarsii.dto.requestDto.ContactRequest;
import com.example.backendarsii.dto.responseDto.ContactResponse;
import com.example.backendarsii.entity.Contact;
import com.example.backendarsii.entity.User;
import com.example.backendarsii.exception.NotFoundException;
import com.example.backendarsii.repository.ContactRepository;
import com.example.backendarsii.repository.UserRepository;
import com.example.backendarsii.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;
    private final UserRepository userRepository;

    @Override
    public void addContact(ContactRequest request) {

        User user = userRepository.findById(request.getUserId()).orElseThrow(
                ()-> new  NotFoundException(String.format("this userId with id [%s] is not exist",request.getUserId())));

        Contact contact = Contact.builder()
                .platform(request.getPlatform())
                .url(request.getUrl())
                .user(user)
                .build();

        contactRepository.save(contact);
    }

    @Override
    public void updateContact(Long id,ContactRequest request) {

        Contact contact = contactRepository.findById(id).orElseThrow(
                ()->new NotFoundException(String.format("this contact with id [%s] is not exist",id)));

        if (request.getPlatform()!=null){
            contact.setPlatform(request.getPlatform());
        }
        if (request.getUrl()!=null){
            contact.setUrl(contact.getUrl());
        }

        contactRepository.save(contact);



    }

    @Override
    public List<ContactResponse> getAllContactByUser(Long userId) {

        List<Contact> contacts = contactRepository.findAllByUserId(userId);
        List<ContactResponse> contactResponses = new ArrayList<>();
        for (Contact contact: contacts) {
            ContactResponse contactResponse = ContactResponse.makeContact(contact);
            contactResponses.add(contactResponse);
        }
        return contactResponses;
    }

    @Override
    public void deleteContact(Long id) {

        if (!contactRepository.existsById(id)){
            throw new NotFoundException(String.format("this contact with id [%s] is not exist",id));
        }
        contactRepository.deleteById(id);

    }
}
