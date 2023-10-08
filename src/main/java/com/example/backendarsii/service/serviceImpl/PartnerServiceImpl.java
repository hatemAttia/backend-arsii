package com.example.backendarsii.service.serviceImpl;

import com.example.backendarsii.dto.requestDto.PartnerRequest;
import com.example.backendarsii.dto.responseDto.PartnerResponse;
import com.example.backendarsii.entity.Partner;
import com.example.backendarsii.exception.ConflictException;
import com.example.backendarsii.exception.NotFoundException;
import com.example.backendarsii.repository.PartnerRepository;
import com.example.backendarsii.service.PartnerService;
import com.example.backendarsii.utils.FileStorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PartnerServiceImpl implements PartnerService {

    private final PartnerRepository partnerRepository;
    @Autowired
    private FileStorageService fileStorageService;


    @Override
    public void addPartner(PartnerRequest partnerRequest) {
        if (partnerRepository.existsByName(partnerRequest.getName())) {
            throw new ConflictException(String.format("this name ([%s]) is already exist ", partnerRequest.getName()));
        }
        Partner partner = Partner.builder()
                .name(partnerRequest.getName())
                .description(partnerRequest.getDescription())
                .address(partnerRequest.getAddress())
                .contact(partnerRequest.getContact())
                .type(partnerRequest.getType())
                .image(partnerRequest.getImage())
                .build();

        partnerRepository.save(partner);
    }

    @Override
    public List<PartnerResponse> getAllPartner() {
        List<Partner> partners = partnerRepository.findAll();
        List<PartnerResponse> partnerResponses = new ArrayList<>();

        for (Partner partner : partners) {
            PartnerResponse partnerResponse = PartnerResponse.makePartner(partner);
            partnerResponses.add(partnerResponse);
        }
        return partnerResponses;
    }

    @Override
    public PartnerResponse getPartnerByID(Long id) {
        Partner partner = partnerRepository.findById(id).orElseThrow(
                () -> new NotFoundException(String.format("this id[%s] is not exist", id)));

        return PartnerResponse.makePartner(partner);

    }

    @Override
    public void updatePartner(Long id, PartnerRequest partnerRequest) {

        Partner partner = partnerRepository.findById(id).orElseThrow(
                () -> new NotFoundException(String.format("this id[%s] is not exist", id)));
        if (!partner.getName().equals(partnerRequest.getName()) && partnerRepository.existsByName(partnerRequest.getName())) {
            throw new ConflictException(String.format("this name is already exist ( [%s] ) ", partnerRequest.getName()));
        }

        if (partnerRequest.getName() != null) {
            partner.setName(partnerRequest.getName());
        }
        if (partnerRequest.getDescription() != null) {
            partner.setDescription(partnerRequest.getDescription());
        }
        if (partnerRequest.getAddress() != null) {
            partner.setAddress(partnerRequest.getAddress());
        }
        if (partnerRequest.getContact() != null) {
            partner.setContact(partnerRequest.getContact());
        }
        if (partnerRequest.getType() != null) {
            partner.setType(partnerRequest.getType());
        }
        if (partnerRequest.getImage() != null) {
            partner.setImage(partnerRequest.getImage());
        }


        partnerRepository.save(partner);

    }

    @Override
    public void deletePartner(Long id) {
        if (!partnerRepository.existsById(id)) {
            throw new NotFoundException(String.format("this id[%s] is not exist", id));
        }
        partnerRepository.deleteById(id);
    }


}
