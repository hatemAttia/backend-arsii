package com.example.backendarsii.service.serviceImpl;

import com.example.backendarsii.dto.PartnerDto;
import com.example.backendarsii.dto.UserDto;
import com.example.backendarsii.entity.Partner;
import com.example.backendarsii.entity.User;
import com.example.backendarsii.exception.NotFoundException;
import com.example.backendarsii.repository.PartnerRepository;
import com.example.backendarsii.service.PartnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PartnerServiceImpl implements PartnerService {

    private PartnerRepository partnerRepository;

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
    public PartnerDto getPartnerById(Long id) {
        Optional<Partner> optionalPartner = partnerRepository.findById(id);
        if (optionalPartner.isPresent()) {
            Partner partner = optionalPartner.get();
            return PartnerDto.makePartner(partner);
        } else {
            throw new NotFoundException("Partner with ID : " + id );
        }
    }
    @Override
    public void deletePartner(Long id) {
        partnerRepository.deleteById(id);

    }
    @Override
    public PartnerDto updatePartner(Long id, PartnerDto partnerDto) {
        Optional<Partner> optionalPartner = partnerRepository.findById(id);

        if (optionalPartner.isPresent()) {
            Partner existingPartner = optionalPartner.get();
            existingPartner.setName(partnerDto.getName());
            existingPartner.setAdress(partnerDto.getAdress());
            existingPartner.setType(partnerDto.getType());
            existingPartner.setContact(partnerDto.getContact());
            existingPartner.setDescription(partnerDto.getDescription());
            Partner updatedPartner = partnerRepository.save(existingPartner);
            return PartnerDto.makePartner(updatedPartner);
        } else {
            throw new NotFoundException("Partner with ID : " + id);
        }

    }
}
