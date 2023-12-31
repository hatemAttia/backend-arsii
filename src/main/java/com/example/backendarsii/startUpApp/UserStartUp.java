package com.example.backendarsii.startUpApp;

import com.example.backendarsii.dto.requestDto.RegisterRequest;
import com.example.backendarsii.utils.enumData.Gender;
import com.example.backendarsii.utils.enumData.Office;
import com.example.backendarsii.utils.enumData.Post;
import com.example.backendarsii.utils.enumData.Role;
import com.example.backendarsii.entity.User;
import com.example.backendarsii.repository.UserRepository;
import com.example.backendarsii.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;



@Component
@RequiredArgsConstructor
public class UserStartUp implements CommandLineRunner {
    private final AuthenticationService authenticationService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public void run(String... args) throws Exception {
        authenticationService.register(new RegisterRequest("Skandar",
                "Mbarek",
                "SkandarMB",
                "skandar.MB50@gmail.com",
                "Skandar_mb50**",
                Gender.male,
                "93255601",
                "Bembla",
                "Batal",
                "fi dar",
                Office.OFFICE_SOUSSE,
                "https://www.overleaf.com/login?"));
        authenticationService.register(new RegisterRequest("ali",
                "salem",
                "alisalem",
                "ali.salem@gmail.com",
                "Skandar_mb50**",
                Gender.male,
                "93255601",
                "sousse",
                "ingenieur",
                "fi dar",
                Office.OFFICE_SOUSSE,
                "https://www.overleaf.com/login?"));
        userRepository.save(new User(
                null,
                "mohamed",
                "ali",
                "mohamedAli",
                "mohamedAli@gmail.com",
                passwordEncoder.encode("Skandar_mb50**"),
                Gender.male,
                "21333444",
                "khnis",
                "civil engineering",
                "Gloulou",
                Post.GENERAL_SECRETARY,
                Office.OFFICE_SOUSSE,
                "https://www.overleaf.com/login?",
                null,
                null,
                null,
                Role.MEMBER,
                Boolean.FALSE


                ));
        userRepository.save(new User(
                null,
                "admin",
                "admin",
                "admin",
                "admin@gmail.com",
                passwordEncoder.encode("123"),
                Gender.male,
                "21333444",
                "admin",
                "admin",
                "admin",
                Post.NATIONAL_PRESIDENT,
                Office.OFFICE_SOUSSE,
                "https://www.overleaf.com/login?",
                null,
                null,
                null,
                Role.ADMIN,
                Boolean.FALSE


        ));
    }

}
