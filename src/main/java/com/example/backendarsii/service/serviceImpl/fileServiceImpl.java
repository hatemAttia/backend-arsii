package com.example.backendarsii.service.serviceImpl;


import com.example.backendarsii.config.UtilsConfiguration;
import com.example.backendarsii.entity.User;
import com.example.backendarsii.exception.NotFoundException;
import com.example.backendarsii.service.fileService;
import com.example.backendarsii.utils.FileStorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class fileServiceImpl implements fileService {

    @Autowired
    private FileStorageService fileStorageService;

    @Override
    public String uploadImage(MultipartFile file) {
        if (UtilsConfiguration.isImage(Objects.requireNonNull(file.getContentType()))){
            return fileStorageService.storeFile(file);

        }else{
            throw new RuntimeException("mahiyech image****************");
        }

    }

    @Override
    public Resource serveFile(String fileName) {
        return fileStorageService.loadFileAsResource(fileName);
    }

    @Override
    public String uploadPDF(MultipartFile file) {

        if (UtilsConfiguration.isPdf(Objects.requireNonNull(file.getContentType()))){

            return fileStorageService.storeFile(file);

        }else{
            throw new RuntimeException("mahouwech PDF image****************");
        }
    }
}
