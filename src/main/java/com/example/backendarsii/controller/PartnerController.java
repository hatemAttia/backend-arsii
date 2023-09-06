package com.example.backendarsii.controller;


import com.example.backendarsii.service.PartnerService;
import com.example.backendarsii.dto.PartnerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/partner")
public class PartnerController {

    public PartnerService partnerService;

    @GetMapping("/allpartner")
    public ResponseEntity<List<PartnerDto>> getAllPartners() {
        List<PartnerDto> partners = partnerService.getAllPartners();
        return ResponseEntity.ok(partners);
    }
    @GetMapping("/{id}")
    public ResponseEntity<PartnerDto> getPartnerById(@PathVariable Long id) {
        PartnerDto partner = partnerService.getPartnerById(id);
        return ResponseEntity.ok(partner);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<PartnerDto> updatePartner(@PathVariable Long id, @RequestBody PartnerDto partnerDto) {
        PartnerDto updatedPartner = partnerService.updatePartner(id, partnerDto);
        return ResponseEntity.ok(updatedPartner);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePartner(@PathVariable Long id) {
        partnerService.deletePartner(id);
        return ResponseEntity.noContent().build();
    }

}
