package com.example.backendarsii.service.serviceImpl;

import com.example.backendarsii.dto.responseDto.CategoryResponse;
import com.example.backendarsii.dto.responseDto.CompetenceResponse;
import com.example.backendarsii.dto.requestDto.CompetenceRequest;
import com.example.backendarsii.entity.Category;
import com.example.backendarsii.entity.Competence;
import com.example.backendarsii.exception.ConflictException;
import com.example.backendarsii.exception.NotFoundException;
import com.example.backendarsii.repository.CategoryRepository;
import com.example.backendarsii.repository.CompetenceRepository;
import com.example.backendarsii.service.CompetenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CompetenceServiceImpl implements CompetenceService {

    private final CompetenceRepository competenceRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public void addCompetence(CompetenceRequest competenceRequest) {
        if(competenceRepository.existsByName(competenceRequest.getName())){
            throw new ConflictException(String.format("this name ([%s]) is already exist ",competenceRequest.getName()));
        }
        Category category = categoryRepository.findById(competenceRequest.getCategoryId()).orElseThrow(
                ()-> new NotFoundException(String.format("this CategoryId [%s] is not exist ",competenceRequest.getCategoryId())));
        Competence competence = Competence.builder()
                .name(competenceRequest.getName())
                .description(competenceRequest.getDescription())
                .category(category)
                .build();
        competenceRepository.save(competence);
    }

    @Override
    public List<CompetenceResponse> getAllCompetence() {
        List<Competence> competences = competenceRepository.findAll();
        List<CompetenceResponse> competenceResponses = new ArrayList<>();
        for (Competence competence:competences) {
            CompetenceResponse competenceResponse = CompetenceResponse.makeCompetence(competence);
            competenceResponses.add(competenceResponse);
        }
        return competenceResponses;
    }

    @Override
    public CompetenceResponse getCompetenceById(Long id) {

        Competence competence = competenceRepository.findById(id).orElseThrow(
                ()-> new NotFoundException(String.format("this CategoryId [%s] is not exist ",id)));

        return CompetenceResponse.makeCompetence(competence);
    }

    @Override
    public void deleteCompetence(Long id) {

        if (!competenceRepository.existsById(id)){
            throw new NotFoundException(String.format("this id[%s] is not exist",id));
        }
        competenceRepository.deleteById(id);
    }

    @Override
    public void updateCompetence(Long id, CompetenceRequest competenceRequest) {

        Competence competence = competenceRepository.findById(id).orElseThrow(
                ()->new NotFoundException(String.format("this id[%s] is not exist",id)));
        if(!competence.getName().equals(competenceRequest.getName()) && competenceRepository.existsByName(competenceRequest.getName())){
            throw  new ConflictException(String.format("this name is already exist ( [%s] ) ",competenceRequest.getName()));
        }
        Category category = categoryRepository.findById(competenceRequest.getCategoryId()).orElseThrow(
                ()->new NotFoundException(String.format("this Category with id[%s] is not exist",id)));

        competence.setName(competenceRequest.getName());
        competence.setDescription(competenceRequest.getDescription());
        competence.setCategory(category);

        competenceRepository.save(competence);




    }
}
