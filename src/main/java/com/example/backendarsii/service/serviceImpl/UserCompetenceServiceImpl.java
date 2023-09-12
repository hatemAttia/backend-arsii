package com.example.backendarsii.service.serviceImpl;

import com.example.backendarsii.dto.requestDto.UserCompetenceRequest;
import com.example.backendarsii.dto.responseDto.UserCompetenceResponse;
import com.example.backendarsii.dto.responseDto.UserResponse;
import com.example.backendarsii.entity.Competence;
import com.example.backendarsii.entity.User;
import com.example.backendarsii.entity.UserCompetence;
import com.example.backendarsii.exception.NotFoundException;
import com.example.backendarsii.repository.CompetenceRepository;
import com.example.backendarsii.repository.UserCompetenceRepository;
import com.example.backendarsii.repository.UserRepository;
import com.example.backendarsii.service.UserCompetenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserCompetenceServiceImpl implements UserCompetenceService {

    private final UserRepository userRepository;
    private final CompetenceRepository competenceRepository;
    private final UserCompetenceRepository userCompetenceRepository;
    @Override
    public void addUserCompetence(UserCompetenceRequest userCompetenceRequest) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();
        Optional<User> user = userRepository.findByUserName(currentUserName);
        if (user.isEmpty()){
            throw new NotFoundException("mafamech User *************");
        }
        Competence competence = competenceRepository.findById(userCompetenceRequest.getCompetenceId()).orElseThrow(
                ()-> new NotFoundException(String.format("this Competence with id [%s] is not exist",userCompetenceRequest.getCompetenceId())));
        UserCompetence userCompetence = UserCompetence.builder()
                .competence(competence)
                .user(user.get())
                .level(userCompetenceRequest.getLevel())
                .build();
        userCompetenceRepository.save(userCompetence);

    }

    @Override
    public void updateUserCompetence(Long id , UserCompetenceRequest userCompetenceRequest) {

        UserCompetence userCompetence = userCompetenceRepository.findById(id).orElseThrow(
                ()-> new NotFoundException(String.format("this UserCompetence with id [%s] is not exist",id)));
        Competence competence = competenceRepository.findById(userCompetenceRequest.getCompetenceId()).orElseThrow(
                ()-> new NotFoundException(String.format("this Competence with id [%s] is not exist",userCompetenceRequest.getCompetenceId())));

        userCompetence.setCompetence(competence);
        userCompetence.setLevel(userCompetenceRequest.getLevel());

        userCompetenceRepository.save(userCompetence);
    }

    @Override
    public List<UserCompetenceResponse> getAllCompetenceByUser(Long id) {

        List<UserCompetence> userCompetences = userCompetenceRepository.findAllByUserId(id);
        List<UserCompetenceResponse> userCompetenceResponses = new ArrayList<>();
            for (UserCompetence userCompetence : userCompetences) {
                UserCompetenceResponse userCompetenceResponse = UserCompetenceResponse.makeUserCompetence(userCompetence);
                userCompetenceResponses.add(userCompetenceResponse);
            }
        return userCompetenceResponses;
    }

    @Override
    public List<UserResponse> getAllUserByCompetence(Long id) {

        List<UserCompetence> userCompetences = userCompetenceRepository.findAllByCompetenceId(id);
        List<UserResponse> userDtos = new ArrayList<>();
        for (UserCompetence userCompetence  : userCompetences) {
            UserResponse userDto = UserResponse.makeUser(userCompetence.getUser());
            userDtos.add(userDto);
        }
        return userDtos;
    }

    @Override
    public void deleteUserCompetence(Long id) {
        if (!userCompetenceRepository.existsById(id)){
            throw new NotFoundException(String.format("this userCompetence with id [%s] is not exist",id));
        }
        userCompetenceRepository.deleteById(id);

    }
}
