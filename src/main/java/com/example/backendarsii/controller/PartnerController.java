package com.example.backendarsii.controller;


import com.example.backendarsii.dto.PartnerRequest;
import com.example.backendarsii.service.PartnerService;
import com.example.backendarsii.dto.PartnerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/partner")
@Transactional
public class PartnerController {

     @Autowired
    private PartnerService partnerService;

    @PostMapping
    public  ResponseEntity<String> createPartner(@RequestBody @Valid PartnerRequest partnerRequest){
        if (partnerRequest != null) {
            partnerService.createPartner(partnerRequest);
            return ResponseEntity.ok("Partner created successfully");
        } else {
            return ResponseEntity.badRequest().body("Invalid partner data");
        }}
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePartner(@PathVariable Integer id) {
        partnerService.deletePartner(id);
        //return ResponseEntity.noContent().build();
        return ResponseEntity.ok("Delete successfully");
        }
    @GetMapping("/allpartner")
    public ResponseEntity<List<PartnerDto>> getAllPartners() {
        List<PartnerDto> partners = partnerService.getAllPartners();
        return ResponseEntity.ok(partners);}
    @GetMapping("/{id}")
    public ResponseEntity<PartnerDto> getPartnerById(@PathVariable Integer id) {
        PartnerDto partner = partnerService.getPartnerById(id);
        return ResponseEntity.ok(partner);}
    @PutMapping("/update/{id}")
    public ResponseEntity<PartnerDto> updatePartner(@PathVariable Integer id, @RequestBody PartnerRequest partnerRequest) {
        PartnerDto updatedPartner = partnerService.updatePartner(id, partnerRequest);
        return ResponseEntity.ok(updatedPartner);}


}
