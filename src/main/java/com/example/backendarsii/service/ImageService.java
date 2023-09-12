package com.example.backendarsii.service;

import com.example.backendarsii.entity.Image;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


public interface ImageService {

    void uploadImage(MultipartFile file) throws IOException;

    Image getImageDetails(String name);


}
