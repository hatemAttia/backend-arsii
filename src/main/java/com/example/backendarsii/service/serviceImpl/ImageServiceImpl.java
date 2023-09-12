package com.example.backendarsii.service.serviceImpl;

import com.example.backendarsii.entity.Image;
import com.example.backendarsii.repository.ImageRepository;
import com.example.backendarsii.service.ImageService;
import com.example.backendarsii.utils.ImageUtility;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {

    private final ImageRepository imageRepository;

    @Transactional
    @Override
    public void uploadImage(MultipartFile file) throws IOException {

        imageRepository.save(Image.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .image(ImageUtility.compressImage(file.getBytes())).build());

    }

    @Override
    public Image getImageDetails(String name) {
        Image dbImage = imageRepository.findByName(name).orElseThrow();
        return Image.builder()
                .name(dbImage.getName())
                .type(dbImage.getType())
                .image(ImageUtility.decompressImage(dbImage.getImage()))
                .build();
    }


}
