package com.example.backendarsii.service.serviceImpl;

import com.example.backendarsii.dto.PartnerDto;
import com.example.backendarsii.dto.PartnerRequest;
import com.example.backendarsii.entity.Partner;
import com.example.backendarsii.exception.NotFoundException;
import com.example.backendarsii.repository.PartnerRepository;
import com.example.backendarsii.service.PartnerService;
import io.swagger.annotations.Scope;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class PartnerServiceImpl implements PartnerService {

    private final PartnerRepository partnerRepository;

    @Override
    public void createPartner(@org.jetbrains.annotations.NotNull PartnerRequest partnerRequest) {
        Partner partner = Partner.builder()
                .name(partnerRequest.getName())
                .address(partnerRequest.getAddress())
                .contact(partnerRequest.getContact())
                .description(partnerRequest.getDescription())
                .type(partnerRequest.getType())
                .build();
         partnerRepository.save(partner);
    }

    @Override
    public List<PartnerDto> getAllPartners() {
        List<Partner> partners = partnerRepository.findAllPartners();
        List<PartnerDto> partnerDtos = new ArrayList<>();

        for (Partner partner : partners) {
            PartnerDto partnerDto = PartnerDto.makePartner(partner);
            partnerDtos.add(partnerDto);
        }
        return partnerDtos;
    }

    @Override
    public PartnerDto getPartnerById(Integer id) {
        Optional<Partner> optionalPartner = partnerRepository.findById(id);
        if (optionalPartner.isPresent()) {
            Partner partner = optionalPartner.get();
            return PartnerDto.makePartner(partner);
        } else {
            throw new NotFoundException("Partner with ID : " + id );
        }
    }
    @Override
    public void deletePartner(Integer id) {
        partnerRepository.deleteById(id);

    }
    @Override
    public PartnerDto updatePartner(Integer id, PartnerRequest partnerRequest) {
        Optional<Partner> optionalPartner = partnerRepository.findById(id);

        if (optionalPartner.isPresent()) {
            Partner existingPartner = optionalPartner.get();
            existingPartner.setName(partnerRequest.getName());
            existingPartner.setAddress(partnerRequest.getAddress());
            existingPartner.setType(partnerRequest.getType());
            existingPartner.setContact(partnerRequest.getContact());
            existingPartner.setDescription(partnerRequest.getDescription());
            partnerRepository.save(existingPartner);
            return PartnerDto.makePartner(existingPartner);
        } else {
            throw new NotFoundException("Partner with ID : " + id);
        }

    }
}
