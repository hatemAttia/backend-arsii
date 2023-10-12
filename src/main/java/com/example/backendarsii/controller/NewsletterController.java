package com.example.backendarsii.controller;


import com.example.backendarsii.dto.requestDto.CommentRequest;
import com.example.backendarsii.dto.requestDto.NewsletterRequest;
import com.example.backendarsii.dto.responseDto.ClubResponse;
import com.example.backendarsii.dto.responseDto.EventResponse;
import com.example.backendarsii.dto.responseDto.NewsletterResponse;
import com.example.backendarsii.service.NewsletterService;
import com.example.backendarsii.utils.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@Controller
@RestController
@Transactional
@RequiredArgsConstructor
@RequestMapping(Constants.APP_ROOT + "/newsletter")
@CrossOrigin("*")
public class NewsletterController {

    private final NewsletterService newsletterService;

    @PostMapping
    public ResponseEntity<String> createNewsletter(@RequestBody @Valid NewsletterRequest newsletterRequest)
    {
        if (newsletterRequest != null) {
            newsletterService.createNewsletter(newsletterRequest);
            return ResponseEntity.ok("newsletter created successfully");
        } else {
            return ResponseEntity.badRequest().body("Invalid newsletter data");
        }}
     @PostMapping("/subscribe")
    public String subscription(@RequestParam("email") String email){
        newsletterService.subscribe(email);
         return "subscription success";
     }
    @GetMapping("/listofsubscribers")
    public ResponseEntity<List<NewsletterResponse>> listSubscribers() {
        List<NewsletterResponse> subscribers = newsletterService.getAllSubscribers();
        return ResponseEntity.ok(subscribers);
    }


    @GetMapping("/subscribers/{id}")
    public  String listSubscribersById(@PathVariable("id") Integer id, Model model){
         List<String> subscribers = newsletterService.getAllSubscribersById(id);
         if(!subscribers.isEmpty()) {
             model.addAttribute("Subscribers", subscribers);
             return "subscribers by id";
         }else{
             return "subscribers not found";
         }
         }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteNewsletter(@PathVariable Integer id) {
        newsletterService.deleteNewsletter(id);
        return ResponseEntity.ok("Delete successfully");
    }
     }


