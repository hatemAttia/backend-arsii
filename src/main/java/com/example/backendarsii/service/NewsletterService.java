package com.example.backendarsii.service;

import com.example.backendarsii.dto.requestDto.NewsletterRequest;
import com.example.backendarsii.dto.responseDto.NewsletterResponse;

import java.util.List;

public interface NewsletterService {
    void subscribe(String email);

    List<NewsletterResponse> getAllSubscribers();

    List<String> getAllSubscribersById(Integer id);

    void createNewsletter(NewsletterRequest newsletterRequest);

    void deleteNewsletter(Integer id);
}
