package com.example.backendarsii.service.serviceImpl;

import com.example.backendarsii.dto.CompetenceDTO;
import com.example.backendarsii.dto.requestDto.CompetenceRequest;
import com.example.backendarsii.entity.Competence;
import com.example.backendarsii.repository.CompetenceRepository;
import com.example.backendarsii.service.CompetenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompetenceServiceImpl implements CompetenceService {

    private final CompetenceRepository competenceRepository;

    @Override
    public void addCompetence(CompetenceRequest competenceRequest) {

    }

    @Override
    public List<CompetenceDTO> getAllCompetence() {
        return null;
    }

    @Override
    public CompetenceDTO getCompetenceById(Long id) {
        return null;
    }

    @Override
    public void deleteCompetence(Long id) {

    }

    @Override
    public void updateCompetence(Long id, CompetenceRequest competenceRequest) {

    }
}
